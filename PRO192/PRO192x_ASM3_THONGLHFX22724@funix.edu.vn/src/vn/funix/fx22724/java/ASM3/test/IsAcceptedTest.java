package vn.funix.fx22724.java.ASM3.test;

import org.junit.jupiter.api.Test;
import vn.funix.fx22724.java.ASM3.models.LoanAccount;
import vn.funix.fx22724.java.ASM3.models.SavingsAccount;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsAcceptedTest {

    @Test
    void savingAccount_isAccepted_true() {
        SavingsAccount acc = new SavingsAccount("111111", 5_000_000, "SAVINGS");
        assertTrue(acc.isAccepted(500_000));
    }

    @Test
    void savingAccount_isAccepted_false() {
        SavingsAccount acc = new SavingsAccount("111111", 100000, "SAVINGS");
        assertFalse(acc.isAccepted(500000));
    }

    @Test
    void loanAccount_isAccepted_true() {
        LoanAccount acc = new LoanAccount("222222", 20000000, "LOAN");
        assertTrue(acc.isAccepted(5000000));
    }
}
