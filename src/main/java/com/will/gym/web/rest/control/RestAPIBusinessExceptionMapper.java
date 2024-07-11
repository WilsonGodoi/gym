package com.will.gym.web.rest.control;

import com.will.gym.api.error.v1.entity.ApiBusinessErrorResponse;
import com.will.gym.utils.exceptions.BusinessException;
import jakarta.annotation.Priority;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(400)
public class RestAPIBusinessExceptionMapper implements ExceptionMapper<BusinessException> {
    @Context
    private UriInfo uriInfo;

    public RestAPIBusinessExceptionMapper() {
        super();
    }

    @Override
    public Response toResponse(BusinessException e) {
        String url = null;
        if (uriInfo != null) {
            url = uriInfo.getAbsolutePath() != null ? uriInfo.getAbsolutePath().toString() : null;
        }

        final ApiBusinessErrorResponse apiBusinessErrorResponse =
                ApiBusinessErrorResponse.create(url, e.getErrorCode(), e.getMessage());

        return Response.status(apiBusinessErrorResponse.getStatusCode()).entity(apiBusinessErrorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
