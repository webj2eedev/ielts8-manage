package com.webj2eedev.ieltsnote.common.web;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

@Slf4j
public class WrapperResponse<T> implements Serializable {
	  private static final long serialVersionUID = 5778573516446596671L;
	  
	  public static int OK = 0;
	  
	  public static int FAIL = -1;
	  
	  public static String MSG_OK = "ok";
	  
	  public static String MSG_WARNING = "warning";
	  
	  public static String MSG_FAIL = "fail";
	  
	  private int code = 0;
	  private String msg = "ok";
	  private T data;
	  
	  public WrapperResponse() {}
	  
	  public WrapperResponse(int code, String msg, T data) {
	    this.code = code;
	    this.msg = msg;
	    this.data = data;
	  }
	  
	  public static <T> WrapperResponse<T> ok(T data) {
	    return new WrapperResponse<>(OK, MSG_OK, data);
	  }
	  
	  public static <T> WrapperResponse<T> ok(String message, T data) {
	    message = (message != null && message.length() > 0) ? message : MSG_OK;
	    return new WrapperResponse<T>(OK, message, data);
	  }
	  
	  public static <T> WrapperResponse<T> info(int code, String message, T data) {
	    message = (message != null && message.length() > 0) ? message : MSG_OK;
	    return new WrapperResponse<>(code, message, data);
	  }
	  
	  public static <T> WrapperResponse<T> warning(int code, String message, T data) {
	    message = (message != null && message.length() > 0) ? message : MSG_WARNING;
	    return new WrapperResponse<>(code, message, data);
	  }
	  
	  public static <T> WrapperResponse<T> error(int code, String message, T data) {
	    message = (message != null && message.length() > 0) ? message : MSG_FAIL;
	    return new WrapperResponse<>(code, message, data);
	  }
	  
	  public static <T> WrapperResponse<T> fail(T data) {
	    return new WrapperResponse<>(FAIL, MSG_FAIL, data);
	  }
	  
	  public static <T> WrapperResponse<T> fail(String message, T data) {
	    message = (message != null && message.length() > 0) ? message : MSG_FAIL;
	    return new WrapperResponse<>(FAIL, message, data);
	  }
	  
	  public static String toOKJsonString(String jsondata) {
		    JSONObject rejson = new JSONObject();
		    
		    try {
		    	rejson.put("code", 0);
			    rejson.put("msg", "ok");
				rejson.put("data", jsondata);
			} catch (JSONException e) {
				log.error("返回json", e);
			}
		    
		    return rejson.toString();
	  }
	  
	  public static String toOKJsonString(String msg, String jsondata) {
		    JSONObject rejson = new JSONObject();
		    
		    try {
		    	rejson.put("code", 0);
			    rejson.put("msg", msg);
				rejson.put("data", jsondata);
			} catch (JSONException e) {
				log.error("返回json", e);
			}
		    
		    return rejson.toString();
	  }
	  
	  public static String toOKJsonString(JSONArray jsondata) {
		    JSONObject rejson = new JSONObject();
		    
		    try {
		    	rejson.put("code", 0);
			    rejson.put("msg", "ok");
				rejson.put("data", jsondata);
			} catch (JSONException e) {
				log.error("返回json", e);
			}
		    
		    return rejson.toString();
	  }
	  
	  public static String toOKJsonString(JSONObject jsondata) {
		    JSONObject rejson = new JSONObject();
		   
		    try {
		    	rejson.put("code", 0);
			    rejson.put("msg", "ok");
				rejson.put("data", jsondata);
			} catch (JSONException e) {
				log.error("返回json", e);
			}
		    
		    return rejson.toString();
	  }
	  
	  public static String toOKJsonString(String msg, JSONObject jsondata) {
		    JSONObject rejson = new JSONObject();
		   
		    try {
		    	rejson.put("code", 0);
			    rejson.put("msg", msg);
				rejson.put("data", jsondata);
			} catch (JSONException e) {
				log.error("返回json", e);
			}
		    
		    return rejson.toString();
	  }
	  
	  public static String toErrorJsonString(int code, String msg) {
		    JSONObject rejson = new JSONObject();
		   
		    try {
		    	rejson.put("code", code);
			    rejson.put("msg", msg);
				rejson.put("data", "");
			} catch (JSONException e) {
				log.error("返回json", e);
			}
		    
		    return rejson.toString();
	  }
	  
	  public int getCode() {
	    return this.code;
	  }
	  
	  public void setCode(int code) {
	    this.code = code;
	  }
	  
	  public String getMsg() {
	    return this.msg;
	  }
	  
	  public void setMsg(String msg) {
	    this.msg = msg;
	  }
	  
	  public T getData() {
	    return this.data;
	  }
	  
	  public void setData(T data) {
	    this.data = data;
	  }
	}