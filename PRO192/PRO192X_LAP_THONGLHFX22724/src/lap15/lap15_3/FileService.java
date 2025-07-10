package lap15.lap15_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService<T> {
    public FileService() {}
    public void printList(List<T> lst){
        for(var i = 0; i < lst.size(); i++){
            Company company = (Company) lst.get(i);
        System.out.println("Name: " + company.getName());
        System.out.println("Address: " + company.getAddress());
        System.out.println("Email: " + company.getEmail());
        System.out.println("Phone: " + company.getPhone());
        System.out.println("Postcode: " + company.getPostcode());
        System.out.println("Country: " + company.getCountry());
        System.out.println("Created Date: " + company.getCreatedDate());
        }
    }
    public List<T> readFile(String fileName){
        List<T> objects = new ArrayList<>();
        try(ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            boolean eof = false;
            while(!eof) {
                try {
                    T object = (T) file.readObject();
                    objects.add(object);
                } catch(EOFException e) {
                    eof = true;
                 }
            }
        } catch(IOException io) {
            System.out.println("IO Exception" + io.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
        return objects;
    }

    public void writeFile(String fileName, List<T> objects){
        try (ObjectOutputStream companyFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (T object : objects) {
                companyFile.writeObject(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
