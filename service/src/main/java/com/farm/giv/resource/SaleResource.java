package com.farm.giv.resource;

import com.farm.giv.manager.SalesManager;
import com.farm.giv.request.SaleCreateRequest;
import com.farm.giv.response.SaleResponse;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@javax.inject.Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/sales")
public class SaleResource {
    private SalesManager salesManager;

    @Inject
    public SaleResource(SalesManager salesManager){
        this.salesManager = salesManager;
    }

    @Path("/{id}")
    @GET
    public SaleResponse getSales(@PathParam("id")String id){
        return salesManager.getSales(id);
    }

    @POST
    public SaleResponse setSales(SaleCreateRequest request){
        return salesManager.setSales(request);
    }
}

