package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightGC extends WritableComparator {
    public FlightGC() {
        super();
    }
    @Override
    public int compare(WritableComparable first, WritableComparable second) {
        AirportWC a = (AirportWC) first;
        AirportWC b = (AirportWC) second;
        return Integer.compare(a.getId(), b.getId());
    }
}
