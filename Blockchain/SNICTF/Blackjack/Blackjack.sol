// SPDX-License-Identifier: MIT
pragma solidity ^0.8.26;

import "./NPC.sol";

contract Blackjack {
    enum GameState {
        WaitingForPlayers,
        InProgress,
        Finished
    }
    GameState public state;

    struct Player {
        address playerAddress;
        uint256 bet;
        uint256[] hand;
        bool isActive;
    }

    Player public player;
    NPC public npc;
    address public owner;
    uint256[] public deck;
    uint256 public playerScore;
    mapping(string firstName => mapping(string lastName => address dealer)) uniqueDealers;
    mapping(bytes sig => address dealer) dealers;

    event GameStarted(address player);
    event PlayerHitted(address player, uint256 card);
    event PlayerStood(address player);
    event Winner(address winner);
    event GameEnded();

    constructor() payable {
        require(msg.value == 10 ether, "Dealer needs some ether");
        owner = msg.sender;
        npc = new NPC();
        bytes memory dealerSig = abi.encodePacked("1337", "Dealer");
        uniqueDealers["1337"]["Dealer"] = address(0xdeadbeef);
        dealers[dealerSig] = address(0xdeadbeef);
        state = GameState.WaitingForPlayers;
    }

    function startGame() external payable {
        require(
            state == GameState.WaitingForPlayers,
            "Game is already in progress"
        );
        require(msg.value > 0, "You must bet some Ether");

        player = Player(msg.sender, msg.value, new uint256[](0), true);
        npc.initializeHand();

        state = GameState.InProgress;
        emit GameStarted(msg.sender);
        shuffleDeck();
        dealInitialCards();
    }

    function shuffleDeck() internal {
        // Create a standard deck of cards (1-52)
        delete deck;
        for (uint256 i = 1; i <= 52; i++) {
            deck.push(i);
        }

        // Shuffle the deck (simple Fisher-Yates shuffle)
        for (uint256 i = deck.length - 1; i > 0; i--) {
            uint256 j = random(i);
            (deck[i], deck[j]) = (deck[j], deck[i]);
        }
    }

    function dealInitialCards() internal {
        player.hand.push(drawCard());
        player.hand.push(drawCard());
        playerScore = calculateHandValue(player.hand);
    }

    function drawCard() internal returns (uint256) {
        require(deck.length > 0, "No cards left in the deck");
        uint256 cardIndex = random(deck.length);
        uint256 card = deck[cardIndex];
        // Remove the card from the deck
        deck[cardIndex] = deck[deck.length - 1];
        deck.pop();
        return card;
    }

    function playerHit() external {
        require(state == GameState.InProgress, "Game not in progress");
        require(player.isActive, "Player is not active");

        uint256 card = drawCard();
        player.hand.push(card);
        playerScore = calculateHandValue(player.hand);

        emit PlayerHitted(msg.sender, card);

        if (playerScore > 21) {
            player.isActive = false;
            determineWinner();
        }
    }

    function playerStand() external {
        require(state == GameState.InProgress, "Game not in progress");
        require(player.isActive, "Player is not active");

        player.isActive = false;
        determineWinner();
    }

    function determineWinner() internal {
        uint256 npcScore = npc.calculateHandValue();
        if (playerScore > 21) {
            emit Winner(address(0x1337));
        } else if (npcScore >= playerScore) {
            emit Winner(address(0x1337));
        } else {
            (bool result, ) = payable(player.playerAddress).call{
                value: player.bet * 2
            }("");
            require(result, "Failed to transfer");
        }

        state = GameState.Finished;
        emit GameEnded();
    }

    function calculateHandValue(
        uint256[] memory hand
    ) internal pure returns (uint256) {
        uint256 totalValue = 0;
        uint256 aces = 0;

        for (uint256 i = 0; i < hand.length; i++) {
            uint256 cardValue = ((hand[i] - 1) % 13) + 1; // Get card value (1-13)
            if (cardValue == 1) {
                aces++;
                totalValue += 11; // Count ace as 11 initially
            } else if (cardValue >= 10) {
                totalValue += 10; // Face cards (10, J, Q, K) count as 10
            } else {
                totalValue += cardValue;
            }
        }

        // Adjust for aces
        while (totalValue > 21 && aces > 0) {
            totalValue -= 10; // Count ace as 1 instead of 11
            aces--;
        }

        return totalValue;
    }

    function bribeNPCAs(
        string memory _firstName,
        string memory _lastName,
        address _briber
    ) external {
        if (msg.sender == owner) {
            bytes memory _sig = abi.encodePacked(_firstName, _lastName);
            require(dealers[_sig] == address(0xdeadbeef), "Invalid signature");
            bribeNPC(_briber);
        } else {
            require(
                uniqueDealers[_firstName][_lastName] == address(0),
                "Must be a new dealer"
            );
            bytes memory _sig = abi.encodePacked(_firstName, _lastName);
            require(dealers[_sig] == address(0xdeadbeef), "Invalid signature");
            bribeNPC(_briber);
        }
    }

    function bribeNPC(address _briber) internal {
        npc.contactBriber(_briber);
    }

    function resetGame() external {
        state = GameState.WaitingForPlayers;
        delete player;
        playerScore = 0;
    }

    function random(uint256 max) internal view returns (uint256) {
        return
            uint256(
                keccak256(abi.encodePacked(block.timestamp, block.prevrandao))
            ) % max;
    }
}
