package dev.local.data;

public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE");

    private final String description;

    Gender(String description) {
        this.description = description;
    }
}
