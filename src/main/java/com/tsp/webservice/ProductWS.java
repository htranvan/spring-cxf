package com.tsp.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;

import com.tsp.model.Product;

@Path("/productWS")
@Scope("request")
public interface ProductWS {

	@GET
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/product/{id}")
	public Product getProduct(@PathParam("id") final String id);

	@Path("/product")
	public String saveProduct();

}
