package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlightReducer extends Reducer<AirportWC, Text, Text, Text> {
    @Override
    protected void reduce(AirportWC key, Iterable<Text> value, Context context) throws IOException, InterruptedException {
        float delaySum = 0;
        int delayCount = 0;

        Iterator<Text> iterator = value.iterator();
    }
}
