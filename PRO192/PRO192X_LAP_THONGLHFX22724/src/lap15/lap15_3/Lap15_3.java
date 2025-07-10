package lap15.lap15_3;

import java.util.List;

public class Lap15_3 {
    public static void main(String[] args) {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        FileService<Company> companyFileService = new FileService<>();

        // đọc dữ liệu từ file
        List<Company> companies = companyFileService.readFile("company.dat");
        System.out.println("List company in file: ");
        companyFileService.printList(companies);

        Company shoppe = new Company("Shoppe", "admin@shoppe.com", "0123456789", "5 Science Park Drive, Shopee Building", "118265", "Singapore");
        companies.add(shoppe);

        // ghi dữ liệu vào file
        companyFileService.writeFile("company.dat", companies);

        companies = companyFileService.readFile("company.dat");
        System.out.println("List company in file: ");
        companyFileService.printList(companies);

    }
}
