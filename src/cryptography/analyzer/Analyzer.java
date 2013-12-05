/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography.analyzer;

import cryptography.parser.Parser;

/**
 *
 * @author florian
 */
public abstract class Analyzer {
    /**
     * .
     */
    protected Parser parser;
    /**
     * .
     */
    protected final Integer DEFAULT_STEP = 1;
    /**
     * .
     */
    protected final Integer DEFAULT_SEEK = 1;
    /**
     * Getter.
     * @return
     */
    public Parser getParser() {
        return this.parser;
    }
    /**
     * .
     * @return
     */
    public Integer getDEFAULT_STEP() {
        return this.DEFAULT_STEP;
    }
    /**
     * .
     * @return
     */
    public Integer getDEFAULT_SEEK() {
        return this.DEFAULT_SEEK;
    }
}
