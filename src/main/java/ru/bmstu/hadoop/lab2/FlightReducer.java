package ru.bmstu.hadoop.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

import static java.lang.Math.*;

public class FlightReducer extends Reducer<AirportWC, Text, Text, Text> {
    @Override
    protected void reduce(AirportWC key, Iterable<Text> value, Context context) throws IOException, InterruptedException {
        float delaySum = 0;
        int delayCount;
        float minDelay;
        float maxDelay;

        Iterator<Text> iterator = value.iterator();
        String airport = iterator.next().toString();

        if (iterator.hasNext()) {
            float delay = Float.parseFloat(iterator.next().toString());
            minDelay = delay;
            maxDelay = delay;
            delaySum += delay;
            delayCount = 1;

            while (iterator.hasNext()) {
                delay = Float.parseFloat(iterator.next().toString());
                minDelay = min(minDelay, delay);
                maxDelay = max(maxDelay, delay);
                delaySum += delay;
                delayCount++;
            }

            String delayInfo = "Min delay: " +
                    minDelay +
                    "Average delay: " +
                    (delaySum / delayCount) +
                    "Max delay: " +
                    maxDelay;
            context.write(new Text(airport), new Text(delayInfo));
        }
    }
}
