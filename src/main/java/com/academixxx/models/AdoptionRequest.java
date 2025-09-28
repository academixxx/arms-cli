package com.academixxx.models;

import java.time.LocalDate;

public record AdoptionRequest(int id, int animalId, String adopterName, LocalDate date) {
}

