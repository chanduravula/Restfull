package me.sumithpuri.rest.client;

import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;


/**
 * @author sumith_puri
 *
 */
class ProductRESTClient {

	static String REST_WEB_SERVICE="http://localhost:8080/products/rest/product";
	static ClientConfig clientConfig = new ClientConfig();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
				
		try {
			
			ProductRESTClient restClient = new ProductRESTClient();			
			System.out.println("Apache Wink Based REST Client");
			System.out.println("Sumith Kumar Puri (c) 2015");
			System.out.println("=============================");
			
			restClient.configureClient();
			System.out.println();
			
			restClient.invokeGET();
			System.out.println();
					
			String product="Sumith Puri" + (int) (Math.random()*9999);
			restClient.invokePOST(product);
			
			System.out.println();
			product="Sumith Puri" + (int) (Math.random()*9999);
			restClient.invokePOST(product);
			
			System.out.println();
			product="Sumith Puri" + (int) (Math.random()*9999);
			restClient.invokePOST(product);
			
			System.out.println();
			product="Sumith Puri" + (int) (Math.random()*9999);
			restClient.invokePOST(product);
			
			System.out.println();
			restClient.invokeGET();
			
			System.out.println();
			restClient.invokeDELETE(2L);
			
			System.out.println();
			restClient.invokeGET();
			
			System.out.println();
			product="Sumith Puri" + (int) (Math.random()*9999);
			restClient.invokePOST(product);
			
			System.out.println();
			product="Sumith Puri" + (int) (Math.random()*9999);
			restClient.invokePOST(product);

			System.out.println();
			restClient.invokeDELETE(4L);

			System.out.println();
			restClient.invokeGET();
			
			System.out.println();
			restClient.invokePUT(3L,"Sumith Puri");
			
			System.out.println();
			restClient.invokeGET();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

	public void configureClient() {

	}
	
	public void invokeGET() {
		
		System.out.println("Testing GET command....");	
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE);
		String response = resource.accept("text/plain").get(String.class);
		System.out.printf(response);
		System.out.println("...GET command is successful");
	}
	
	public void invokePOST(String product) {
		
		System.out.println("Testing POST command...");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE);
		resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).post(String.class,product);
		System.out.println("...POST command is successful");
	}

	
	public void invokePUT(Long id, String productName) {
		
		System.out.println("Testing PUT command...");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE+"/"+id);
		resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).put(String.class, productName);
		System.out.println("...PUT command is successful");
	}
	
	public void invokeDELETE(Long id) {
		
		System.out.println("Testing DELETE command...");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE+"/"+id);
		resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).delete();
		System.out.println("...DELETE command is successful");
	}
}
