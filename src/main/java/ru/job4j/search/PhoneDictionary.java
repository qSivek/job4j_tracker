package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = x -> x.name().contains(key);
        Predicate<Person> phone = x -> x.phone().contains(key);
        Predicate<Person> address = x -> x.address().contains(key);
        Predicate<Person> surname = x -> x.surname().contains(key);
        Predicate<Person> combine = x -> name.or(phone.or(address.or(surname))).test(x);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}