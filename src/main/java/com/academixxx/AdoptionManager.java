package com.academixxx;

import com.academixxx.models.AdoptionRequest;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdoptionManager {
    private final List<AdoptionRequest> requests = new ArrayList<>();
    private final AnimalManager animalManager;
    private int nextId = 1;

    public AdoptionManager(AnimalManager animalManager) {
        this.animalManager = animalManager;
    }

    public void createRequest() {
        String animalIdStr = JOptionPane.showInputDialog("Enter animal ID:");
        if (animalIdStr == null || animalIdStr.isBlank()) return;
        String adopter = JOptionPane.showInputDialog("Enter adopter name:");
        if (adopter == null || adopter.isBlank()) return;
        try {
            int animalId = Integer.parseInt(animalIdStr);
            if (animalManager.findById(animalId) == null) {
                JOptionPane.showMessageDialog(null, "Animal ID not found.");
                return;
            }
            AdoptionRequest req = new AdoptionRequest(nextId++, animalId, adopter, LocalDate.now());
            requests.add(req);
            JOptionPane.showMessageDialog(null, "Adoption request created for Animal #" + animalId + " by " + adopter + ".");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid animal ID.");
        }
    }

    public void listRequests() {
        if (requests.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No adoption requests.");
            return;
        }
        StringBuilder sb = new StringBuilder("Adoption Requests:\n");
        for (AdoptionRequest r : requests) {
            sb.append("#").append(r.id())
              .append(" Animal #").append(r.animalId())
              .append(" - Adopter: ").append(r.adopterName())
              .append(" (Date: ").append(r.date()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
