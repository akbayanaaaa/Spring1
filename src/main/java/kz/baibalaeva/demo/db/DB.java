package kz.baibalaeva.demo.db;


import kz.baibalaeva.demo.models.Book;

import java.util.ArrayList;

public class DB {
    public static ArrayList<Book> books= new ArrayList<>();

    public  static Long id=4L;

    static {
        books.add(new Book(1L, "https://2.bp.blogspot.com/-dPVb3oAkMd0/Vpfp5XsC2jI/AAAAAAAAALU/MJbgn22eH98/s1600/1003597768.jpg", "Harry Potter", 7000));
        books.add(new Book(2L, "https://smartprogress.do/uploadImages/000749284.jpg", "Shantaram", 8000));
        books.add(new Book(3L, "https://ae04.alicdn.com/kf/HTB1smu4cxSYBuNjSspjq6x73VXaj.jpg", "The Little Prince", 9000));
    }

    public static ArrayList<Book> getAllBooks(){
        return books;
    }

    public  static void addBook(Book book){
        book.setId(id);
        books.add(book);
        id++;
    }

    public static Book getBook(Long id){
        for (Book bk: books){
            if (bk.getId()==id){
                return bk;
            }
        }
        return null;
    }

}
