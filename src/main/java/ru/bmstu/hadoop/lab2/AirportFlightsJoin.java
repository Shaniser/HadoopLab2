package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AirportFlightsJoin {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(AirportFlightsJoin.class);
        job.setJobName("Airport join");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportsListMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightsListMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(AirportPartitioner.class);
        job.setGroupingComparatorClass(FlightGC.class);
        job.setReducerClass(FlightReducer.class);
        job.setMapOutputKeyClass(AirportWC.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
