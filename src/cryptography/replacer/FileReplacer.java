/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography.replacer;

import cryptography.analyzer.StreamAnalyzer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author florian
 */
public class FileReplacer extends Replacer {

    public FileReplacer(StreamAnalyzer paramAnalyzer) {
        super(paramAnalyzer);
    }
    /**
     * .
     * @param tokenToReplace
     * @param replacementToken
     */
    @Override
    public void replace(String tokenToReplace, String replacementToken) {
        StringBuilder stream = this.analyzer.getParser().getParsedStream();
        Integer step = this.analyzer.getDEFAULT_STEP();
        Integer seek = this.analyzer.getDEFAULT_SEEK();

        String replaced = stream.toString().replaceAll(tokenToReplace, replacementToken);

        StringBuilder replacedStream = new StringBuilder();
        replacedStream.append(replaced);

        this.analyzer.getParser().setParsedStream(replacedStream);
    }

    /**
     * .
     * @param path
     */
    @Override
    public void write(String path) {
        try {
            File file = new File(path);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.analyzer.getParser().getParsedStreamToString());
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
