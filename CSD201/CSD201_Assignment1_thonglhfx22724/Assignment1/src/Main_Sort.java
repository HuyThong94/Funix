import java.io.IOException;
import java.util.Scanner;

public class Main_Sort {
    public static void main(String[] args) {
        Algorithm algo = new Algorithm();
        Scanner scanner = new Scanner(System.in);
        float[] arr = null;

        while (true) {
            System.out.println("+-------------------Menu------------------+");
            System.out.println("|      1. Input                           |");
            System.out.println("|      2. Output                          |");
            System.out.println("|      3. Bubble sort                     |");
            System.out.println("|      4. Selection sort                  |");
            System.out.println("|      5. Insertion sort                  |");
            System.out.println("|      6. Search > value                  |");
            System.out.println("|      7. Search = value                  |");
            System.out.println("|      0. Exit                            |");
            System.out.println("+----------------------------------------+");
            int choice = inputInt(scanner, "Choice: ");

            switch (choice) {
                case 1:
                    int n;
                    do {
                        n = inputInt(scanner, "Input number of elements: ");
                        if (n <= 0 || n > 20) {
                            System.out.println("n phải trong khoảng 1 đến 20!");
                        }
                    } while (n <= 0 || n > 20);
                    arr = new float[n];
                    System.out.println("Input elements:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = inputFloat(scanner, "a[" + (i+1) + "] = ");
                    }
                    try {
                        algo.writeFile("INPUT.TXT", arr);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        arr = algo.readFile("INPUT.TXT");
                        System.out.print("Array a: ");
                        for (float num : arr) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    algoSort(scanner, algo,choice, arr);
                    break;
                case 0:
                    System.out.println("Thanks!!!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    public static int inputInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Chỉ được nhập số nguyên!");
                scanner.next();
            }
        }
    }
    public static void algoSort(Scanner scanner,Algorithm algo, int caseChoice, float[] arr){
        float value = 0;
        if (arr == null || arr.length == 0) {
            System.out.println("Chưa có dữ liệu! Vui lòng chọn 1 hoặc 2 trước.");
            return;
        }
        switch (caseChoice){
            case 3:
                algo.bubbleSort(arr);
                break;
            case 4:
                algo.selectionSort(arr);
                break;
            case 5:
                algo.insertionSort(arr);
                break;
            case 6:
                value = inputFloat(scanner, "Input value: ");
                algo.linearSearch(arr, value);
                break;
            case 7:
                value = inputFloat(scanner, "Input value: ");
                float[] b = algo.bubbleSort(arr);
                int result = algo.binarySearch(b, value);
                System.out.println("Index of first element: " + result);
                break;
        }
    }
    public static float inputFloat(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextFloat()) {
                return scanner.nextFloat();
            } else {
                System.out.println("Chỉ được nhập số!");
                scanner.next();
            }
        }
    }

}
