package com.blogbasbas.chatsimple.model;


import com.google.gson.annotations.SerializedName;


public class MessageItem{

	@SerializedName("message_sender")
	private String messageSender;

	@SerializedName("message_unread")
	private String messageUnread;

	@SerializedName("message_body")
	private String messageBody;

	@SerializedName("message_id")
	private String messageId;

	@SerializedName("message_to")
	private String messageTo;

	@SerializedName("message_post_date")
	private String messagePostDate;

	public void setMessageSender(String messageSender){
		this.messageSender = messageSender;
	}

	public String getMessageSender(){
		return messageSender;
	}

	public void setMessageUnread(String messageUnread){
		this.messageUnread = messageUnread;
	}

	public String getMessageUnread(){
		return messageUnread;
	}

	public void setMessageBody(String messageBody){
		this.messageBody = messageBody;
	}

	public String getMessageBody(){
		return messageBody;
	}

	public void setMessageId(String messageId){
		this.messageId = messageId;
	}

	public String getMessageId(){
		return messageId;
	}

	public void setMessageTo(String messageTo){
		this.messageTo = messageTo;
	}

	public String getMessageTo(){
		return messageTo;
	}

	public void setMessagePostDate(String messagePostDate){
		this.messagePostDate = messagePostDate;
	}

	public String getMessagePostDate(){
		return messagePostDate;
	}

	@Override
 	public String toString(){
		return 
			"MessageItem{" + 
			"message_sender = '" + messageSender + '\'' + 
			",message_unread = '" + messageUnread + '\'' + 
			",message_body = '" + messageBody + '\'' + 
			",message_id = '" + messageId + '\'' + 
			",message_to = '" + messageTo + '\'' + 
			",message_post_date = '" + messagePostDate + '\'' + 
			"}";
		}
}