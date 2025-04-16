package vn.funix.fx22724.java.asm04.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TextFileService {
    private static final String COMMA_DELIMITER = ",";

    public static List<List<String>> readFile(String fileName) {
        List<List<String>> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.useDelimiter(COMMA_DELIMITER);
            while(scanner.hasNextLine()) {
                List<String> customer = new ArrayList<>();
                String customerText = scanner.nextLine();
                String[] customerArray = customerText.split(COMMA_DELIMITER);
                Collections.addAll(customer, customerArray);
                list.add(customer);
            }
        } catch (IOException e) {
//            e.printStackTrace();

            System.out.println("Tệp không tồn tại");
        }
            return list;
    }
}
