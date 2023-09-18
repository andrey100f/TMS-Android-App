package com.example.tms_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class SampleTest {
    @Test
    public void Scenario_1(){
        SampleClass sc = new SampleClass();
        sc.Add(1,2);

        assertEquals(3, sc.getResult());
    }

    @Test
    public void Scenario_2(){
        SampleClass sc = new SampleClass();
        sc.Add(1,2);

        assertNotEquals(4, sc.getResult());
    }

    @Test
    public void Scenario_3(){
        SampleClass sc = new SampleClass();
        sc.Add(0,2);

        assertEquals(2, sc.getResult());
    }

    @Test
    public void Scenario_4(){
        SampleClass sc = new SampleClass();
        sc.Add(-1,2);

        assertEquals(1, sc.getResult());
    }

    @Test
    public void Scenario_5(){
        SampleClass sc = new SampleClass();
        sc.Add(-1,-2);

        assertEquals(-3, sc.getResult());
    }

    @Test
    public void Scenario_6(){
        SampleClass sc = new SampleClass();
        sc.Add(null, -2);

        assertEquals(-3, sc.getResult());
    }
}
