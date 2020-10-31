package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportWC, Text> {
    @Override
    public int getPartition(AirportWC airportWC, Text text, int numReduceTasks) {
        return airportWC.getId() % numReduceTasks;
    }
}
