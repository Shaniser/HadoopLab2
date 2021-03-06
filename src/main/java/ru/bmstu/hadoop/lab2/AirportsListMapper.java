package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsListMapper extends Mapper<LongWritable, Text, AirportWC, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] values = value.toString().split(",(?! )");
        if (!values[0].equals("Code")) {
            AirportWC airportWC = new AirportWC();

            int id = Integer.parseInt(values[0].replaceAll("^\"+|\"+$", ""));
            airportWC.setId(id);
            airportWC.setIndicator(0);

            context.write(airportWC, new Text(values[1].replaceAll("^\"+|\"+$", "")));
        }
    }
}
