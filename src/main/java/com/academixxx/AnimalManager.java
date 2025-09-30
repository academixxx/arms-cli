package com.academixxx;

import com.academixxx.models.Animal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalManager {
    private final List<Animal> animals = new ArrayList<>();
    private int nextId = 1;

    public void addAnimal() {
        String type = JOptionPane.showInputDialog("Enter animal type:");
        String condition = JOptionPane.showInputDialog("Enter condition:");
        String status = JOptionPane.showInputDialog("Enter status (e.g., Fostered, Available):");

        Animal animal = new Animal(nextId++, type, condition, status);
        animals.add(animal);

        JOptionPane.showMessageDialog(null, "Animal registered:\n" + animal);
    }

    public Animal createAnimal(String type, String condition, String status) {
        Animal animal = new Animal(nextId++, type, condition, status);
        animals.add(animal);
        return animal;
    }

    public Animal findById(int id) {
        for (Animal animal : animals) {
            if (animal.id() == id) return animal;
        }
        return null;
    }

    public void listAnimals() {
        if (animals.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No animals registered yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("Animals:\n");
        for (Animal animal : animals) {
            sb.append(animal).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    /**
     * Returns a copy of the current animals list for reporting/scheduling.
     */
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }
}
