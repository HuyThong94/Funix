package vn.funix.fx22724.java.asm04.dao;

import vn.funix.fx22724.java.asm04.model.Customer;
import vn.funix.fx22724.java.asm04.service.BinaryFileService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CustomerDao {
    private static String FILE_PATH = "store/customer.dat";
    static void save(List<Customer> customers) throws IOException {
        BinaryFileService.writeFile(FILE_PATH, customers);
    }
    public static List<Customer> list() {
        try {
            return BinaryFileService.readFile(FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
