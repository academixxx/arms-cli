package com.academixxx;

import com.academixxx.models.MedicalRecord;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordManager {
    private final List<MedicalRecord> records = new ArrayList<>();
    private int nextId = 1;

    public void addRecord() {
        String animalIdStr = JOptionPane.showInputDialog("Enter animal ID:");
        String treatment = JOptionPane.showInputDialog("Enter treatment/vaccine:");
        if (animalIdStr == null || treatment == null) return;
        try {
            int animalId = Integer.parseInt(animalIdStr);
            MedicalRecord record = new MedicalRecord(nextId++, animalId, treatment, LocalDate.now());
            records.add(record);
            JOptionPane.showMessageDialog(null, "Medical record added:\n" + record);
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
            sb.append(r).append('\n');
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
