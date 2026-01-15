package vn.funix.fx22724.java.ASM3.test;

import org.junit.jupiter.api.Test;
import vn.funix.fx22724.java.ASM3.models.LoanAccount;
import vn.funix.fx22724.java.ASM3.models.SavingsAccount;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawTest {

    @Test
    void savingAccount_withdraw_success() {
        SavingsAccount acc = new SavingsAccount("123456", 1_000_000, "SAVINGS");
        assertTrue(acc.withdraw(200_000));
    }

    @Test
    void savingAccount_withdraw_fail_notEnoughMoney() {
        SavingsAccount acc = new SavingsAccount("123456", 100000, "SAVINGS");
        assertFalse(acc.withdraw(500000));
    }

    @Test
    void loanAccount_withdraw_success() {
        LoanAccount acc = new LoanAccount("654321", 10000000, "LOAN");
        assertTrue(acc.withdraw(1000000));
    }
}
