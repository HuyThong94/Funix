package lap15.lap15_2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Lap15_2 {
    public static void main(String[] args) {
        try {
            // Đọc điểm của Bob từ file
            List<Integer> bobDices = readDices("bob.txt");
            System.out.println("Bob's dices: " + bobDices);

            // Đọc điểm của Alice từ file
            List<Integer> aliceDices = readDices("alice.txt");
            System.out.println("Alice's dices: " + aliceDices);

            // Xác định người chiến thắng
            String winner = getWinner(bobDices, aliceDices);
            if (winner == null) {
                System.out.println("Two people have equal points.");
            } else {
                System.out.println("The winner is " + winner);
            }

        } catch (InvalidDiceException | NumberRollDiceNotEqualException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("The file contains non-numeric data.");
        }
    }

    public static String getWinner(List<Integer> bobDices, List<Integer> aliceDices) {
        if (bobDices.size() != aliceDices.size()) {
            throw new NumberRollDiceNotEqualException("Number of dice rolls not equal");
        }

        Integer sumBob = sumOfDice(bobDices);
        Integer sumAlice = sumOfDice(aliceDices);

        if (Objects.equals(sumBob, sumAlice)) {
            return null;
        } else if (sumBob > sumAlice) {
            return "Bob";
        } else {
            return "Alice";
        }
    }

    public static Integer sumOfDice(List<Integer> dices) {
        int sum = 0;
        for (int dice : dices) {
            sum += dice;
        }
        return sum;
    }

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
}



