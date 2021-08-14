/* Library Management System */

package com.company;

import java.util.Scanner;
import java.lang.String;

public class LMS {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Data data=new Data();

        while (true) {
            System.out.println("\n..... Menu .....");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. Add Book");
            System.out.println("4. Add Reader");
            System.out.println("5. Check Balance");
            System.out.println("6. Remove Book");
            System.out.println("7. Remove Reader");
            System.out.println("8. Exit");

            System.out.print("\nEnter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter BookID: ");
                    int bookID = sc.nextInt();
                    System.out.print("Enter ReaderID: ");
                    int readerID = sc.nextInt();
                    data.initiateOperation(bookID, readerID, choice);
                }

                case 2 -> {
                    System.out.print("Enter BookID: ");
                    int bookID = sc.nextInt();
                    System.out.print("Enter ReaderID: ");
                    int readerID = sc.nextInt();
                    data.initiateOperation(bookID, readerID, choice);
                }

                case 3 -> {
                    System.out.print("Enter BookID: ");
                    int bookID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter BookName: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter BookAuthor: ");
                    String author = sc.nextLine();
                    System.out.print("Enter BookPrice: ");
                    double bookPrice = sc.nextDouble();
                    data.addBook(bookID,bookName,author,bookPrice);
                }

                case 4 -> {
                    System.out.print("Enter ReaderID: ");
                    int readerID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter ReaderName: ");
                    String readerName = sc.nextLine();
                    System.out.print("Enter ReaderEmail: ");
                    String email = sc.nextLine();
                    System.out.print("Enter ReaderContact: ");
                    long phoneNum = sc.nextLong();
                    data.addReader(readerID,readerName,email,phoneNum);
                }

                case 5 -> {
                    System.out.print("Enter ReaderID: ");
                    int readerID = sc.nextInt();
                    int balance=data.getReaderBalance(readerID,choice);
                    if(balance != -1)
                    {
                        System.out.println("Your Balance Is: "+balance);
                    }
                }

                case 6 -> {
                    System.out.print("Enter BookID: ");
                    int bookID = sc.nextInt();
                    data.removeBook(bookID);
                }

                case 7 -> {
                    System.out.print("Enter ReaderID: ");
                    int readerID = sc.nextInt();
                    data.removeReader(readerID);
                }

                case 8 -> System.exit(0);

                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}
