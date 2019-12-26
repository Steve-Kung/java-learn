package com.steve.pojo;

import java.util.*;

public class Student {
    private String name;
    private String[] hobbies;
    private List<String> books;
    private Set<String> balls;
    private Map<String, String> cards;
    private Properties jdbc;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Set<String> getBalls() {
        return balls;
    }

    public void setBalls(Set<String> balls) {
        this.balls = balls;
    }

    public Map<String, String> getCards() {
        return cards;
    }

    public void setCards(Map<String, String> cards) {
        this.cards = cards;
    }

    public Properties getJdbc() {
        return jdbc;
    }

    public void setJdbc(Properties jdbc) {
        this.jdbc = jdbc;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", books=" + books +
                ", balls=" + balls +
                ", cards=" + cards +
                ", jdbc=" + jdbc +
                ", address=" + address +
                '}';
    }
}
