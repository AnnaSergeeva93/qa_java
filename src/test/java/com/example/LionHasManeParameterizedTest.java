package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionHasManeParameterizedTest {
    String sex;
    boolean hasMane;

    public LionHasManeParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Mock
    private Feline feline;

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] setSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals("Грива есть только у льва", hasMane, lion.doesHaveMane());
    }
}
