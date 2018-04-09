
package com.sda.service;


import org.apache.commons.lang3.StringUtils;

public class WriterService {
    public String write(String name) {
        return prefix(name) + content(name) + suffix(name);
    }

    private String prefix(String name) {
        return isCapitalizedName(name) ? "HELLO, " : "Hello, ";
    }

    private String content(String name) {
        return StringUtils.isBlank(name) ? "my friend" : name;
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

