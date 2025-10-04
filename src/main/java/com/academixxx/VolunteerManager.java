package com.academixxx;

import com.academixxx.models.Volunteer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder manager for volunteers and their basic info.
 * TODO: Add scheduling/tracking of volunteer activities.
 */
public class VolunteerManager {
    private final List<Volunteer> volunteers = new ArrayList<>();
    private int nextId = 1;

    public void addVolunteer() {
        String name = JOptionPane.showInputDialog("Enter volunteer name:");
        if (name == null || name.isBlank()) return;
        String contact = JOptionPane.showInputDialog("Enter contact info:");
        if (contact == null || contact.isBlank()) return;
        Volunteer v = new Volunteer(nextId++, name, contact);
        volunteers.add(v);
        JOptionPane.showMessageDialog(null, "Volunteer added: #" + v.id() + " - " + v.name() + " (" + v.contact() + ")");
    }

    public void listVolunteers() {
        if (volunteers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No volunteers yet.");
            return;
        }
        StringBuilder sb = new StringBuilder("Volunteers:\n");
        for (Volunteer v : volunteers) {
            sb.append("#").append(v.id()).append(" - ").append(v.name()).append(" ( ").append(v.contact()).append(" )\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
