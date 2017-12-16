package com.farm.giv.resource;

import com.farm.giv.manager.PriceManager;
import com.farm.giv.request.PriceCreateRequest;
import com.farm.giv.response.PriceResponse;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@javax.inject.Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/price")
public class PriceResource {
    private PriceManager priceManager;

    @Inject
    public PriceResource(PriceManager priceManager){
        this.priceManager = priceManager;
    }

    @Path("/{id}")
    @GET
    public PriceResponse getPrice(@PathParam("id")String id){
        return priceManager.getPrice(id);
    }

    @POST
    public PriceResponse setPrice(PriceCreateRequest request){
        return priceManager.setPrice(request);
    }
}

