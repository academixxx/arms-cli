package com.academixxx.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder model for feeding/care schedule.
 * TODO: refine representation (e.g., cron-like schedules, caretaker assignment).
 */
public class FeedingSchedule {
    private int id;
    private int animalId;
    private final List<LocalTime> feedingTimes = new ArrayList<>();
    private String notes;

    public FeedingSchedule(int id, int animalId) {
        this.id = id;
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public List<LocalTime> getFeedingTimes() {
        return feedingTimes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "FeedingSchedule#" + id + " animal=" + animalId + " times=" + feedingTimes +
                (notes == null || notes.isBlank() ? "" : (" notes=" + notes));
    }
}
