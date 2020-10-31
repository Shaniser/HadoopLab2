package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlightReducer extends Reducer<AirportWC, Text, Text, Text> {
    @Override
    protected void reduce(AirportWC key, Iterable<Text> value, Context context)
}
