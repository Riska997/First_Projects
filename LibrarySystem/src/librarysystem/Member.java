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
public class Member {

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public List<Book> getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(List<Book> bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

     // Constructor to initialize the members
    public Member(String name, int memberID, List<Book> bookBorrowed) {
        this.name = name;
        this.memberID = memberID;
        this.bookBorrowed = bookBorrowed;
    }
    
    //Declaring variables
    private String name;
    private int memberID;
    private List<Book> bookBorrowed;
    
}
