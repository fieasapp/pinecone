package com.tenline.pinecone.platform.web.store.client;

public interface CallbackInter {
	
	public void error();
	
	public void success(String type);

	public void cancel();
}