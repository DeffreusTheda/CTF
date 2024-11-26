// SPDX-License-Identifier: MIT
pragma solidity ^0.8.26;

import "./Blackjack.sol";

contract Setup {
    Blackjack public blackjack;

    constructor() payable {
        blackjack = new Blackjack{value: 10 ether}();
    }

    function isSolved() public view returns (bool) {
        return address(blackjack).balance == 0;
    }
}

