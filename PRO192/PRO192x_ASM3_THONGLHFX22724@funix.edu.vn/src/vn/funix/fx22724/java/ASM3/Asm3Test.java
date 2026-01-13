//package vn.funix.fx22724.java.ASM3;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import vn.funix.fx22724.java.ASM3.models.SavingsAccount;
//import vn.funix.fx22724.java.ASM3.models.LoanAccount;
//
//public class Asm3Test {
//
//    private SavingsAccount savingsAccount;
//    private LoanAccount loanAccount;
//
//    @BeforeEach
//    void setUp() {
//        savingsAccount = new SavingsAccount("123456", 10000000, "SAVINGS");
//        loanAccount = new LoanAccount("654321", 10000000, "LOAN");
//    }
//
//    @Test
//    void testSavingsAccountWithdrawAccepted() {
//        assertTrue(savingsAccount.withdraw(1000000));
//        assertEquals(9000000, savingsAccount.getBalance());
//    }
//
//    @Test
//    void testSavingsAccountWithdrawRejected() {
//        assertFalse(savingsAccount.withdraw(100000000)); // vượt hạn mức
//    }
//
//    @Test
//    void testLoanAccountWithdrawAccepted() {
//        assertTrue(loanAccount.withdraw(2000000));
//        assertEquals(7900000, loanAccount.getBalance());
//    }
//
//    @Test
//    void testLoanAccountWithdrawRejected() {
//        assertFalse(loanAccount.withdraw(100000000));
//    }
//
//    @Test
//    void testSavingsAccountIsAccepted() {
//        assertTrue(savingsAccount.isAccepted(1000000));
//        assertFalse(savingsAccount.isAccepted(10000000));
//    }
//
//    @Test
//    void testLoanAccountIsAccepted() {
//        assertTrue(loanAccount.isAccepted(1000000));
//        assertFalse(loanAccount.isAccepted(100000000));
//    }
//}
