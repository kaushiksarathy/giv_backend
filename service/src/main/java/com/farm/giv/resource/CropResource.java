package com.farm.giv.resource;

import com.farm.giv.manager.CropManager;
import com.farm.giv.request.CropCreateRequest;
import com.farm.giv.response.CropResponse;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@javax.inject.Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/crop")
public class CropResource {
    private CropManager cropManager;

    @Inject
    public CropResource(CropManager cropManager){
        this.cropManager = cropManager;
    }

    @Path("/{id}")
    @GET
    public CropResponse getCrop(@PathParam("id") String id) {
        return cropManager.getCrop(id);
    }

    @POST
    public CropResponse setCrop(CropCreateRequest request) {
        return cropManager.setCrop(request);
    }
}
