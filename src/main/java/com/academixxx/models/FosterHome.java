package com.academixxx.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder model representing a foster home.
 * TODO: Expand with validation and persistence integration.
 */
public class FosterHome {
    private int id;
    private String caretakerName;
    private String address;
    private int capacity;
    private final List<Integer> animalIds = new ArrayList<>();

    public FosterHome(int id, String caretakerName, String address, int capacity) {
        this.id = id;
        this.caretakerName = caretakerName;
        this.address = address;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getCaretakerName() {
        return caretakerName;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Integer> getAnimalIds() {
        return animalIds;
    }

    public boolean hasSpace() {
        return animalIds.size() < capacity;
    }

    @Override
    public String toString() {
        return "FosterHome#" + id + " (" + caretakerName + ") capacity=" + capacity + " at " + address +
                " animals=" + animalIds;
    }
}
