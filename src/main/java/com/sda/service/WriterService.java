
package com.sda.service;


import org.apache.commons.lang3.StringUtils;

public class WriterService {
    public String write(String name) {
//        if (name != null && name.toUpperCase().equals(name)) {
//            return "HELLO, " + name + "!";
//        }
//       String nameToDisplay = name == null ? "my friend" : name;
//        return "Hello, " + nameToDisplay + ".";
//    }
        //     Hello,           Imię            ! / .
        return prefix(name) + content(name) + suffix(name);
    }


    private String prefix(String name) {
        return isCapitalizedName(name) ? "HELLO, " : "Hello, ";
    }

    private String content(String name) {
        //StringUtils.isEmpty(); || isNotEmpty();
        //StringUtils.isBlank();
        return StringUtils.isEmpty(name) ? "my friend" : name;
    }

    private String suffix(String name) {
        return isCapitalizedName(name) ? "!" : ".";
    }

    private boolean isCapitalizedName(String name) {
        return StringUtils.isNotEmpty(name) && name.toUpperCase().equals(name);
    }
}

//    public static void main(String[] args) {
//    }

