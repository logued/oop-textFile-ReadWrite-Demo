package com.dkit.oop.sd2;

import java.util.ArrayList;
import java.util.Objects;

public class Pupil
{
    private String name;
    private String id;
    private ArrayList<Integer> marks;

    public Pupil(String name, String id, ArrayList<Integer> marks)
    {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public ArrayList<Integer> getMarks()
    {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks)
    {
        this.marks = marks;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName()+" {" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return Objects.equals(name, pupil.name) &&
                Objects.equals(id, pupil.id) &&
                Objects.equals(marks, pupil.marks);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, id, marks);
    }
}
