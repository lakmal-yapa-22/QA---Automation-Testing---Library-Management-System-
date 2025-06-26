package com.java.libaryManagermentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Libarary libarary = new Libarary();

//        LibraryItems book1=new Book("Book1","Author1","B10001");
//        LibraryItems book2=new Book("Book2","Author2","B10002");
//        LibraryItems book3=new Book("Book3","Author3","B10003");
//        LibraryItems book4=new Book("Book4","Author4","B10004");
//
//        LibraryItems magazine1=new Magazine("Magazine1","Author1","M10001");
//        LibraryItems magazine2=new Magazine("Magazine2","Author2","M10002");
//        LibraryItems magazine3=new Magazine("Magazine2","Author2","M10003");
//
//       libarary.addItem(book1);
//       libarary.addItem(book2);
//       libarary.addItem(book3);
//       libarary.addItem(book4);
//       libarary.addItem(magazine1);

//        User user1 = new User("U1");
//        User user2 = new User("U2");
//        User user3 = new User("U3");
//        User user4 = new User("U4");
//
//
//        libarary.addUser(user1);
//        libarary.addUser(user2);
//        libarary.addUser(user3);
//        libarary.addUser(user4);





      List<LibraryItems> libraryItems =  LibraryIO.loadItemsFromFile("itemList.lms");

      for(LibraryItems libraryItem : libraryItems) {
          libarary.addItem(libraryItem);
      }
//      libraryItems.forEach(libarary::addItem);


       List<User> users= LibraryIO.loadUserFromFile("userList.lms");
      for(User user : users) {
          libarary.addUser(user);
      }
        Map<String,String>borrowedItems = LibraryIO.loadBorrowedItems("borrowedItems.lms");
      for(Map.Entry<String,String>borrowedItem : borrowedItems.entrySet()) {
          libarary.getBorrowedItems().put(borrowedItem.getKey(), borrowedItem.getValue());
      }


        System.out.println("---------------library items----------------");

      libarary.getLibraryItems().forEach(item -> System.out.println(item.getTitle()+"\t"+item.getAuthor()+"\t"+item.serialNumber));

        System.out.println("---------------library users---------------");


        libarary.getUserList().forEach(user -> System.out.println("user name:" +"\t"+user.getName()));

        System.out.println("---------------library borrowed items---------------");


        libarary.getBorrowedItems().forEach((item, user) -> System.out.println(item + " : " + user));


        boolean exit=false;
        while(!exit) {

          System.out.println("Enter main menu option :\n");
          System.out.println("1. create new item");
          System.out.println("2. create new user");
          System.out.println("3. user need to borrow an item");
          System.out.println("4. user need to return an item");
          System.out.println("5. exit");

         BufferedReader mainMenuOption = new BufferedReader(new InputStreamReader(System.in));

         int mainMenuOptionChoice;
         try {
             mainMenuOptionChoice=Integer.parseInt(mainMenuOption.readLine());
         } catch (IOException e) {
        System.out.println("please enter a valid option"+e.getMessage());
        continue;
         }
         if(mainMenuOptionChoice == 1) {
        System.out.println("\n---------------create new item---------------------\n");
        System.out.println("which library item would you like to create ?\n");
        System.out.println("1. create new Book");
        System.out.println("2. create new Magazine");

        BufferedReader createdItemType=new BufferedReader(new InputStreamReader(System.in));

        int createdItemTypeChoice;
        try {
            createdItemTypeChoice=Integer.parseInt(createdItemType.readLine());
        }
        catch (IOException e) {
            System.out.println("please enter a valid option"+e.getMessage());
            continue;

        }
        if (createdItemTypeChoice == 1) {

            System.out.println("\n---------------create new Book-------------------\n");
            System.out.println("please enter the tittle of the book ");
            String bookNameStr=  new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.out.println("please enter the author of the book ");
            String authorStr=  new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.out.println("please enter the serial number of the book ");
            String bookSerialNumberStr=  new BufferedReader(new InputStreamReader(System.in)).readLine();

            for(LibraryItems libraryItem:libarary.getLibraryItems()){
                if(Objects.equals(libraryItem.getSerialNumber(),bookSerialNumberStr)){
                    System.out.println("This library item already exists");
                    continue;
                }
            }
           LibraryItems createNewBook= new Book(bookNameStr,authorStr,bookSerialNumberStr);
            libarary.addItem(createNewBook);


        }

    }
    else if(mainMenuOptionChoice == 5) {
        exit=true;
    }
}
        LibraryIO.saveItemToFile(libarary.getLibraryItems(),"itemList.lms");

    }
}