/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography;

import cryptography.analyzer.StreamAnalyzer;
import cryptography.parser.FileParser;
import cryptography.parser.Parser;

/**
 *
 * @author florian
 */
public class Cryptography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Incorrect number of parameters!");
        } else {
            //### Parse the stream
            Parser p = new FileParser(args[0]);
            //Display the file stream parsed
            p.parse();
            //System.out.println(p.parse());

            //### Analyze the stream
            StreamAnalyzer analyzer = new StreamAnalyzer(p.getParsedStream());

            analyzer.analyze(5);

            analyzer.displaySortedHistogram();
        }
    }
}
