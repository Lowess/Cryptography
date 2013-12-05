/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography.replacer;

import cryptography.analyzer.Analyzer;

/**
 *
 * @author florian
 */
public abstract class Replacer {
    /**
     * .
     */
    protected Analyzer analyzer;

    public Replacer(Analyzer paramAnalyzer) {
        this.analyzer = paramAnalyzer;
    }
    /**
     * .
     * @param tokenToReplace
     * @param replacementToken
     */
    public abstract void replace(String tokenToReplace, String replacementToken);
    /**
     * Write the result in a specify given PATH.
     */
    public abstract void write(String path);
}