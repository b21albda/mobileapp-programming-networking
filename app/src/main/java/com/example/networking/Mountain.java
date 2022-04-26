package com.example.networking;

public class Mountain {
    private String ID;
    private String name;
    private String location;
    private int size;
    private int cost;
    private Auxdata auxdata;

    public Mountain(String ID, String name, String location, int size, int cost, Auxdata auxdata) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.size = size;
        this.cost = cost;
        this.auxdata = auxdata;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }
}
