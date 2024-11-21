package lap15.lap15_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public static List<Integer> readDices(String fileName) throws FileNotFoundException, InputMismatchException {
    System.out.println("Read file: " + fileName);
    List<Integer> dices = new ArrayList<>();
    try (Scanner scanner = new Scanner(new FileReader(fileName))) {
        while (scanner.hasNextLine()) {
            int dice = scanner.nextInt();
            if (dice < 1 || dice > 6) {
                throw new InvalidDiceException("Dice value must be between 1 and 6: " + dice);
            }
            dices.add(dice);
        }
    }
    return dices;
}
