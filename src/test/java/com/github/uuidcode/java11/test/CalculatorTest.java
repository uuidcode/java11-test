package com.github.uuidcode.java11.test;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class CalculatorTest {
    @Property(trials = 5)
    public void testAddition(int number) {
        System.out.println("Generated number for testAddition: " + number);

        Calculator calculator = new Calculator();
        calculator.add(number);
        assertThat(calculator.getResult()).isEqualTo(number);
    }
}
