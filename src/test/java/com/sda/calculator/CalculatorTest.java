package com.sda.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void init(){
        this.calculator = new Calculator();
    }


    @Test
    public void testAdd() {
        // GIVEN -> mówimy co testujemy
     //   Calculator calculator = new Calculator();
        // when -> kiedy coś testujemy
        int sum = calculator.sum(3, 5);
        //THEN -> kiedy to się wykona
        Assert.assertEquals("Result is not 8", 8, sum);

    }
    @Test
    public void testSubtract() {
        // GIVEN -> mówimy co testujemy
      //  Calculator calculator = new Calculator();
        // when -> kiedy coś testujemy
        int sub = calculator.subtract(10, 8);
        //THEN -> kiedy to się wykona
        Assert.assertEquals("Result is not 2", 2, sub);
    }
    @Test
    public void testMultiply() {
        // GIVEN -> mówimy co testujemy
       // Calculator calculator = new Calculator();
        // when -> kiedy coś testujemy
        int multi = calculator.multiply(10, 2);
        //THEN -> kiedy to się wykona
        Assert.assertEquals("Result is not 20", 20, multi);
    }
    @Test
    public void testDivide() {
        // GIVEN -> mówimy co testujemy
       // Calculator calculator = new Calculator();
        // when -> kiedy coś testujemy
        int div = calculator.divide(10, 2);
        //THEN -> kiedy to się wykona
        Assert.assertEquals("Result is not 5", 5, div);
        //Assert.assertEquals("Result is not 5", calculator.divide(10, 2));
    }
}
