package com.dkit.oop.sd2;

import java.util.ArrayList;
import java.util.Objects;

public class AwardPupil extends Pupil
{
    private double award;

    public AwardPupil(String name, String id, ArrayList<Integer> marks, double award)
    {
        super(name, id, marks);
        this.award = award;
    }

    public double getAward()
    {
        return award;
    }

    public void setAward(int award)
    {
        this.award = award;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AwardPupil that = (AwardPupil) o;
        return Double.compare(that.award, award) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), award);
    }

    @Override
    public String toString()
    {
        return super.toString() +
                ", award=" + award +
                '}';
    }
}
