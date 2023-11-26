package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDatabaseImpl2 implements PersonDatabase {
    // Решение на основе ReadWriteLock

    private final Map<Integer, Person> people;
    private final Map<String, List<Integer>> names;
    private final Map<String, List<Integer>> phones;
    private final Map<String, List<Integer>> addresses;
    private final ReadWriteLock lock;

    public PersonDatabaseImpl2() {
        this.people = new HashMap<>();
        this.names = new HashMap<>();
        this.phones = new HashMap<>();
        this.addresses = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public Map<Integer, Person> getPeople() {
        return people;
    }

    @Override public void add(Person person) {
        lock.writeLock().lock();
        try {
            people.put(person.id(), person);
            addByID(names, person.name(), person.id());
            addByID(phones, person.phoneNumber(), person.id());
            addByID(addresses, person.address(), person.id());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person personToDelete = people.remove(id);
            removeByID(names, personToDelete.name(), id);
            removeByID(phones, personToDelete.phoneNumber(), id);
            removeByID(addresses, personToDelete.address(), id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return findByField(names, name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return findByField(addresses, address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return findByField(phones, phone);
        } finally {
            lock.readLock().unlock();
        }
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
