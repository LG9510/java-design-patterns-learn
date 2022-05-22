package com.ligen.monitor;

import java.util.Arrays;

public class Bank {
    private final int[] accounts;

    public Bank(int accountNum,int baseAmount) {
        accounts = new int[accountNum];
        Arrays.fill(accounts, baseAmount);
    }
}
