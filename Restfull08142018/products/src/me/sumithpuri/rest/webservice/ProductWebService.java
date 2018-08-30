/**
 * 
 */
package me.sumithpuri.rest.webservice;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.sumithpuri.rest.persistence.ProductPersistenceManager;
import me.sumithpuri.rest.vo.Product;

/**
 * @author sumith_puri
 *
 */
@Path("product")
public class ProductWebService {

	ProductPersistenceManager persistenceManager = ProductPersistenceManager.getInstance();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProducts() {
		
		List<Product> products = persistenceManager.get();
		String productList = new String();
		
		for(Product producti: products) {
			productList+=producti.toString() + "\n";
		}
		
		// return as plain text - other types include xml, json
		return productList;
	}
	
	@POST
	public String addProducts(String productStr) {
		
		Product product = new Product();
		product.setName(productStr);
		persistenceManager.add(product);
		
		return productStr;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteProduct(@PathParam(value="id") long id) {
		
		persistenceManager.delete(id);
		return;
	}
	
	@PUT
	@Path("/{id}")
	public void modifyProduct(@PathParam(value="id") long id, String productName) {
		
		persistenceManager.update(id, productName);
		return;
	}
}
