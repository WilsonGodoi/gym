package com.will.gym.api.error.v1.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ApiGenericErrorResponse {
    protected int statusCode;
    protected String requestUrl;
    protected Date requestTimestamp;
}
