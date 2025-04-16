package vn.funix.fx22724.java.asm04.dao;

import vn.funix.fx22724.java.asm04.model.Account;
import vn.funix.fx22724.java.asm04.service.BinaryFileService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AccountDao {
    private static String FILE_PATH = "store/accounts.dat";
    static void save(List<Account> accounts) throws IOException {
        BinaryFileService.writeFile(FILE_PATH, accounts);
    }
    public static List<Account> list() {
        try {
            return BinaryFileService.readFile(FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void update(Account editAccount) {
        List<Account> accounts = list();
        boolean hasExist = accounts.stream().anyMatch(account-> account.getAccountNumber().equals(editAccount.getAccountNumber()));
    }
}
