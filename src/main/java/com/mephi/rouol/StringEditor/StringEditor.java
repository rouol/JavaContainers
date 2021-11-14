package com.mephi.rouol.StringEditor;

import com.mephi.rouol.Containers.List;
import com.mephi.rouol.Containers.Map;

public class StringEditor {
    /** returns all substr and num of occurrences **/
    public static Map countAllSubstr(String string){
        List substrings = new List(string.split(" "));
        Map uniqueSubstrings = new Map();
        for (int i = 0; i < substrings.size(); i++) {
            String substr = (String) substrings.get(i);
            if (!uniqueSubstrings.keyContains(substr)) {
                uniqueSubstrings.put(substr, 1);
            } else {
                uniqueSubstrings.put(substr, (int) uniqueSubstrings.get(substr) + 1);
            }
        }
        return uniqueSubstrings;
    }

    /** returns str w/o additional occurrences **/
    public static String reduceOccurences(String string){
        StringBuilder reducedstr = new StringBuilder();
        List substrings = new List(string.split(" "));
        Map uniqueSubstrings = new Map();
        for (int i = 0; i < substrings.size(); i++) {
            String substr = (String) substrings.get(i);
            if (!uniqueSubstrings.keyContains(substr)) {
                uniqueSubstrings.put(substr, 1);
                reducedstr.append(substr).append(" ");
            }
        }
        return reducedstr.toString();
    }
}
