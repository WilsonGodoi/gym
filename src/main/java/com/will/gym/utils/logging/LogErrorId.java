package com.will.gym.utils.logging;

public enum LogErrorId {

    PERSISTENCE_ERROR(
            "GYM4001",
            "Client request is invalid due to a persistence error. User email [%s] and firstName [%s]"),
    CONFIRMATION_PASSWORD_ERROR(
            "GYM4002",
            "Client request is invalid due to a persistence error. Confirm password is not the same as password. User email [%s] and firstName [%s]");

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
