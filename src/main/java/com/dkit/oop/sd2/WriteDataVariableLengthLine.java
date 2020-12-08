package com.dkit.oop.sd2;
/*
        Sample code: 2 of 3
        Purpose:
        - Write Pupil data to a text file, using data from ArrayList of Pupil objects
            File will be same structure as students2.txt:
            Student name, student ID, and variable number of exam marks: Mary Reilly,AB123,76,54,57

        */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDataVariableLengthLine
{

    public static void main(String[] args)
    {
        /* Hardcode data in ArrayList of Pupil objects */
        ArrayList<Pupil> studentList = new ArrayList<>();
        ArrayList<Integer> nums1 = new ArrayList<>();  nums1.add(45); nums1.add(48); nums1.add(59);
        studentList.add(new Pupil("John Browne", "AB123", nums1));
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(23);nums2.add(45);nums2.add(56);nums2.add(45);
        studentList.add(new Pupil("Mary Black", "AB123", nums2));
        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(63);nums3.add(0,95);
        studentList.add(new Pupil("Jim Grey", "AB123", nums3));

//        System.out.println(studentList);




        try (BufferedWriter studentsFile = new BufferedWriter(new FileWriter("studentsOut.txt")))
        {
            for (Pupil pupil : studentList)
            {
                studentsFile.write(pupil.getName() + "," + pupil.getId());
                System.out.println(pupil.getName() + ":"+pupil.getMarks());
                 for(int mark:pupil.getMarks())
                 {
                     studentsFile.write("," + mark);
                 }
                studentsFile.write("\n");
            }
        } catch (IOException ioe)
        {
            System.out.println("Could not save students data.");
        }
    }


}

