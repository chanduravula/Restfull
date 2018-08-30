/**
 * 
 */
package me.sumithpuri.rest.vo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
