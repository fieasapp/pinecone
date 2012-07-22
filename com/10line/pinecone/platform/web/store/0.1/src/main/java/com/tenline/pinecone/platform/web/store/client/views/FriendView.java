/**
 * 
 */
package com.tenline.pinecone.platform.web.store.client.views;

import java.util.ArrayList;
import java.util.Collection;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelFactory;
import com.extjs.gxt.ui.client.data.BeanModelLookup;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.tenline.pinecone.platform.model.Friend;
import com.tenline.pinecone.platform.model.User;
import com.tenline.pinecone.platform.web.store.client.events.FriendEvents;
import com.tenline.pinecone.platform.web.store.client.events.UserEvents;
import com.tenline.pinecone.platform.web.store.client.widgets.FriendViewport;
import com.tenline.pinecone.platform.web.store.client.widgets.HomeViewport;

/**
 * @author Bill
 *
 */
public class FriendView extends View {

	/**use to generate friend BeanModel*/
	private BeanModelFactory friendFactory = BeanModelLookup.get().getFactory(Friend.class);
	/**
	 * @param controller
	 */
	public FriendView(Controller controller) {
		super(controller);
	}

	@Override
	protected void handleEvent(AppEvent event) {
		try {
			if (event.getType().equals(FriendEvents.GET_BY_USER)) {
				loadFriends(event);	
			} else if (event.getType().equals(FriendEvents.GET_REQUESTS)) {
				loadRequests(event);	
			}else if (event.getType().equals(FriendEvents.ADD)) {
				addFriend(event);
			} else if (event.getType().equals(FriendEvents.DELETE)) {
				deleteFriend(event);	
			} else if (event.getType().equals(FriendEvents.SETTING)) {
				deleteFriend(event);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadFriends(AppEvent event){
		System.out.println("FriendView loadFriend");
		User user = (User)Registry.get(User.class.getName());
		Collection<Friend> userFriends = (Collection<Friend>)event.getData();
		
		Collection<BeanModel> models = new ArrayList<BeanModel>();
 		for(Friend f:userFriends){
			BeanModel bm = friendFactory.createModel(f);
			if(f.getReceiver().getId().equals(user.getId())){
				bm.set("thisfriend", f.getSender());
				bm.set("thisowner", f.getReceiver());
			}else{
				bm.set("thisfriend", f.getReceiver());
				bm.set("thisowner", f.getSender());
			}
			
			models.add(bm);
		}
//		//TODO
//		for(Friend f:userFriends){
//			System.out.println("$$$Type"+f.getType());
//			System.out.println("$$$receiver Name:"+f.getReceiver().getName());
//			System.out.println("$$$receiver Email:"+f.getReceiver().getEmail());
//			System.out.println("$$$receiver Password:"+f.getReceiver().getPassword());
//		}
		
		HomeViewport homeView = (HomeViewport)Registry.get(HomeViewport.class.getName());
		homeView.loadFriends(models);
		
		FriendViewport friendView = (FriendViewport)Registry.get(FriendViewport.class.getName());
		friendView.loadFriends(models);
	}
	
	@SuppressWarnings("unchecked")
	public void loadRequests(AppEvent event){
		System.out.println("FriendView loadRequests");
		Collection<Friend> reqs = (Collection<Friend>)event.getData();
		System.out.println("friend size:"+reqs.size());
		FriendViewport friendView = (FriendViewport)Registry.get(FriendViewport.class.getName());
		friendView.loadFriendInvite(reqs);
	}
	
	public void addFriend(AppEvent event){
		AppEvent appEvent1 = new AppEvent(FriendEvents.GET_BY_USER);
		Dispatcher.get().dispatch(appEvent1);
		
		AppEvent appEvent2 = new AppEvent(FriendEvents.GET_REQUESTS);
		Dispatcher.get().dispatch(appEvent2);
		
		AppEvent appEvent3 = new AppEvent(UserEvents.GET_ALL_USER);
		Dispatcher.get().dispatch(appEvent3);
	}
	
	public void deleteFriend(AppEvent event){
		AppEvent appEvent1 = new AppEvent(FriendEvents.GET_BY_USER);
		Dispatcher.get().dispatch(appEvent1);
		
		AppEvent appEvent2 = new AppEvent(UserEvents.GET_ALL_USER);
		Dispatcher.get().dispatch(appEvent2);
	}
	
	public void settingFriend(AppEvent event){
		AppEvent appEvent1 = new AppEvent(FriendEvents.GET_BY_USER);
		Dispatcher.get().dispatch(appEvent1);
		
		AppEvent appEvent2 = new AppEvent(FriendEvents.GET_REQUESTS);
		Dispatcher.get().dispatch(appEvent2);
	}

}
