package com.farm.giv.resource;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import db.Customer;
import lombok.extern.slf4j.Slf4j;
import com.farm.giv.manager.CustomerManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/customer")
public class CustomerResource {

    @Inject
    private CustomerManager customerManager;


    @Path("/{id}")
    @GET
    public Customer getCustomer(@PathParam("id")String id){
        return customerManager.getCustomer(id);
    }
}
