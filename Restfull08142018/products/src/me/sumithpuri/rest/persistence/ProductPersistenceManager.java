/**
 * 
 */
package me.sumithpuri.rest.persistence;


import java.util.ArrayList;
import java.util.List;

import me.sumithpuri.rest.vo.Product;

/**
 * @author sumith_puri
 *
 */
public class ProductPersistenceManager {

	private List<Product> productDatabase = new ArrayList<Product>();
	private static ProductPersistenceManager persistenceManager;
	private static int id=0;
	
	private ProductPersistenceManager() {
		
	}
	
	public void add(Product product) {
		
		System.out.println("database: added one product");
		
		// atomic id creation
		id++;
		product.setId(id);
		productDatabase.add(product);
	}
	
	public List<Product> get() {
		System.out.println("database: retrieved all products");
		return productDatabase;
	}
	
	public void update(long productId, String productName) {
		System.out.println("database: modified one product");
		
		for(int i=0;i<productDatabase.size();i++) {
			
			Product product = productDatabase.get(i);
			if(product.getId()==productId) {
				product.setName(productName);
				productDatabase.remove(i);
				productDatabase.add(i,product);
			}
		}
		return;
	}
	
	public void delete(long productId) {
		System.out.println("database: deleted one product");
		
		for(int i=0;i<productDatabase.size();i++) {
			
			Product product = productDatabase.get(i);
			if(product.getId()==productId) productDatabase.remove(i);
		}
		return;
	}
	
	public static ProductPersistenceManager getInstance() {
		
		if(persistenceManager==null) {
			synchronized(ProductPersistenceManager.class) {
				if(persistenceManager==null) {
					persistenceManager = new ProductPersistenceManager();
				}
			}
		}
		return persistenceManager;
	}
}
