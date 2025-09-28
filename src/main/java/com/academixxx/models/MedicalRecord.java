package com.academixxx.models;

import java.time.LocalDate;

public record MedicalRecord(int id, int animalId, String treatment, LocalDate date) {
}
