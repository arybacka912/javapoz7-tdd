package com.sda.service;


import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterServiceTest {

    private WriterService writerService;

    @Before
    public void init() {
        this.writerService = new WriterService();
    }

    @Test
    public void testOneName() {
        //given
        String name = "Szymon";

        //when
        String result = writerService.write(name);

        //then
        Assert.assertEquals("Hello, Szymon.", result);
    }

    @Test
    public void testNullName() {
        //given
        String name = null;

        //when
        String result = writerService.write(name);

        //then
        Assert.assertEquals("Hello, my friend.", result);
    }

    @Test
    public void testCapitalizedName(){
        //given
        String name = "SZYMON";

        //when
        String result = writerService.write(name);

        //then
        Assert.assertEquals("HELLO, SZYMON!", result);
    }

    @Test
    public void testBlankName() {
        //given
        String name = "";


        //when
        String result = writerService.write(name);

        //then
        Assert.assertEquals("Hello, my friend.",result );

    }
}