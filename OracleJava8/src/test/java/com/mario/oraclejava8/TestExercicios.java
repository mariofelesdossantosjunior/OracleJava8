/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.oraclejava8;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Mario Feles dos Santos Junior
 * @email mario_feles@live.com
 * @since 14/12/2016
 * @project OracleJava8
 */
public class TestExercicios {

    private Lesson2 lesson2;

    public TestExercicios() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lesson2 = new Lesson2();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testeExercicio1() {
        assertEquals(lesson2.exercise1(), Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"));
    }

    @Test
    public void testeExercicio2() {
        assertEquals(lesson2.exercise2(), Arrays.asList("The", "Quick", "BROWN", "Fox", "The", "DOG"));
    }

    @Test
    public void testeExercicio3() {
        assertEquals(lesson2.exercise3(), "quick-brown-fox");
    }

    @Test
    public void testeExercio4() {
        assertEquals(lesson2.exercise4(), 14);
    }

}
