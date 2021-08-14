package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class Data
{
    int bookIndex,readerIndex;

    static ArrayList<Book> books=new ArrayList<Book>();
    static ArrayList<Reader> readers=new ArrayList<Reader>();
    static ArrayList<Transaction> transactions=new ArrayList<Transaction>();


    /* ........................... Add Book & Add Reader ........................... */

    void addBook(int bookID,String bookName,String author,double bookPrice)
    {
        books.add(new Book(bookID, bookName, author, bookPrice));
        System.out.println("Operation Successful!");
    }

    void addReader(int readerID,String readerName,String email,long phoneNum)
    {
        readers.add(new Reader(readerID, readerName, email, phoneNum));
        System.out.println("Operation Successful!");
    }


    /* ......................... Remove Book & Remove Reader ......................... */

    void removeBook(int bookID)
    {
        if(isBookExist(bookID))
        {
            if(!books.get(bookIndex).getStatus())
            {
                System.out.println("Book Is Issued By Someone!");
            }
            else
            {
                books.remove(books.get(bookIndex));
                System.out.println("Operation Successful!");
            }
        }
    }

    void removeReader(int readerID)
    {
        if(isReaderExist(readerID))
        {
            if(readers.get(readerIndex).getBalance()>0)
            {
                System.out.println("You Have To Return Some Books!");
            }
            else
            {
                readers.remove(readers.get(readerIndex));
                System.out.println("Operation Successful!");
            }
        }
    }


    /* .......................... Methods Related To Book .......................... */

    boolean isBookExist(int bookID)
    {
        boolean found=false;
        ListIterator<Book> iterator=books.listIterator();
        Book temp;
        while (iterator.hasNext())
        {
            temp= iterator.next();
            if(temp.bookID==bookID)
            {
                found=true;
                bookIndex=books.indexOf(temp);
                break;
            }
        }
        if(!found)
        {
            System.out.println("Book Not Exist!");
        }
        return found;
    }

    boolean getBookStatus(int choice)
    {
        if(!books.get(bookIndex).getStatus() && choice==1){
            System.out.println("Book Is Not Available!");
        }
        if(books.get(bookIndex).getStatus() && choice==1){
            System.out.println("Book Is Already Available!");
        }
        return(books.get(bookIndex).getStatus());
    }

    void setBookStatus()
    {
        books.get(bookIndex).setStatus();
    }


    /* .......................... Methods Related To Reader .......................... */

    boolean isReaderExist(int readerID)
    {
        boolean found=false;
        ListIterator<Reader> iterator=readers.listIterator();
        Reader temp;
        while (iterator.hasNext())
        {
            temp= iterator.next();
            if(temp.readerID==readerID)
            {
                found=true;
                readerIndex=readers.indexOf(temp);
                break;
            }
        }
        if(!found)
        {
            System.out.println("Reader Not Exist!");
        }
        return found;
    }

    int getReaderBalance(int readerID,int choice)
    {
        boolean check=isReaderExist(readerID);
        if(check)
        {
            if(
                    (choice==1 && readers.get(readerIndex).getBalance()==4)
                    ||
                    (choice==2 && readers.get(readerIndex).getBalance()==0)
            )
            {
                System.out.println("Your Balance Is Insufficient!");
            }
            return  readers.get(readerIndex).getBalance();
        }
        else
        {
            return -1;
        }
    }

    void setReaderBalance(int choice)
    {
        readers.get(readerIndex).setBalance(choice);
    }


    /* .......................... Issuing Book & Returning Book .......................... */

    void initiateOperation(int bookID,int readerID,int choice)
    {
        transactions.add(new Transaction(transactions.size(),readerID,bookID,choice));
        if (
                (   choice==1 && isBookExist(bookID) && getBookStatus(choice) &&
                        isReaderExist(readerID) && (getReaderBalance(readerID,choice)<4)  )
                ||
                (   choice==2 && isBookExist(bookID) && (!getBookStatus(choice)) &&
                        isReaderExist(readerID) && (getReaderBalance(readerID,choice))>0  )
        )
        {
            setBookStatus();
            setReaderBalance(choice);
            System.out.println("Operation Successful!");
        }
    }
}
