package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private int expectedKittensCount = 5;
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String WRONG_SEX = "Оно";
    private List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");

    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void createLionThrowsExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(WRONG_SEX, feline));
        String exceptionText = "Используйте допустимые значения пола животного - самей или самка";

        assertEquals(exceptionText, exception.getMessage());
    }


@Test
public void getKittensTest() throws Exception {
    Lion lion = new Lion(FEMALE, feline);

    Mockito.when(feline.getKittens()).thenReturn(expectedKittensCount);
    int actualKittensCount = lion.getKittens();

    assertEquals("Неверное количество котят", expectedKittensCount, actualKittensCount);
}

@Test
public void getFoodTest() throws Exception {
    Lion lion = new Lion(MALE, feline);

    Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfFood);
    List<String> actualListOfFood = lion.getFood();

    assertEquals("Лев питается не правильно", expectedListOfFood, actualListOfFood);
}

}
