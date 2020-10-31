package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWC implements WritableComparable {
    private int id;
    private int indicator;

    public void setId(int id) {
        this.id = id;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public int getId() {
        return id;
    }

    public int getIndicator() {
        return indicator;
    }

    @Override
    public int compareTo(Object o) {
        AirportWC other = (AirportWC) o;
        int ans = id - other.id;
        if (ans == 0)
            return indicator - other.indicator;
        else
            return ans;
    }

    @Override
    public void 

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
