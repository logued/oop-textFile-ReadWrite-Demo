package com.dkit.oop.sd2;
/*
        Sample code: 1 of 3
        Purpose:
        - Write Student data to a text file, using data from ArrayList of Student objects
            File will be same structure as students1.txt:
            Student name, student ID, and 3 exam marks: Mary Reilly,AB123,76,54,57

        */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDataToTextFile
{

    public static void main(String[] args)
    {
        /* Hardcode data in ArrayList of Student objects */
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John Browne", "AB123", 23, 45, 56));
        studentList.add(new Student("Mary Black", "AB123", 23, 45, 56));
        studentList.add(new Student("Jim Grey", "AB123", 23, 45, 56));


        try (BufferedWriter studentsFile = new BufferedWriter(new FileWriter("studentsOut.txt")))
        {
            for (Student student : studentList)
            {
                studentsFile.write(student.getName() + "," + student.getId() + "," + student.getMark1() + "," + student.getMark2() + "," + student.getMark3());
                studentsFile.write("\n");
            }
        } catch (IOException ioe)
        {
            System.out.println("Could not save students data.");
        }
    }


}

