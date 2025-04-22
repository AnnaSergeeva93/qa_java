package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
    private String expectedFamilyName = "Кошачьи";
    private int expectedkittensCount = 5;
    private static final int EXPECTED_DEFAULT_COUNT_OF_KITTENS = 1;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        List<String> actualListOfFood = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        assertEquals("Неверный список еды", expectedListOfFood, actualListOfFood);
    }

    @Test
    public void getFamilyTest() {
        String actualFamilyName = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        assertEquals("Не верно определено семейство", expectedFamilyName, actualFamilyName);
    }

    @Test
    public void getKittensTest() {
        int actualKittensCount = feline.getKittens(expectedkittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertEquals("Количество котят не соответствует ожидаемому", expectedkittensCount, actualKittensCount);
    }

    @Test
    public void getKittensDefaultNumberTest() {
        int actualCountOfKittens = feline.getKittens();
        Mockito.verify(feline).getKittens(EXPECTED_DEFAULT_COUNT_OF_KITTENS);

        assertEquals("Количество котят не соответствует ожидаемому", EXPECTED_DEFAULT_COUNT_OF_KITTENS, actualCountOfKittens);
    }
}
