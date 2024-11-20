package vn.funix.fx22724.java.ASM3;

public interface Withdraw {
    boolean withdraw(double amount, boolean isPremium);
    boolean isAccepted(double amount, boolean isPremium);
}
