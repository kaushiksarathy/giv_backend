package com.farm.giv.resource;

import com.farm.giv.manager.AddressManager;
import com.farm.giv.request.AddressCreateRequest;
import com.farm.giv.response.AddressResponse;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@javax.inject.Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/address")
public class AddressResource {
    private AddressManager addressManager;

    @Inject
    public AddressResource(AddressManager addressManager){
        this.addressManager = addressManager;
    }

    @Path("/{id}")
    @GET
    public AddressResponse getAddress(@PathParam("id")String id){
        return addressManager.getAddress(id);
    }

    @POST
    public AddressResponse setAddress(AddressCreateRequest request){
        return addressManager.setAddress(request);
    }
}
