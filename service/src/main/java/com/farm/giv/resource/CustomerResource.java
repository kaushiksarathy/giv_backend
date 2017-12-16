package com.farm.giv.resource;

import com.farm.giv.manager.CustomerManager;
import com.farm.giv.request.CustomerCreateRequest;
import com.farm.giv.response.CustomerResponse;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/customer")
public class CustomerResource {
    private CustomerManager customerManager;

    @Inject
    public CustomerResource(CustomerManager customerManager){
        this.customerManager = customerManager;
    }

    @Path("/{id}")
    @GET
    public CustomerResponse getCustomer(@PathParam("id")String id){
        return customerManager.getCustomer(id);
    }

    @POST
    public CustomerResponse setCustomer(CustomerCreateRequest request){
        return customerManager.setCustomer(request);
    }
}
