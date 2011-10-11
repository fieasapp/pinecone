/**
 * 
 */
package com.tenline.pinecone.platform.sdk;

/**
 * @author Bill
 *
 */
public abstract class AbstractAPI {

	protected String url;
	
	protected APIListener listener;

	/**
	 * 
	 * @param host
	 * @param port
	 * @param listener
	 */
	public AbstractAPI(String host, String port, APIListener listener) {
		// TODO Auto-generated constructor stub
		url = "http://" + host + ":" + port;
		this.listener = listener;
	}

}
