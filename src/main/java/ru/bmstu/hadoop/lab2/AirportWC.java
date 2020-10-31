package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWC implements WritableComparable {
    private int id;
    private int indicator;
    @Override
    public int compareTo(Object o) {
        AirportWC other = (AirportWC) o;
        if (id )
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
