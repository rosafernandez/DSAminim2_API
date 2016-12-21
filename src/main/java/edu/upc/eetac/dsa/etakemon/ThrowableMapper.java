package edu.upc.eetac.dsa.etakemon;

import edu.upc.eetac.dsa.etakemon.entity.EtakemonError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        throwable.printStackTrace();
        EtakemonError error = new EtakemonError(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), throwable.getMessage());
        return Response.status(error.getStatus()).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}