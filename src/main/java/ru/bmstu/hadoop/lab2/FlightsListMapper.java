package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsListMapper extends Mapper<LongWritable, Text, AirportWC, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] values = value.toString().split(",");
        if (!values[0].equals("\"YEAR\"")) {
            float cancelCode = Float.parseFloat(values[19]);
            String delayStr = values[18];

            if (cancelCode != 1 && !delayStr.isEmpty()) {
                if (Float.parseFloat(delayStr) > 0) {
                    AirportWC airportWC = new AirportWC();

                    int id = Integer.parseInt(values[14]);
                    airportWC.setId(id);
                    airportWC.setIndicator(1);

                    context.write(airportWC, new Text(delayStr));
                }
            }
        }
    }
}
