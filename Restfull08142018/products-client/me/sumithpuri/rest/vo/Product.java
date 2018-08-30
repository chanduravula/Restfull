/**
 * 
 */
package me.sumithpuri.rest.vo;

/**
 * @author sumith_puri
 *
 */
public class Product {

	long id;
	String name;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String productStr="ID:" + this.id + ", NAME: " + this.name;
		return productStr;
	}
}
