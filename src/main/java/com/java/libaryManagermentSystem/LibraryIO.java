package com.java.libaryManagermentSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryIO {
    //item ekk file ekt save krnn
    //load item from file
    //save users to file
    //load users from file
    //save borrowed items file
    //load borrowed items form file



    //item ekk file ekt save krnn
    public static  void saveItemToFile(List<LibraryItems>libraryItemsList,String fileName) {
      try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(fileName))) {
          oos.writeObject(libraryItemsList);
          System.out.println("Library Items Saved successfully"+fileName);

      } catch (IOException e) {
          throw new RuntimeException(e);
      }

    }

    //load item from file
    public static List<LibraryItems> loadItemsFromFile(String fileName) {

        File file = new File(fileName);
        if(!file.exists()) {
            return new ArrayList<>();
        }


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
        return (List<LibraryItems>)    ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //save users to file

    public static void saveUserToFile(List<User>users, String fileName){
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(users);
            System.out.println("User Saved"+fileName+" successfully");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //load users from file


    public static List<User> loadUserFromFile(String fileName) {

        File file = new File(fileName);
        if(!file.exists()) {
            return new ArrayList<>();
        }


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<User>)    ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //save borrowed items file
    public static void saveBorrowedItems(Map<String,String> borrowedItems, String fileName){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(borrowedItems);
            System.out.println("Borrowed Items Saved to"+fileName+"successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //load borrowed items form file
    public static Map<String,String> loadBorrowedItems(String fileName){
        File file = new File(fileName);
        if(!file.exists()) {
            return new HashMap<>();
        }

        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName))){
            return (Map<String, String>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }









    }

}
