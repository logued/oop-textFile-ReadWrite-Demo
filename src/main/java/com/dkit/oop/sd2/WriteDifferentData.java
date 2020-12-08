package com.dkit.oop.sd2;
/*
        Sample code: 3 of 3
        Purpose:
        - Write Pupil data to a text file, using data from ArrayList of Pupil objects (Pupils and AwardPupils)
            File will be same structure as students3.txt:
            Type (A or B), Student name, student ID, variable number of exam marks, Award amount (if AwardPupil)
            e.g.:   A,Mary Reilly,AB123,76,54,57,1000
                    B,Tom Brady,AM857

        */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDifferentData
{

    public static void main(String[] args)
    {
        /* Hardcode data in ArrayList of Pupil objects */
        ArrayList<Pupil> studentList = new ArrayList<>();
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(45); nums1.add(48); nums1.add(59);
        studentList.add(new Pupil("John Browne", "AB123", nums1));
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(23); nums2.add(45);nums2.add(56);nums2.add(45);
        studentList.add(new Pupil("Mary Black", "AB123", nums2));
        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(63); nums3.add(95);
        studentList.add(new Pupil("Jim Grey", "AB123", nums3));
        ArrayList<Integer> nums4 = new ArrayList<>();
        nums4.add(43); nums4.add(50);
        studentList.add(new AwardPupil("Alice Brady", "AB123", nums4, 1000));

//        System.out.println(studentList);


        try (BufferedWriter studentsFile = new BufferedWriter(new FileWriter("studentsOut.txt")))
        {
            for (Pupil pupil : studentList)
            {
                if (pupil instanceof AwardPupil)
                {
                    studentsFile.write("A" + ",");
                }
                else
                {
                    studentsFile.write("B" + ",");
                }
                studentsFile.write(pupil.getName() + "," + pupil.getId());
                System.out.println(pupil.getName() + ":" + pupil.getMarks());
                for (int mark : pupil.getMarks())
                {
                    studentsFile.write("," + mark);
                }
                if (pupil instanceof AwardPupil)
                {
                    AwardPupil aw = (AwardPupil) pupil;
                    studentsFile.write(","+Double.toString(aw.getAward()));  // BufferedWriter needs to write as a String
                }
                studentsFile.write("\n");
            }
        } catch (IOException ioe)
        {
            System.out.println("Could not save students data.");
        }
    }


}

