package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).surname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNoFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Frank", "Lampard", "8800553535", "London")
        );
        ArrayList<Person> persons = phones.find("Zola");
        assertThat(persons.size()).isEqualTo(0);
    }
}