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
        if (type == null || type.isBlank()) return;
        String condition = JOptionPane.showInputDialog("Enter condition:");
        if (condition == null || condition.isBlank()) return;
        String status = JOptionPane.showInputDialog("Enter status (e.g., Fostered, Available):");
        if (status == null || status.isBlank()) return;
        Animal animal = new Animal(nextId++, type, condition, status);
        animals.add(animal);
        JOptionPane.showMessageDialog(null, "Animal registered: #" + animal.id() + " - " + type + " | " + condition + " | " + status);
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

        StringBuilder sb = new StringBuilder();
        for (Animal animal : animals) {
            sb.append("#").append(animal.id()).append(" - ")
              .append(animal.type()).append(" | ")
              .append(animal.condition()).append(" | ")
              .append(animal.status()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Animals", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Returns a copy of the current animals list for reporting/scheduling.
     */
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }
}
