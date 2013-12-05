/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography.analyzer;

import cryptography.parser.Parser;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author florian
 */
public class StreamAnalyzer extends Analyzer {
    private Integer total;
    /**
     * .
     */
    private Map<String, Integer> histogram;
    /**
     * .
     */
    private Map<String, Integer> sortedHistogram;
    /**
     * .
     */
    private HistogramComparator histogramComparator;
    /**
     * .
     * @param paramStream
     */
    public StreamAnalyzer(Parser paramParser) {
        this.parser = paramParser;
        this.histogram = new HashMap<String, Integer>();
        this.histogramComparator = new HistogramComparator(histogram);
        this.sortedHistogram = new TreeMap<String, Integer>(this.histogramComparator);
        this.total = 0;
    }
    /**
     * .
     * @return
     */
    public Map<String, Integer> analyze(Integer step, Integer seek) {
        this.histogram.clear();

        StringBuilder stream = this.parser.getParsedStream();

        for (int i = 0; i < stream.length(); i = i + seek) {
            if(i + step > stream.length()) {
                step = stream.length() - i;
            }
            String key = stream.subSequence(i, i + step).toString();

            if(histogram.containsKey(key)) {
                this.histogram.put(key, histogram.get(key) + 1);
            } else {
                histogram.put(key, 1);
            }
            this.total += 1;
        }
        return this.histogram;
    }
    /**
     * .
     * @return
     */
    public Map<String, Integer> analyze() {
        return this.analyze(this.DEFAULT_STEP, this.DEFAULT_SEEK);
    }
    /**
     * Parse the stream with a seek equals to "step" and
     * extract "step" tokens.
     * @param step Size of a token
     * @return histogram generated according to the parsing job
     */
    public Map<String, Integer> analyze(Integer step) {
        return this.analyze(this.DEFAULT_STEP, this.DEFAULT_STEP);
    }

    public void displayHistogram() {
        //this.sort();
        this.displayHistogram(this.histogram);
    }

    public void displaySortedHistogram() {
        this.sortedHistogram.putAll(this.histogram);
        this.displayHistogram(this.sortedHistogram);
    }

    public void displayHistogram(Map<String, Integer> map) {
        System.out.println("------------------------");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Double percent = new Double(new Double(entry.getValue()) / this.total) * 100;
            DecimalFormat df = new DecimalFormat("#.##");
            df.setMaximumFractionDigits(2);
            System.out.println("# " + entry.getKey() + " | " + entry.getValue() + " | " + df.format(percent) + "% |");
            System.out.println("------------------------");
        }
    }
}
