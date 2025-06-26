package com.java.libaryManagermentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libarary {
    private List<LibraryItems> libraryItemsList;
    private List<User> userList;
    private Map<String,String>borrowedItems;
    public Libarary() {
        libraryItemsList=new ArrayList<>();
        userList=new ArrayList<>();
        borrowedItems=new HashMap<>();

    }
    public void addItem(LibraryItems libraryItems) {

        libraryItemsList.add(libraryItems);
    }
    public void addUser(User user) {
        userList.add(user);
    }
    public List<LibraryItems> getLibraryItems() {
        return libraryItemsList;
    }
    public List<User> getUserList() {
        return userList;
    }
    public void borrowItem(String serialNumber,User user) {
     for(LibraryItems libraryItems : libraryItemsList) {
         if(libraryItems.getSerialNumber().equals(serialNumber)) {
             if (borrowedItems.containsKey(libraryItems.getSerialNumber())) {
                 System.out.println("Item"+libraryItems.getTitle()+"is already borrowed");
                 return;
             }
             borrowedItems.put(libraryItems.getSerialNumber(),user.getName());
             libraryItems.isBorrowed=true;
             System.out.println("Item"+libraryItems.getTitle()+"is borrowed successfully");
             return;
         }

     }
        System.out.println("Item with serial number "+serialNumber+" does not exist");
    }
    public void returnBorrowedItem(String serialNumber,User user) {
        for(LibraryItems libraryItems : libraryItemsList) {
            if(libraryItems.getSerialNumber().equals(serialNumber)) {
                if(borrowedItems.containsKey(libraryItems.getSerialNumber())) {
                    borrowedItems.remove(libraryItems.getSerialNumber());
                    libraryItems.isBorrowed=false;
                    System.out.println("Item"+libraryItems.getTitle()+"is borrowed successfully return by user"+user.getName());
                    return;
                }
            }

        }
        System.out.println("Item with serial number "+serialNumber+" does not exist");
    }
    public Map<String, String> getBorrowedItems() {

        return borrowedItems;
    }

}
