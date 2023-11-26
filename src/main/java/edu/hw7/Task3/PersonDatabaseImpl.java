package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDatabaseImpl implements PersonDatabase {
    private final Map<Integer, Person> people;
    private final Map<String, List<Integer>> names;
    private final Map<String, List<Integer>> phones;
    private final Map<String, List<Integer>> addresses;

    public PersonDatabaseImpl() {
        this.people = new HashMap<>();
        this.names = new HashMap<>();
        this.phones = new HashMap<>();
        this.addresses = new HashMap<>();
    }

    public Map<Integer, Person> getPeople() {
        return people;
    }

    @Override
    public synchronized void add(Person person) {
        people.put(person.id(), person);
        addByID(names, person.name(), person.id());
        addByID(phones, person.phoneNumber(), person.id());
        addByID(addresses, person.address(), person.id());
    }

    @Override
    public synchronized void delete(int id) {
        Person personToDelete = people.remove(id);
        removeByID(names, personToDelete.name(), id);
        removeByID(phones, personToDelete.phoneNumber(), id);
        removeByID(addresses, personToDelete.address(), id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return findByField(names, name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return findByField(addresses, address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return findByField(phones, phone);
    }

    private void addByID(Map<String, List<Integer>> map, String key, Integer id) {
        map.computeIfAbsent(key, val -> new ArrayList<>()).add(id);
    }

    private void removeByID(Map<String, List<Integer>> map, String key, Integer id) {
        List<Integer> ids = map.get(key);
        if (ids != null) {
            ids.remove(id);
            if (ids.isEmpty()) {
                map.remove(key);
            }
        }
    }

    private List<Person> findByField(Map<String, List<Integer>> map, String key) {
        List<Integer> ids = map.get(key);
        if (ids != null) {
            List<Person> result = new ArrayList<>();
            for (var id : ids) {
                Person person = people.get(id);
                if (person != null) {
                    result.add(person);
                }
            }
            return result;
        }
        return new ArrayList<>();
    }
}
