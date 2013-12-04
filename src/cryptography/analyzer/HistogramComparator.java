/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptography.analyzer;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author florian
 */
public class HistogramComparator implements Comparator<String>{

    Map<String, Integer> base;

    public HistogramComparator(Map<String, Integer> paramBase) {
        this.base = paramBase;
    }

    @Override
    public int compare(String a, String b) {
        Integer x = base.get(a);
        Integer y = base.get(b);
        if (x.equals(y)) {
            return a.compareTo(b);
        }
        return x.compareTo(y);
    }
}
