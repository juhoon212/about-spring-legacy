package xyz.itwill10;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptEx {
	
	// 비밀번호 암호화
	String hashPassword = BCrypt.hashpw("efefefef", BCrypt.gensalt());
}
