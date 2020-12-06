package com.dkit.oop.sd2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
   Sample code: 1 of 4.
   Purpose:
        - read student data from a "structured" text file, students1.txt
        - populate an arraylist of Student objects with the data from the file. Student has 3 fields to store the marks

 students1.txt has lines of data:   Student name, student ID, and 3 exam marks
  e.g.:   Mary Reilly,AB123,76,54,57

 Read the data token-by-token using Scanner
 */

public class ReadDataByToken
{
    public static void main(String[] args)
    {
        ArrayList<Student> studentList = new ArrayList<>();
        File inputFile = new File("students1.txt");

        try (Scanner in = new Scanner(inputFile))
        {
            in.useDelimiter("[,\r\n]+");
            while (in.hasNext())
            {
                String name = in.next();
                String id = in.next();
                int mark1 = in.nextInt();
                int mark2 = in.nextInt();
                int mark3 = in.nextInt();
                Student s = new Student(name, id, mark1, mark2, mark3);
                studentList.add(s);
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
        } catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }

        displayData(studentList);

    }

    public static void displayData(ArrayList<Student> studentList)
    {

        for (Student s : studentList)
        {
            System.out.println(s);
        }
    }
}
