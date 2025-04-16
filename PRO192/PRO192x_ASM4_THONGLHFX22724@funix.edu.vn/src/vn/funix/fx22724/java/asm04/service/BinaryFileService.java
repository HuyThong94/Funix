package vn.funix.fx22724.java.asm04.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileService {
    public static <T> List<T> readFile(String fileName) throws FileNotFoundException {
        List<T> objects = new ArrayList<T>();
        try(ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
            boolean eof = false;
            while (!eof) {
                try{
                    T object = (T) file.readObject();
                    objects.add(object);
                }catch (EOFException e){
                    eof = true;
                }
            }
        }catch (EOFException e){
            return new ArrayList<>();
        }catch (IOException io){
//            System.out.println("Io Exception" + io.getMessage());
            System.out.println("Tệp không tồn tại");
        }catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException" + e.getMessage());
        }
        return objects;
    }

    public static <T> void writeFile(String fileName, List<T> objects){
        try(ObjectOutputStream file = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
            for(T object : objects){
                file.writeObject(object);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
