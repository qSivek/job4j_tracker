package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.passport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicatePassport() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen1 = new Citizen("2f44a", "Andrey Voltov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(citizen1)).isFalse();
    }
}