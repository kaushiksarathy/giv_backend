package com.farm.giv.resource;

import com.farm.giv.manager.StockManager;
import com.farm.giv.request.StockCreateRequest;
import com.farm.giv.response.StockResponse;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@javax.inject.Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/stock")
public class StockResource {
    private StockManager stockManager;

    @Inject
    public StockResource(StockManager stockManager){
        this.stockManager = stockManager;
    }

    @Path("/{id}")
    @GET
    public StockResponse getStock(@PathParam("id")String id){
        return stockManager.getStock(id);
    }

    @POST
    public StockResponse setStock(StockCreateRequest request){
        return stockManager.setStock(request);
    }
}
