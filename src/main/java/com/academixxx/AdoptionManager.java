package com.academixxx;

import com.academixxx.models.AdoptionRequest;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdoptionManager {
    private final List<AdoptionRequest> requests = new ArrayList<>();
    private int nextId = 1;

    public void createRequest() {
        String animalIdStr = JOptionPane.showInputDialog("Enter animal ID:");
        String adopter = JOptionPane.showInputDialog("Enter adopter name:");
        if (animalIdStr == null || adopter == null) return;
        try {
            int animalId = Integer.parseInt(animalIdStr);
            AdoptionRequest req = new AdoptionRequest(nextId++, animalId, adopter, LocalDate.now());
            requests.add(req);
            JOptionPane.showMessageDialog(null, "Adoption request created:\n" + req);
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
            sb.append(r).append('\n');
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
