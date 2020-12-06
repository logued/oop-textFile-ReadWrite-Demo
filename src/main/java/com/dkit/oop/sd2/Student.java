package com.dkit.oop.sd2;

import java.util.Objects;

public class Student
{
    private String name;
    private String id;
    private int mark1;
    private int mark2;
    private int mark3;

    public Student(String name, String id, int mark1, int mark2, int mark3)
    {
        this.name = name;
        this.id = id;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
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

    public int getMark1()
    {
        return mark1;
    }

    public void setMark1(int mark1)
    {
        this.mark1 = mark1;
    }

    public int getMark2()
    {
        return mark2;
    }

    public void setMark2(int mark2)
    {
        this.mark2 = mark2;
    }

    public int getMark3()
    {
        return mark3;
    }

    public void setMark3(int mark3)
    {
        this.mark3 = mark3;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName()+" {" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", mark1=" + mark1 +
                ", mark2=" + mark2 +
                ", mark3=" + mark3 +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return mark1 == student.mark1 &&
                mark2 == student.mark2 &&
                mark3 == student.mark3 &&
                Objects.equals(name, student.name) &&
                Objects.equals(id, student.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, id, mark1, mark2, mark3);
    }
}
