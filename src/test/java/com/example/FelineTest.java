package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
    private String expectedFamilyName = "Кошачьи";
    private int expectedkittensCount = 5;
    private static final int EXPECTED_DEFAULT_COUNT_OF_KITTENS = 1;


    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> actualListOfFood = feline.eatMeat();

        assertEquals("Неверный список еды", expectedListOfFood, actualListOfFood);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String actualFamilyName = feline.getFamily();

        assertEquals("Не верно определено семейство", expectedFamilyName, actualFamilyName);
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(expectedkittensCount);

        assertEquals("Количество котят не соответствует ожидаемому", expectedkittensCount, actualKittensCount);
    }

    @Test
    public void getKittensDefaultNumberTest() {
        Feline feline = new Feline();
        int actualCountOfKittens = feline.getKittens();

        assertEquals("Количество котят не соответствует ожидаемому", EXPECTED_DEFAULT_COUNT_OF_KITTENS, actualCountOfKittens);
    }
}
