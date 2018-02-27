// Java program to illustrate 
// the concept of Composition
import java.io.*;
import java.util.*;
 
// class book
class Book 
{
 
    public String title;
    public String author;
     
    Book(String title, String author)
    {
         
        this.title = title;
        this.author = author;
    }
}
 
// Libary class contains 
// list of books.
class Library 
{
 
    // reference to refer to list of books.
    private final TreeMap<Integer,Book> books;
     
    Library (TreeMap<Integer, Book> books)
    {
        this.books = books; 
    }
     
    public TreeMap<Integer,Book> getTotalBooksInLibrary(){
         
       return books;  
    }
     
}
 
// main method
class Compp 
{
    public static void main (String[] args) 
    {
         
        // Creating the Objects of Book class.
        Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
        Book b2 = new Book("Thinking in Java", "Bruce Eckel");
        Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");
         
        // Creating the list which contains the 
        // no. of books.
        //List<Book> books = new ArrayList<Book>();
        TreeMap<Integer,Book> map1 = new TreeMap<Integer,Book>();
        map1.put(1,b1);
        map1.put(2,b2);
        map1.put(3,b3);
        /*books.add(b1);
        books.add(b2);
        books.add(b3);*/
         
        Library library = new Library(map1);
         
        TreeMap<Integer, Book> bks = library.getTotalBooksInLibrary();
        /*for(Book bk : bks){
             
            System.out.println("Title : " + bk.title + " and "
            +" Author : " + bk.author);
        }*/
        for(Map.Entry<Integer, Book> et:bks.entrySet()){
            Book b = et.getValue();
            System.out.println(et.getKey()+": "+b.title+" : "+b.author);
        }
    }
}