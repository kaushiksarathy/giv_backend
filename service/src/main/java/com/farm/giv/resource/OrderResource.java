package com.farm.giv.resource;

import com.farm.giv.manager.OrderManager;
import com.farm.giv.request.OrderCreateRequest;
import com.farm.giv.response.OrderResponse;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@javax.inject.Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/order")
public class OrderResource {
    private OrderManager orderManager;

    @Inject
    public OrderResource(OrderManager orderManager){
        this.orderManager = orderManager;
    }


    @Path("/{id}")
    @GET
    public OrderResponse getOrder(@PathParam("id") String id) {
        return orderManager.getOrder(id);
    }

    @POST
    public OrderResponse setOrder(OrderCreateRequest request) {
        return orderManager.setOrder(request);
    }
}

