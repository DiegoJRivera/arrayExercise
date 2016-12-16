/*
 * Practical Exercise 3 developed by Diego Rivera for Programming Fundamentals class.
 * 05/09/2016
 * Professor Rachel Jeikishore
 * This java file is the class to Bookstore to create the bookList array.
 */
package practicalexercise4;

/**
 *
 * @author diegorivera
 */
public class Book {

    static boolean MAX_NUM_BOOKS;

    static boolean getNumBooksAdded() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String isbn, title, author;
    private double price;

    //constructor 1 by default
    public Book() {
        this.isbn = "0450040186";
        this.title = "The Shining";
        this.author = "King";
        this.price = 25.95;
    }
    
    //constructor 2 by parameters
    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ISBN: "+isbn+", Title: "+title+" (Author: "+author+"), Price $"+price+"\n";
    }
}
