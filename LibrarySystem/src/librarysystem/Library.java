/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystem;

import java.util.List;

/**
 *
 * @author Riska
 */
public class Library {

    //Getters and setters 
    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    // Constructor to initialize the lists
    public Library(List<Book> booksBorrowed, List<Member> member) {
        this.booksBorrowed = booksBorrowed;
        this.member = member;
    }
    
    //Declaring Lists
    private List<Book> booksBorrowed;
    private List<Member> member;
    
    //Method to add books
    
    
}
