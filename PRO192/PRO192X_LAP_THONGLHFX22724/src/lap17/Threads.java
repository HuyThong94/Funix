package lap17;

public class Threads {
    public static void main(String[] args) {
        var CurrentThread = Thread.currentThread();
        System.out.println(CurrentThread.getClass().getName());
        System.out.println(currentThread);
    }
    public static Thread printThreadState(Thread thread) {
        System.out.println();
    }
}
