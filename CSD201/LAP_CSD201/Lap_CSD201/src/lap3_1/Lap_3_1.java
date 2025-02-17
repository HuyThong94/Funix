package lap3_1;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

public class Lap_3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long n = Long.parseLong(firstMultipleInput[0]);

                long k = Long.parseLong(firstMultipleInput[1]);

                String result = lap3_1.Result.solve(n, k);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


class Result {
    public static String solve(long n, long k) {
        if (k == 1) {
            return (n > 1 && isPrime(n)) ? "Yes" : "No";
        }
        if (k == 2) {
            if (n % 2 == 0) {
                return n > 2 ? "Yes" : "No";
            } else {
                return (n > 3 && isPrime(n - 2)) ? "Yes" : "No";
            }
        }
        return n >= 2 * k ? "Yes" : "No";
    }
    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
