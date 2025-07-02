package org.acme;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/labseq")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LabseqResource {

    @Inject
    LabseqService service;

    @GET
    @Path("/{n}")
    public Response getLabseq(int n) {

        if (n < 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("n must be non negative integer ")
                    .build();
        }

        long result = service.labseq(n);
        return Response.ok(result).build();
    }


}
