package com.will.gym.api.error.v1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiBusinessErrorResponse extends ApiGenericErrorResponse {
    public static final int HTTP_STATUS_CODE_UNPROCESSABLE_ENTITY = 422;

    private String logErrorId;
    private String logMessage;

    public ApiBusinessErrorResponse() {
        super();
        statusCode = HTTP_STATUS_CODE_UNPROCESSABLE_ENTITY;
    }

    public static ApiBusinessErrorResponse create(final String requestUrl, final String errorId, final String message) {

        final ApiBusinessErrorResponse response = new ApiBusinessErrorResponse();
        response.setRequestUrl(requestUrl);
        response.setLogMessage(message);
        response.setLogErrorId(errorId);
        response.setRequestTimestamp(new Date());

        return response;
    }
}
