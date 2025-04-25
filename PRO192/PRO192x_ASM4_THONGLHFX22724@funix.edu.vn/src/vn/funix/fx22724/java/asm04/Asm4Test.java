package vn.funix.fx22724.java.asm04;


import vn.funix.fx22724.java.asm04.model.*;
import vn.funix.fx22724.java.asm04.common.*;
import vn.funix.fx22724.java.asm04.dao.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Asm4Test {

//    private SavingsAccount savingsAccount;
//
//    // 1. Test withdraw()
//    @Test
//    void testWithdraw_SavingAccount_Success() {
//        savingsAccount = new SavingAccount("123456", 1_000_000);
//        assertTrue(account.withdraw(500_000));
//        assertEquals(500_000, account.getBalance());
//    }
//
//    // 2. Test isAccepted()
//    @Test
//    void testIsAccepted_SavingAccount() {
//        savingsAccount = new SavingAccount("111111", 1_000_000);
//        assertTrue(account.isAccepted(500_000));
//    }
//
//    @Test
//    void testIsAccepted_LoanAccount() {
//        LoanAccount account = new LoanAccount("222222", 1_000_000);
//        assertTrue(account.isAccepted(100_000));
//    }
//
//    // 3. Test getFee()
//    @Test
//    void testGetFee() {
//        savingsAccount = new SavingAccount("123456", 1_000_000);
//        assertEquals(11000, account.getFee(1_000_000)); // Ví dụ phí cố định
//    }
//
//    // 4. Test validateAccount()
//    @Test
//    void testValidateAccount() {
//        assertTrue(Account.validateAccount("123456"));
//        assertFalse(Account.validateAccount("12ab56"));
//    }
//
//    // 5. Test isAccountPremium()
//    @Test
//    void testIsAccountPremium() {
//        SavingAccount premiumAcc = new SavingAccount("654321", 11_000_000);
//        assertTrue(premiumAcc.isAccountPremium());
//
//        SavingAccount normalAcc = new SavingAccount("111111", 5_000_000);
//        assertFalse(normalAcc.isAccountPremium());
//    }
//
//    // 6. Test getCustomerById()
//    @Test
//    void testGetCustomerById() {
//        Bank bank = new Bank();
//        Customer customer = new Customer("Nguyen Van A", "012345678912");
//        bank.addCustomer(customer);
//        assertEquals(customer, bank.getCustomerById("012345678912"));
//    }
//
//    // 7. Test isCustomerExisted()
//    @Test
//    void testIsCustomerExisted() {
//        Bank bank = new Bank();
//        bank.addCustomer(new Customer("Nguyen Van A", "012345678912"));
//        assertTrue(bank.isCustomerExisted("012345678912"));
//        assertFalse(bank.isCustomerExisted("111111111111"));
//    }
//
//    // 8. Test isAccountExisted()
//    @Test
//    void testIsAccountExisted() {
//        Bank bank = new Bank();
//        Customer customer = new Customer("Nguyen Van A", "012345678912");
//        Account acc = new SavingAccount("123456", 1_000_000);
//        customer.addAccount(acc);
//        bank.addCustomer(customer);
//        assertTrue(bank.isAccountExisted("123456"));
//    }
//
//    // 9. Test getTotalAccountBalance()
//    @Test
//    void testGetTotalAccountBalance() {
//        Customer customer = new Customer("Nguyen Van A", "012345678912");
//        customer.addAccount(new SavingAccount("111111", 1_000_000));
//        customer.addAccount(new SavingAccount("222222", 2_000_000));
//        assertEquals(3_000_000, customer.getTotalAccountBalance());
//    }
//
//    // 10. Test isCustomerPremium()
//    @Test
//    void testIsCustomerPremium() {
//        Customer customer = new Customer("Nguyen Van A", "012345678912");
//        customer.addAccount(new SavingAccount("111111", 11_000_000));
//        assertTrue(customer.isCustomerPremium());
//    }
//
//    // 11. Test getAccountByAccountNumber()
//    @Test
//    void testGetAccountByAccountNumber() {
//        Customer customer = new Customer("Nguyen Van A", "012345678912");
//        Account acc = new SavingAccount("111111", 5_000_000);
//        customer.addAccount(acc);
//        assertEquals(acc, customer.getAccountByAccountNumber("111111"));
//    }
//
//    // 12. Test validateCustomerId()
//    @Test
//    void testValidateCustomerId() {
//        assertTrue(Customer.validateCustomerId("012345678912"));
//        assertFalse(Customer.validateCustomerId("abc123"));
//    }
//
//    // 13. Test transfer
//    @Test
//    void testTransferSuccess() {
//        Account from = new SavingAccount("111111", 2_000_000);
//        Account to = new SavingAccount("222222", 1_000_000);
//        boolean result = Bank.transfer(from, to, 1_000_000);
//        assertTrue(result);
//        assertEquals(1_000_000, from.getBalance());
//        assertEquals(2_000_000, to.getBalance());
//    }
//
//    // 14. Test File I/O - đọc file lỗi
//    @Test
//    void testReadFileException() {
//        assertThrows(IOException.class, () -> {
//            Bank.readFromFile("non_existing_file.txt");
//        });
//    }
}
