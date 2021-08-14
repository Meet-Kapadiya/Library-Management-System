package com.company;

public class Reader
{
        int readerID,balance=0;
        long phoneNum;
        String readerName,email;

        Reader(int readerID, String readerName, String email, long phoneNum)
        {
            this.readerID = readerID;
            this.readerName = readerName;
            this.email = email;
            this.phoneNum = phoneNum;
        }

        int getBalance()
        {
            return balance;
        }

        void setBalance(int choice)
        {
            if(choice==1)
            {
                balance++;
            }
            else
            {
                balance--;
            }
        }
}
