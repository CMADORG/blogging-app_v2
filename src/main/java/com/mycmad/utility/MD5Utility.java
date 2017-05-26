package com.mycmad.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utility {

	public static String generatePasswordHash(String password)
	{
		try {
			
//			System.out.println("********************");
//			byte[] pb = password.getBytes();
//			for(byte b: pb)
//			{
//				System.out.println(b);
//			}
//			
//			System.out.println("*********************");
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] hash =  md.digest();
		//	System.out.println(hash.length);
		//	byte[] pb = hash.length;
			StringBuffer sb = new StringBuffer();
			for(byte b: hash)
			{
				//System.out.println(b);
				//System.out.println(Integer.toString((b & 0xFF) , 16).substring(0));
				sb.append(Integer.toString((b & 0xFF) + 0x100 , 16).substring(1));
			}
			
			//System.out.println(sb);
			//System.out.println(sb.toString());
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "deadbeef";	
	}

}
