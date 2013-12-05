/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography;

import cryptography.analyzer.StreamAnalyzer;
import cryptography.parser.FileParser;
import cryptography.replacer.FileReplacer;
import cryptography.replacer.Replacer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author florian
 */
public class Cryptography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Incorrect number of parameters!");
            System.err.println("--- Param 1 : input file");
            System.err.println("--- Param 2 : output file");
        } else {

            //## 1 ##Create a file parser
            FileParser parser = new FileParser(args[0]);
            //Parse the stream
            parser.parse();

            //## 2 ##Create an analyzer on the parsed stream
            StreamAnalyzer analyzer = new StreamAnalyzer(parser);
            //Analyze the stream with
            //  token size = 1
            //  step increment = 1
            analyzer.analyze(1,1);
            //Display results
            analyzer.displaySortedHistogram();

            //## 3 ##Create a new replacer on the parsed stream
            Replacer replacer = new FileReplacer(analyzer);
            replacer.replace("A", "a");
            replacer.replace("B", "b");
            replacer.replace("C", "c");
            replacer.replace("D", "d");

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	    //get current date time with Date()
            Date date = new Date();
            replacer.write(args[1] + dateFormat.format(date) + ".txt");

        }
    }
}
