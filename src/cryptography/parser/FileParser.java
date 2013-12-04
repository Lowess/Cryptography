/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author florian
 */
public class FileParser extends Parser {
    /**
     * .
     */
    private String path;
    /**
     * .
     * @param paramPath
     */
    public FileParser(final String paramPath) {
        super();
        this.path = paramPath;
    }
    /**
     * .
     * @return
     */
    @Override
    public StringBuilder parse() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.path));

            String line = br.readLine();

            while (line != null) {
                this.parsedStream.append(line.toUpperCase().replaceAll("\\s", ""));
                line = br.readLine();
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.parsedStream;
    }
}
