package com.company;

import java.util.Date;

public class Transaction
{
    int transactionID , readerID , bookID , type;
    Date date;

    Transaction(int transactionID,int readerID,int bookID , int type)
    {
        this.transactionID = transactionID;
        this.readerID=readerID;
        this.bookID=bookID;
        this.date=new Date();
        this.type=(type==1)?1:2;
    }
}
