package com.phoenixInfoTech.security;

import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Skey {
	
	private final String dbUserName = "cGhvZW5peA==";
	private final String dbPassword = "UGhvZW5peCEyMw==";
	
	public DBSecurityObject getDBSkey(String encodedDBUser, String encondedDBPassword) {
		DBSecurityObject dbs = null;
		if(isSafe()) {
			if(authenticateDBUser(encodedDBUser) && authenticateDBPassword(encondedDBPassword)) {
				dbs = createDBSecurityObject();
			}
		}
		return dbs;
	}
	
	private DBSecurityObject createDBSecurityObject() {
		DBSecurityObject dbs = new DBSecurityObject();
		dbs.setDbUserName(new String(Base64.getDecoder().decode(dbUserName)));
		dbs.setDbPassword(new String(Base64.getDecoder().decode(dbPassword)));
		return dbs;
	}
	
	private Boolean isSafe(){
		if(System.getenv("SKEY").equals("123456")) {
			return true;
		}
		return false;
	}
	
	private Boolean authenticateDBUser (String encodedUserName) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		if(encoder.matches(new String(Base64.getDecoder().decode(dbUserName)), encodedUserName)) {
			return true;
		}  
		return false;
	}
	
	private Boolean authenticateDBPassword (String encodedPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		if(encoder.matches(new String(Base64.getDecoder().decode(dbPassword)), encodedPassword)) {
			return true;
		}  
		return false;
	}
	
	

//  to generate
//	public final String getDBUserName(String dbUserName) {
//		int i = 0;
//		String password = "phoenix";
//		while (i < 10) {
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			String hashedPassword = passwordEncoder.encode(password);
//
//			System.out.println(hashedPassword);
//			i++;
//		}
//		return "";
//	}
	
//	public static void main(String args[]) {
//		Skey skey = new Skey();
//		DBSecurityObject dbs = skey.getDBSkey("$2a$10$dadOYjKGyEk0t3iTCF731OtTfllCpq7agJxaEl.6Zlx3BFraQhnaC", "$2a$10$Ef4INPeVBp4LiHBvd4P9qu.hGc3Ji/EKwZLO3uuZgNFMwTzfyjNlm");
//		if(dbs==null) {
//			System.out.println("fail");
//		}
//		else {
//			System.out.println("DBUser : " + dbs.getDbUserName() );
//		}
//		
//		String asB64;
//		try {
//			asB64 = Base64.getEncoder().encodeToString("Phoenix!23".getBytes("utf-8"));
//			System.out.println(asB64);
//			
//			byte[] asBytes = Base64.getDecoder().decode("cGhvZW5peA==");
//			System.out.println(new String(asBytes, "utf-8")); // And the output is: some string
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
/**
 * Test
 * $2a$10$Ef4INPeVBp4LiHBvd4P9qu.hGc3Ji/EKwZLO3uuZgNFMwTzfyjNlm : password
 * $2a$10$dadOYjKGyEk0t3iTCF731OtTfllCpq7agJxaEl.6Zlx3BFraQhnaC : userName
 */
}
