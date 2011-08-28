/**
 * 
 */
package com.tenline.pinecone.platform.monitor.mina;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.osgi.framework.Bundle;

import com.tenline.pinecone.platform.monitor.AbstractProtocolCodecFactory;

/**
 * @author Bill
 *
 */
public class MinaProtocolCodecFactory extends AbstractProtocolCodecFactory implements ProtocolCodecFactory {
	
	/**
	 * Protocol Decoder
	 */
	private ProtocolDecoder decoder;
	
	/**
	 * Protocol Encoder
	 */
	private ProtocolEncoder encoder;

	/**
	 * 
	 */
	public MinaProtocolCodecFactory() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initialize(Bundle bundle) {
		try {
			Class<?> decoderClass = Class.forName(getPackageName(bundle) + "ProtocolDecoder");
			Constructor<?> decoderConstructor = decoderClass.getDeclaredConstructor(Bundle.class);
			decoder = (ProtocolDecoder) decoderConstructor.newInstance(bundle);
			Class<?> encoderClass = Class.forName(getPackageName(bundle) + "ProtocolEncoder");
			Constructor<?> encoderConstructor = encoderClass.getDeclaredConstructor(Bundle.class);
			encoder = (ProtocolEncoder) encoderConstructor.newInstance(bundle);
			super.initialize(bundle);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public void close() {
		decoder = null;
		encoder = null;
		super.close();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		return encoder;
	}

}
