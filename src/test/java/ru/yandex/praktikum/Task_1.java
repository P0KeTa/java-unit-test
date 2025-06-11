package ru.yandex.praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class Task_1 {
    @Test
    public void checkIsAdultWhenAgeIsMoreThan18True() {
        Program program = new Program();
        boolean isAdult = program.checkIsAdult(19);
        boolean expected = true;
        assertEquals("Пользователь совершеннолетний, но система показывает что нет",expected, isAdult);
    }
}
