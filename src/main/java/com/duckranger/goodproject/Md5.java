package com.duckranger.goodproject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	public String getHash(String str){
	    MessageDigest md5; 
	    StringBuffer  hexString = new StringBuffer();
	    try{
	    	md5 = MessageDigest.getInstance("md5");
	    	md5.reset();
	    	md5.update(str.getBytes());
	    	
	    	byte[] byteData = md5.digest();
	    	
	    	for (int i=0; i<byteData.length; i++){
	    		hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	    	}
	    	
	    }catch(NoSuchAlgorithmException e){
	    	return e.toString();	    	
	    }
	    return hexString.toString();		
	}

}
