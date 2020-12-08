package com.dkit.oop.sd2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
   Sample code: 3 of 4.
   Purpose:
        - read student data from a "structured" text file: students2.txt
        - populate an arraylist of Pupil objects with the data from the file. Pupil has ArrayList of marks as field

 students2.txt has lines of data: containing:   Student name, student ID, and variable number of exam marks (possibly none)
  e.g.:   Mary Reilly,AB123,76,54,57
          Tom Brady,AM857

 Read the data line at a time using Scanner and using split() to extract the data
 */

public class ReadDataVariableLengthLine
{

    public static void main(String[] args)
    {

        ArrayList <Pupil> studentList = new ArrayList<>();
        File inputFile = new File("students2.txt");


        try (Scanner in = new Scanner(inputFile))
        {

            while (in.hasNextLine())
            {
                String line = in.nextLine();
                String [] data = line.split(",");

                String name = data[0];
                String id = data[1];

                ArrayList <Integer> marks = new ArrayList<>();
                for (int i = 2; i < data.length; i++)  //continue to end of data line
                {
                    marks.add(Integer.parseInt(data[i]));
                }
                Pupil p = new Pupil(name,id, marks);
                studentList.add(p);
            }

        } catch ( FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught." + exception);
        } catch (InputMismatchException exception)
        {
            System.out.println("InputMismatchexception caught." + exception);
        }

        displayData(studentList);

    }

    public static void displayData(ArrayList<Pupil> studentList)
    {

        for(Pupil s:studentList)
        {
            System.out.println(s);
        }
    }
}
