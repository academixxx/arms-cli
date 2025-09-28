package com.academixxx.models;

import java.time.LocalDate;

public record RescueEvent(int id, int animalId, String location, String rescuer, LocalDate date) {
}
