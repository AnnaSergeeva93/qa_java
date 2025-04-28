package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    private List<String> expectedListOfFriends = List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
    private String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";
    private int expectedCountOfKittens = 0;

    private LionAlex lionAlex;

    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        lionAlex = new LionAlex(feline);
    }

    @Test
    public void getFriendsTest() {
        List<String> actualListOfFriends = lionAlex.getFriends();

        assertEquals("Неверный список друзей льва Алекса", expectedListOfFriends, actualListOfFriends);
    }

    @Test
    public void placeOfLivingTest() {
        String actualPlaceOfLiving = lionAlex.getPlaceOfLiving();

        assertEquals("Неверное место проживания льва Алекса", expectedPlaceOfLiving, actualPlaceOfLiving);
    }

    @Test
    public void getKittensTest() {
        int actualCountOfKittens = lionAlex.getKittens();

        assertEquals("Неверное количество львят у льва Алекса", expectedCountOfKittens, actualCountOfKittens);
    }

}
