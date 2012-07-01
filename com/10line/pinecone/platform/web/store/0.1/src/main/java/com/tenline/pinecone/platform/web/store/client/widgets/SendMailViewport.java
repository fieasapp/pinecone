package com.tenline.pinecone.platform.web.store.client.widgets;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.PropertyEditor;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.tenline.pinecone.platform.model.Friend;
import com.tenline.pinecone.platform.model.User;

public class SendMailViewport extends AbstractViewport {
	
	private MainPanel mainPanel;
	
	public SendMailViewport(){
		mainPanel = new MainPanel();
		body.add(mainPanel, new BorderLayoutData(LayoutRegion.CENTER));
	}
	
	public void loadContactInfo(User receiver){
		mainPanel.setContactInfo(receiver);
	}
	
	private class MainPanel extends ContentPanel{
		
		private TextField<String> receiverTextfield;
		private TextField<String> titleTextfield;
		private HtmlEditor contentHtmleditor;
		
		private User sender;
		private User receiver;
		
		public MainPanel(){
		
			setSize("500", "400");
			setHeading("Mail");
			setLayout(new FitLayout());
			
			LayoutContainer mailContainer = new LayoutContainer();
			FormLayout fl_layoutContainer = new FormLayout();
			fl_layoutContainer.setLabelAlign(LabelAlign.TOP);
			fl_layoutContainer.setLabelWidth(60);
			mailContainer.setStyleAttribute("padding", "10px");
			mailContainer.setLayout(fl_layoutContainer);
			
			receiverTextfield = new TextField<String>();
			receiverTextfield.setAllowBlank(false);
			FormData fd_txtfldNewTextfield = new FormData("80%");
			fd_txtfldNewTextfield.setMargins(new Margins(0, 0, 0, 0));
			mailContainer.add(receiverTextfield, fd_txtfldNewTextfield);
			receiverTextfield.setFieldLabel("Receiver");
			
			titleTextfield = new TextField<String>();
			mailContainer.add(titleTextfield, new FormData("80%"));
			titleTextfield.setFieldLabel("Title");
			
			contentHtmleditor = new HtmlEditor();
			mailContainer.add(contentHtmleditor, new FormData("100% 65%"));
			contentHtmleditor.setSize("", "");
			contentHtmleditor.setFieldLabel("Content");
			add(mailContainer, new FitData(5));
			mailContainer.setSize("", "");
			
			ToolBar toolBar = new ToolBar();
			
			FillToolItem fillToolItem = new FillToolItem();
			toolBar.add(fillToolItem);
			
			final Button sendButton = new Button("Send");
			sendButton.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
	//				sendButton.setEnabled(false);
	//				
	//				MailInfo mi = new MailInfo();
	//				mi.setIsRead(false);
	//				mi.setContent(contentHtmleditor.getValue());
	//				mi.setTitle(titleTextfield.getValue());
	//				EnvConfig.getPineconeService().
	//					sendMail(sender, receiverTextfield.getValue(), mi, new AsyncCallback<Boolean>(){
	//
	//						@Override
	//						public void onFailure(Throwable caught) {
	//							MessageBox.info("错误", "调用后台服务发送邮件失败", null);
	//							sendButton.setEnabled(true);
	//						}
	//
	//						@Override
	//						public void onSuccess(Boolean result) {
	//							sendButton.setEnabled(true);
	//							if(parent != null){
	//								parent.loadMails();
	//							}
	//							SendMailWindow.this.hide();
	//						}
	//					
	//				});
				}
			});
			toolBar.add(sendButton);
			sendButton.setWidth("50");
			
			final Button cancelButton = new Button("Cancel");
			cancelButton.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					SendMailViewport.this.hide();
				}
			});
			toolBar.add(cancelButton);
			cancelButton.setWidth("50");
			setBottomComponent(toolBar);
		}
		
		public void setContactInfo(User receiver){
			User user = (User)Registry.get(User.class.getName());
			this.sender = user;
			this.receiver = receiver; 
			
			receiverTextfield.setValue(receiver.getEmail());
		}
	}
}
