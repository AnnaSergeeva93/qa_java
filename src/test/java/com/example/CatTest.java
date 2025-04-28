package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private String expectedSound = "Мяу";
    private List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");

    private Cat cat;

    @Mock
    private Feline feline;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }


    @Test
    public void getSoundTest() {
        String actualSound = cat.getSound();
        assertEquals("Кот издаёт не тот звук", expectedSound, actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);
        List<String> actualListOfFood = cat.getFood();

        assertEquals("Неверный список еды", expectedListOfFood, actualListOfFood);
    }
}
