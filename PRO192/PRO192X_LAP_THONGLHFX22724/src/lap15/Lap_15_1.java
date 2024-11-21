package lap15;

public class Lap_15_1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println(3 / 0);
        } catch (ArithmeticException e) {
            // Bắt ngoại lệ và in ra thông báo lỗi
            System.out.printf("Caught runtime exception = %s\n", e);
        }
    }
}
