/**
 * 
 */
package com.honking.pet.aquarium.efish;

import java.util.ArrayList;
import java.util.LinkedList;

import org.osgi.framework.Bundle;

import com.tenline.pinecone.platform.model.Device;
import com.tenline.pinecone.platform.model.Item;
import com.tenline.pinecone.platform.model.Variable;
import com.tenline.pinecone.platform.monitor.AbstractProtocolBuilder;

/**
 * @author Bill
 *
 */
public class EfishProtocolBuilder extends AbstractProtocolBuilder {
	
	/**
	 * EFish Protocol Meta Data
	 */
	private static Device metaData;
	
	/**
	 * 
	 * @param bundle
	 */
	public EfishProtocolBuilder(Bundle bundle) {
		super(bundle);
		// TODO Auto-generated constructor stub
		if (metaData == null) {
			metaData = new Device();
			metaData.setName(bundle.getHeaders().get("Bundle-Name").toString());
			metaData.setSymbolicName(bundle.getSymbolicName());
			metaData.setVersion(bundle.getVersion().toString());
			metaData.setVariables(new ArrayList<Variable>());
			
			Variable variable = new Variable();
			variable.setName(bundle.getHeaders().get("Water-Temperature").toString()); // Localization
			variable.setType("read_write_discrete");
			variable.setItems(new ArrayList<Item>());
			
			for (int i=20; i<=30; i++) {
				Item item = new Item();
				item.setText(String.valueOf(i) + "°C");
				item.setValue(String.valueOf(i));
				variable.getItems().add(item);
			}
			
			metaData.getVariables().add(variable);	
			
			variable = new Variable();
			variable.setName(bundle.getHeaders().get("Oxygen-Generation").toString());
			variable.setType("write_discrete");
			variable.setItems(new ArrayList<Item>());
			
			for (int i=1; i<=3; i++) {
				for (int j=5; j<=10; j++) {
					Item item = new Item();
					item.setText(bundle.getHeaders().get("Work").toString() + i + bundle.getHeaders().get("Minute").toString() + 
							", " + bundle.getHeaders().get("Stop").toString() + j + bundle.getHeaders().get("Minute").toString());
					item.setValue(i + "-" + j);
					variable.getItems().add(item);
				}
			}
			
			metaData.getVariables().add(variable);	
		}
	}
	
	/**
	 * Get Meta Data
	 * @return
	 */
	public static Device getMetaData() {
		return metaData;
	}

	@Override
	public void initializeReadQueue(LinkedList<Device> queue) {
		// TODO Auto-generated method stub
		Device device = new Device();
		device.setVariables(new ArrayList<Variable>());
		Variable variable = new Variable();
		variable.setName(bundle.getHeaders().get("Water-Temperature").toString());
		device.getVariables().add(variable);
		queue.addLast(device);
	}

}
