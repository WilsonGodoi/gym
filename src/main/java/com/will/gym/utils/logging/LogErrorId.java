package com.will.gym.utils.logging;

public enum LogErrorId {

    PERSISTENCE_ERROR(
            "GYM4001",
            "Client request is invalid due to a persistence error. User email [%s] and firstName [%s]"),
    CONFIRMATION_PASSWORD_ERROR(
            "GYM4002",
            "Confirm password is not the same as password. User email [%s] and firstName [%s]"),

    LOGIN_ERROR(
            "GYM4003",
            "Invalid user or password"),
    INVALID_EXERCISE_GROUP(
            "GYM4004",
            "Invalid exercise group"),

    INVALID_TIME_IN_SECONDS_AND_DISTANCE_IN_METERS(
            "GYM4005",
            "Invalid time in seconds and distance in meters");

    private final String code;

    private final String description;

    LogErrorId(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {

        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
