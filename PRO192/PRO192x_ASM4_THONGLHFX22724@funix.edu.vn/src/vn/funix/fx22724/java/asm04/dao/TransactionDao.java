package vn.funix.fx22724.java.asm04.dao;

import vn.funix.fx22724.java.asm04.model.Transaction;
import vn.funix.fx22724.java.asm04.service.BinaryFileService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TransactionDao {
    private static String FILE_PATH = "store/transactions.dat";
    static void save(List<Transaction> transactions) throws IOException {
        BinaryFileService.writeFile(FILE_PATH, transactions);
    }
    public static List<Transaction> list() {
        try {
            return BinaryFileService.readFile(FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
