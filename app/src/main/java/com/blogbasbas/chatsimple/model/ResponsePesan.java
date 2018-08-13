package com.blogbasbas.chatsimple.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponsePesan{

	@SerializedName("msg")
	private String msg;

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private List<MessageItem> message;

	@SerializedName("status")
	private boolean status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(List<MessageItem> message){
		this.message = message;
	}

	public List<MessageItem> getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePesan{" + 
			"msg = '" + msg + '\'' + 
			",code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}