package vn.funix.fx22724.java.asm04;

import vn.funix.fx22724.java.asm04.model.Account;

public interface Withdraw {
    boolean withdraw(double amount);
    boolean transfers(double amount, Account reveiveAccount);
    boolean isAccepted(double amount);
}
