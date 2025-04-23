package vn.funix.fx22724.java.asm04.dao;

import vn.funix.fx22724.java.asm04.model.Account;
import vn.funix.fx22724.java.asm04.service.BinaryFileService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class AccountDao {
    private static final String FILE_PATH = "store/accounts.dat";

    public static void save(List<Account> accounts) throws IOException {
        BinaryFileService.writeFile(FILE_PATH, accounts);
    }

    public static List<Account> list() {
        try {
            return BinaryFileService.readFile(FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //    public static void update(Account editAccount) {
//        List<Account> accounts = list();
//        boolean hasExist = accounts.stream().anyMatch(account -> account.getAccountNumber().equals(editAccount.getAccountNumber()));
//
//        List<Account> updatedAccounts;
//        if (hasExist) {
//            accounts.removeIf(acc -> acc.getAccountNumber().equals(editAccount.getAccountNumber()));
//            updatedAccounts = new ArrayList<>(accounts);
//            updatedAccounts.add(editAccount);
//        } else {
//            updatedAccounts = new ArrayList<>();
//            for (Account account : accounts) {
//                if (account.getAccountNumber().equals(editAccount.getAccountNumber())) {
//                    updatedAccounts.add(editAccount);
//                } else {
//                    updatedAccounts.add(account);
//                }
//            }
//        }
//        try {
//            save(updatedAccounts);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static void update(Account editAccount) {
        List<Account> accounts = list(); // Giả sử phương thức này đọc từ file

        final int MAX_THREAD = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD);
        List<Future<Boolean>> futures = new ArrayList<>();

        for (Account account : accounts) {
            futures.add(((java.util.concurrent.ExecutorService) executorService).submit(() ->
                    account.getAccountNumber().equals(editAccount.getAccountNumber())
            ));
        }

        boolean hasExist = false;
        for (Future<Boolean> future : futures) {
            try {
                if (future.get()) {
                    hasExist = true;
                    break;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        List<Account> updatedAccounts;
        if (hasExist) {
            // Nếu đã tồn tại thì xóa bản cũ và thêm bản mới
            updatedAccounts = accounts.parallelStream()
                    .filter(acc -> !acc.getAccountNumber().equals(editAccount.getAccountNumber()))
                    .collect(Collectors.toList());
            updatedAccounts.add(editAccount);
        } else {
            // Nếu chưa tồn tại thì thêm như bình thường
            updatedAccounts = new ArrayList<>(accounts);
            updatedAccounts.add(editAccount);
        }

        try {
            save(updatedAccounts); // Giả sử phương thức này ghi ra file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
