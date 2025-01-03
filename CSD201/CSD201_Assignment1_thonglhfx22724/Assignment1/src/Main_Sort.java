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
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Input number of elements: ");
                    int n = scanner.nextInt();
                    arr = new float[n];
                    System.out.println("Input elements:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextFloat();
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
                    algo.bubbleSort(arr);
                    break;
                case 4:
                    algo.selectionSort(arr);
                    break;
                case 5:
                    algo.insertionSort(arr);
                    break;
                case 6:
                    System.out.print("Input value: ");
                    float value = scanner.nextFloat();
                    algo.linearSearch(arr, value);
                    break;
                case 7:
                    System.out.print("Input value: ");
                    value = scanner.nextFloat();
                    int result = algo.binarySearch(algo.bubbleSort(arr), value);
                    System.out.println("Index of first element: " + result);
                    break;
                case 0:
                    System.out.println("Thanks!!!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
