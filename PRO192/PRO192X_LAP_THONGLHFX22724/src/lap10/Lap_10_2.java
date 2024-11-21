package lap10;

public class LAP_10_2 {
    public static void main(String[] args) {
        Printer printer = new Printer(50, 0, true); // tạo máy in với mức mực 50%, in 2 mặt
        System.out.println("Pages printed: " + printer.getPagesPrinted());

        int pagesPrinted = printer.printPages(10); // in 10 trang
        System.out.println("Pages printed for this job: " + pagesPrinted);
        System.out.println("Total pages printed: " + printer.getPagesPrinted());

        int newTonerLevel = printer.addToner(30); // thêm 30% mực
        System.out.println("Toner level after refilling: " + newTonerLevel);
    }
}
class Printer{
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, int pagesPrinted, boolean duplex) {
        if(tonerLevel >= 0 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        }else{
            this.tonerLevel = -1;
        }
        this.pagesPrinted = pagesPrinted;
        this.duplex = duplex;
    }
    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount + this.tonerLevel <= 100) {
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        } else {
            return -1; // không hợp lệ
        }
    }
    public int printPages(int pages) {
        int pagesToPrint = pages;
        if (this.duplex) {
            pagesToPrint = (pages / 2) + (pages % 2);
            System.out.println("Printing in duplex mode.");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }
    public int getPagesPrinted() {
        return this.pagesPrinted;
    }
}

