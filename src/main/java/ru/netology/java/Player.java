package ru.netology.java;

public class Player {
    private int id; // уник.номер
    private String name; // имя
    private int strength; // уровень силы

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }
}
