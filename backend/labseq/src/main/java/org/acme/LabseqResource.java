package org.acme;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


import java.math.BigInteger;

@Path("/labseq")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Labseq", description = "Labseq sequence calculator")
public class LabseqResource {

    @Inject
    LabseqService service;

    @GET
    @Path("/{n}")
    @Operation(summary = "Calculate labseq value",
            description = "Returns the value at position n in the labseq sequence")
    @APIResponse(responseCode = "200", description = "Labseq value calculated successfully")
    @APIResponse(responseCode = "400", description = "Invalid input: n must be non-negative")
    public Response getLabseq(@PathParam("n") @Parameter(description = "Non-negative integer index") int n) {

        if (n < 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("n must be non negative integer ")
                    .build();
        }

        BigInteger result = service.labseq(n);
        return Response.ok(result.toString()).build();
    }


}
