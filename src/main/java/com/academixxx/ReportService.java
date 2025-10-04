package com.academixxx;

import com.academixxx.models.Animal;
import com.academixxx.models.FeedingSchedule;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    /**
     * Generates a simple count of animals by status and type.
     * TODO: Connect to a shared repository/store instead of parameter passing.
     */
    public void reportAnimalPopulation(List<Animal> animals) {
        if (animals == null || animals.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No animals to report.");
            return;
        }
        Map<String, Integer> byStatus = new HashMap<>();
        Map<String, Integer> byType = new HashMap<>();
        for (Animal a : animals) {
            byStatus.merge(a.status(), 1, Integer::sum);
            byType.merge(a.type(), 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder("Animal Population Report\n\nBy Status:\n");
        byStatus.forEach((k, v) -> sb.append(" - ").append(k).append(": ").append(v).append('\n'));
        sb.append("\nBy Type:\n");
        byType.forEach((k, v) -> sb.append(" - ").append(k).append(": ").append(v).append('\n'));
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    /**
     * Generates very basic feeding schedules: 8:00 and 18:00 by default.
     * Returns schedules for the given animals.
     */
    public List<FeedingSchedule> generateFeedingSchedules(List<Animal> animals) {
        List<FeedingSchedule> schedules = new ArrayList<>();
        if (animals == null) return schedules;
        for (Animal a : animals) {
            FeedingSchedule fs = new FeedingSchedule(a.id(), a.id());
            fs.getFeedingTimes().add(LocalTime.of(8, 0));
            fs.getFeedingTimes().add(LocalTime.of(18, 0));
            fs.setNotes("Auto-generated schedule");
            schedules.add(fs);
        }
        return schedules;
    }

    public void showSchedules(List<FeedingSchedule> schedules) {
        if (schedules == null || schedules.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No schedules available.");
            return;
        }
        StringBuilder sb = new StringBuilder("Feeding Schedules:\n");
        for (FeedingSchedule fs : schedules) {
            sb.append("Schedule #").append(fs.getId())
              .append(" for Animal #").append(fs.getAnimalId())
              .append(" - Times: ").append(fs.getFeedingTimes())
              .append((fs.getNotes() == null || fs.getNotes().isBlank()) ? "" : (" | Notes: " + fs.getNotes()))
              .append('\n');
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
