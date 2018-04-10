
package com.sda.service;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class WriterService {
    public String write(String name) {
        return prefix(name) + content(name) + suffix(name);
    }

    private String prefix(String name) {
        return isCapitalizedName(name) ? "HELLO, " : "Hello, ";
    }

    private String content(String name) {
        if (StringUtils.isBlank(name)) {
            return "my friend";
        }
        StringBuilder builder = new StringBuilder();
        //split -> po przecinku
        String[] names = name.split(",");
        for (int i = 0; i < names.length - 1; i++) {
            builder.append(names[i])
                    //kiedy chcemy dodać przecinek i spację
                    .append(getDelimiter(i, names, name));
        }
//        Arrays.asList(names)
//                .stream()
//                .map(e->StringUtils.deleteWhitespace(e));
//        return StringUtils.isBlank(name) ? "my friend" : name;
        return builder.append(names[names.length - 1]).toString();
    }
    private String getDelimiter(int index, String[] names, String name){
        //names.length - 2 ponieważ: Hello(0), Szymon(1), Anna(2), Jan(3)
        //          4 indeksy - 2  czyli po Anna będzie "and"
        return index != names.length - 2 ? ", " :
                (isCapitalizedName(name) ? " AND " : " and ");
    }

    private String suffix(String name) {
        return isCapitalizedName(name) ? "!" : ".";
    }

    private boolean isCapitalizedName(String name) {
        return StringUtils.isNotBlank(name) && name.toUpperCase().equals(name);
    }

    public static void main(String[] args) {
        WriterService writerService = new WriterService();
        String write = writerService.write("");


        System.out.println(write);
    }
}

