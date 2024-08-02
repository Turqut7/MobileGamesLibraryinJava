package model;

public class Game {
    private static int idCounter = 1;
    private int id;
    private String name;
    private GameCategory category;
    private double size;

    public Game(String name, GameCategory category, double size) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GameCategory getCategory() {
        return category;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category + ", Size: " + size + "MB";
    }
}