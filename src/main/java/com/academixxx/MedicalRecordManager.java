package com.academixxx;

import com.academixxx.models.MedicalRecord;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordManager {
    private final List<MedicalRecord> records = new ArrayList<>();
    private final AnimalManager animalManager;
    private int nextId = 1;

    public MedicalRecordManager(AnimalManager animalManager) {
        this.animalManager = animalManager;
    }

    public void addRecord() {
        String animalIdStr = JOptionPane.showInputDialog("Enter animal ID:");
        if (animalIdStr == null || animalIdStr.isBlank()) return;
        String treatment = JOptionPane.showInputDialog("Enter treatment/vaccine:");
        if (treatment == null || treatment.isBlank()) return;
        try {
            int animalId = Integer.parseInt(animalIdStr);
            if (animalManager.findById(animalId) == null) {
                JOptionPane.showMessageDialog(null, "Animal ID not found.");
                return;
            }
            MedicalRecord record = new MedicalRecord(nextId++, animalId, treatment, LocalDate.now());
            records.add(record);
            JOptionPane.showMessageDialog(null, "Medical record added for Animal #" + animalId + ": " + treatment + ".");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid animal ID.");
        }
    }

    public void listRecords() {
        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No medical records yet.");
            return;
        }
        StringBuilder sb = new StringBuilder("Medical Records:\n");
        for (MedicalRecord r : records) {
            sb.append("#").append(r.id())
              .append(" Animal #").append(r.animalId())
              .append(" - ").append(r.treatment())
              .append(" (Date: ").append(r.date()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
