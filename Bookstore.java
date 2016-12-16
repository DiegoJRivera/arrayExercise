/*
 * Practical Exercise 4 developed by Diego Rivera for Programming Fundamentals class.
 * 05/09/2016
 * This java file require input to create a Book object, where add to an array of Book
 * objects. The program have a menu system that allows the user of the application to:
 *      -Input details of an individual book
 *      -Display book information sorted by price from lowest to highest price.
 *      -Search for a book by title.
 *      -Display all books.
 *
 * This Bookstore main class has been programmed in a modular way, that means each task
 * is carried out by different method.
 */
package practicalexercise4;

/**
 *
 * @author diegorivera
 */
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Bookstore {

    /**
     * @param args the command line arguments
     */
    private static final Book[] bookList = new Book[3];
    private static int count = 0;

    //main method calls inputmenu() method to select what option to follow.
    public static void main(String[] args) {

        int input = 0;

        while (input != 5) {
            input = inputmenu();
        
        try{
            switch (input) {
                case 1:
                    if (count < bookList.length) {
                        inputBookDetails();//Option 1 calls inputBookDetails() method
                    } else {
                        JOptionPane.showMessageDialog(null, "No more books allowed");
                    }
                    break;
                case 2:
                    sortAndDisplayBookByPrice();//Option 2 calls sortAndDisplayBookByPrice() method
                    break;
                case 3:
                    searchBookByTitle();//Option 3 calls searchBookByTitle() method
                    break;
                case 4:
                    displayBookList();//Option 4 calls displayBookList() method
                    break;
                case 5:
                    System.exit(0);//Option 5 finish the program
                    break;
            }
        }
        catch (NullPointerException e) {            
            e.printStackTrace(System.err);
            System.exit(0);
        }
        }
  
    }// end main method

    //Method to select the menu option.
    public static int inputmenu() {
        int input;

        input = Integer.parseInt(
                (JOptionPane.showInputDialog(
                        null,
                        "--Book store--\n\n"
                        + "1. Add book to catalogue\n"
                        + "2. Sort and display books by price\n"
                        + "3. Search for book by title\n"
                        + "4. Display all books\n\n"
                        + "5. Exit"))
        );

        return input;
    }//end method

    //method to input the data to create Book object, and add to an array of Book (bookList)
    public static void inputBookDetails() {
        String isbn, title, author;
        double price;

        isbn = JOptionPane.showInputDialog(null, "Enter the ISBN of the book");
        title = JOptionPane.showInputDialog(null, "Enter the title of the book");
        author = JOptionPane.showInputDialog(null, "Enter the last name of the author");
        price = (Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the price "
                + "of the book")));

        bookList[count] = new Book(isbn, title, author, price);
        count++;

    }//end method

    //method to display the book list
    
    public static void displayBookList() {
        String output = "";
        for (int j = 0; j < bookList.length; j++) {
            output += bookList[j].toString();
        }
        JOptionPane.showMessageDialog(null, output);
    }//end method

    //method to sort and display the book list by the price.
    private static void sortAndDisplayBookByPrice() {
        Book[] sortedBookList = Arrays.copyOf(bookList, bookList.length);
        int a, b;
        Book temp;
        for (a = 0; a < sortedBookList.length - 1; a++) {

            for (b = 0; b < sortedBookList.length - 1; b++) {
                if (sortedBookList[b].getPrice() > sortedBookList[b + 1].getPrice()) {
                    temp = sortedBookList[b];
                    sortedBookList[b] = sortedBookList[b + 1];
                    sortedBookList[b + 1] = temp;
                }
            }
        }
        String output = "";
        for (Book showsort : sortedBookList) {
            output += showsort.toString();
        }
        JOptionPane.showMessageDialog(null, output);
    }//end method

    //method to search a book by title.
    //this method start to find since the first character input.
    private static void searchBookByTitle() {
        String title = JOptionPane.showInputDialog(null, "Enter the title of the book you "
                + "are searching for").trim().toLowerCase();
        String searchResults = "";
        for (int i = 0; i < count; i++) {
            if (bookList[i].getTitle().trim().toLowerCase().contains(title)) {
                searchResults = searchResults + bookList[i].toString();
            } 
        }
        if (searchResults.length() < 10) {
            JOptionPane.showMessageDialog(null, "The title does not exist in the collection");
        } else {
            JOptionPane.showMessageDialog(null, "Book Details \n" + searchResults);
        }

    }//end method

}
