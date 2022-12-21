package com.example.testj19.services;

import java.util.Map;

public class DictionaryReplacer {

    public String stringReplacer(String str, Map<String, String> dictionary) {
        var separator = '$';

        if (str == null || str.equals("")) throw new IllegalArgumentException("The input string is null or empty");
        if (dictionary == null) return str;

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            str = str.replace(separator + entry.getKey() + separator, entry.getValue());
        }

        return str;
    }

}
