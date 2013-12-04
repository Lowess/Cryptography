/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography.parser;

/**
 *
 * @author florian
 */
public abstract class Parser {
    /**
     * .
     */
    protected StringBuilder parsedStream;
    /**
     * .
     */
    public Parser() {
        this.parsedStream = new StringBuilder();
    }
    /**
     * .
     * @return
     */
    public StringBuilder getParsedStream() {
        return parsedStream;
    }
    /**
     * .
     * @return
     */
    public String getParsedStreamToString() {
        return parsedStream.toString();
    }
    /**
     * .
     * @return
     */
    public abstract StringBuilder parse();

}
