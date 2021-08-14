package com.company;

public class Book
{
        int bookID;
        double bookPrice;
        boolean status=true;
        String bookName,author;

        Book(int bookID, String bookName, String author, double bookPrice)
        {
            this.bookID = bookID;
            this.bookName = bookName;
            this.author = author;
            this.bookPrice = bookPrice;
        }

        boolean getStatus()
        {
            return status;
        }

        void setStatus()
        {
            status = !status;
        }
}
