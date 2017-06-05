package com.jxwanghao.rookie.commons.spring;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * 用来解密配置中的密文(重点配置，在这里扩展用户名的解密)
 * setUsername(name) 方法对应xml中的一个property属性，password默认加密不需要重写，
 * 还可以加密url 重写setUrl(url) <br>
 * <code>
	public static void main(String[] args) throws Exception {
		String[] genKeyPair = ConfigTools.genKeyPair(512);
		String privateKey = genKeyPair[0];
		String publicKey = genKeyPair[1];
		System.out.println(privateKey);
		System.out.println(publicKey);
		// 原用户名
		String username = "root";
		// 加密后的用户名(放到配置文件中)
		String username_encrypt = ConfigTools.encrypt(privateKey, username);
		// 解密后的用户名(由DecryptDruidSource解析后设置到DruidDataSource)
		String username_decrypt = ConfigTools.decrypt(publicKey, username_encrypt);
		System.out.println(username);
		System.out.println(username_encrypt);
		System.out.println(username_decrypt);
	}
 * </code>
 * 
 * @author jxwanghao
 * @date 2016-08-10 11:38:31
 * @since v1.0.0
 */
@SuppressWarnings("all")
public class DecryptDruidSource extends DruidDataSource {

	private String publicKey;

	@Override
	public void setUsername(String username) {
		try {
			username = ConfigTools.decrypt(publicKey, username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.setUsername(username);
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public static void main(String[] args) throws Exception {
		String[] genKeyPair = ConfigTools.genKeyPair(512);
		String privateKey = genKeyPair[0];
		String publicKey = genKeyPair[1];

		privateKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAzB/0R7R0l96c4TwE/llvf8QL4TRx6s7K0QkVW1Gelnexd07ROTOG0myW3Ut/qGGWloR7HsudMJbTTwprVdfOwQIDAQABAkAPKkyWyzRiWBqlrTTdxL1A68rKJ4BTJpvw3dDlYPH8UbQ3SW9ZL2Lj6/o9X4Cb8n0zzMXf4n0krqzh4XXecJ3xAiEA6UBRCPwJMguZecY7u+4U8LS4nXVEkQOYQU+nZ7BBLK0CIQDgCG0OL+CPmD93qalKuSM1gjYx21oXoO/6BPEk/Hk45QIgXm3vYJfIkT4o8CfU3wxP5fMEGprzG1I9PZOlzlCI0jECIFRHFy91F1ctgQK1EniHuRUSDO0ohXXKFzzIyyaMy9V5AiA0SOxEYuWOBcf0FCk0lKvW50y/K9K8oG39KB0f9Z8Utg==";
		publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMwf9Ee0dJfenOE8BP5Zb3/EC+E0cerOytEJFVtRnpZ3sXdO0TkzhtJslt1Lf6hhlpaEex7LnTCW008Ka1XXzsECAwEAAQ==";

		System.out.println("privateKey: " + privateKey);
		System.out.println("publicKey : " + publicKey);

		String username = "yjsdata";
		String password = "a123456";
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("username encrypt with privateKey: " + ConfigTools.encrypt(privateKey, username));
		System.out.println("password encrypt with privateKey: " + ConfigTools.encrypt(privateKey, password));

	}
}