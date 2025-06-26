package com.java.libaryManagermentSystem;

public class Magazine extends LibraryItems{
    public Magazine(String title, String author, String serialNumber) {
        super(title, author, serialNumber);
    }

    @Override
    public void borrowItem(User user) {
        if(isBorrowed){
            isBorrowed=true;
            System.out.println(user+" The borrowed Magazine"+getTitle());

        }
        else {
            System.out.println(user+"The Magazine already barrowed"+getTitle());
        }

    }
}
