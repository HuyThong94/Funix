import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Algorithm {
    // Ghi dữ liệu vào file
    public void writeFile(String fileName, float[] arr) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (float num : arr) {
                writer.write(num + " ");
            }
        }
    }

    // Đọc dữ liệu từ file
    public float[] readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) return new float[0];
            String[] data = line.split(" ");
            float[] arr = new float[data.length];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Float.parseFloat(data[i]);
            }
            return arr;
        }
    }

    // Thuật toán Bubble Sort
//    public float[] bubbleSort(float[] arr) {
//        float[] sortedArr = arr.clone();
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT1.TXT"))) {
//            for (int i = 0; i < sortedArr.length - 1; i++) {
//                for (int j = 0; j < sortedArr.length - i - 1; j++) {
//                    if (sortedArr[j] > sortedArr[j + 1]) {
//                        float temp = sortedArr[j];
//                        sortedArr[j] = sortedArr[j + 1];
//                        sortedArr[j + 1] = temp;
//                    }
//                }
//                writeArrayStep(writer, sortedArr);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return sortedArr;
//    }

    public float[] bubbleSort(float[] a){
        float[] arr = a.clone();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("OUTPUT1.TXT"))) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        float temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                bw.write("Step " + (i + 1) + ": ");
                for (float x : arr) bw.write(x + " ");
                bw.newLine();
            }

            bw.close();

            System.out.print("Bubble sort result: ");
            for (float x : arr) System.out.print(x + " ");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    // Thuật toán Selection Sort
    public float[] selectionSort(float[] arr) {
        float[] sortedArr = arr.clone();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT2.TXT"))) {
            for (int i = 0; i < sortedArr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < sortedArr.length; j++) {
                    if (sortedArr[j] < sortedArr[minIndex]) {
                        minIndex = j;
                    }
                }
                float temp = sortedArr[minIndex];
                sortedArr[minIndex] = sortedArr[i];
                sortedArr[i] = temp;
                writeArrayStep(writer, sortedArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortedArr;
    }

    // Thuật toán Insertion Sort
    public float[] insertionSort(float[] arr) {
        float[] sortedArr = arr.clone();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT3.TXT"))) {
            for (int i = 1; i < sortedArr.length; i++) {
                float key = sortedArr[i];
                int j = i - 1;
                while (j >= 0 && sortedArr[j] > key) {
                    sortedArr[j + 1] = sortedArr[j];
                    j--;
                }
                sortedArr[j + 1] = key;
                writeArrayStep(writer, sortedArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortedArr;
    }

    // Linear Search
    public void linearSearch(float[] arr, float value) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                indices.add(i);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT4.TXT"))) {
            for (int index : indices) {
                writer.write(index + " ");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Indices: " + indices);
    }

    // Binary Search
    public int binarySearch(float[] arr, float value) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT5.TXT"))) {
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == value) {
                    result = mid;
                    right = mid - 1; // tìm tiếp bên trái
                } else if (arr[mid] < value) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            writer.write(result + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void writeArrayStep(BufferedWriter writer, float[] arr) throws IOException {
        for (float num : arr) {
            writer.write(num + " ");
        }
        writer.newLine();
    }
}
