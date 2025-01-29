// SPDX-License-Identifier: MIT
pragma solidity ^0.8.26;

contract NPC {
    uint256[] public hand;
    bool public isActive;
    address public owner;

    constructor() {
        owner = msg.sender;
        isActive = true;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Not an owner");
        _;
    }

    function initializeHand() external {
        hand = new uint256[](2);
        hand[0] = 1;
        hand[1] = 10;
    }

    function calculateHandValue() external view returns (uint256) {
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

    function contactBriber(address _briber) external onlyOwner {
        (bool result, ) = _briber.delegatecall(
            abi.encode(bytes4(keccak256("bribe()")))
        );
        require(result, "Transaction invalid");
    }
}

