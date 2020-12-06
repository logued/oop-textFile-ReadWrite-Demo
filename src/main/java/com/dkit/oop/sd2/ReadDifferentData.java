package com.dkit.oop.sd2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
   Sample code: 4 of 4.
   Purpose:
        - read student data from a "structured" text file: students3.txt
         - populate an arraylist of Pupil objects with the data from the file. Pupil has ArrayList of marks as field

 students2.txt has lines of data: containing:
 Type (A or B), Student name, student ID, variable number of exam marks, Award amount (if Awardstudent)
  e.g.:   A,Mary Reilly,AB123,76,54,57,1000
          B,Tom Brady,AM857

 Read the data line at a time using Scanner and using split() to extract the data
 */
public class ReadDifferentData
{

    public static void main(String[] args)
    {

        ArrayList <Pupil> studentList = new ArrayList<>();
        File inputFile = new File("students3.txt");  // SOME entries have monetary award


        try (Scanner in = new Scanner(inputFile))
        {
            double sum = 0;
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                String [] data = line.split(",");

                String name = data[1];
                String id = data[2];
                ArrayList <Integer> marks = new ArrayList<>();

                Pupil p;
                if (data[0].equals("A"))                        //Data refers to AwardPupil
                {
                    for (int i = 3; i < data.length -1; i++)  //continue to end of data line except exclude last element (the award amount)
                    {
                        marks.add(Integer.parseInt(data[i]));
                    }
                    double award = Double.parseDouble(data[data.length-1]);
                    p = new AwardPupil(name,id, marks,award);
                }
                else                                         //Data refers to Pupil
                {
                    for (int i = 3; i < data.length ; i++)  //continue to end of data line
                    {
                        marks.add(Integer.parseInt(data[i]));
                    }
                    p = new Pupil(name,id, marks);
                }

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
