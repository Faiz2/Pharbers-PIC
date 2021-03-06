package pha.com.common.base.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
* 	<p>Title: Encrypt</p>
* 	<p>Description: 设置密码加密策略</p>
* 	<p>Company: pharbers</p>
* 	@author ylk
* 	@date 2016年7月12日
 */
public class Encrypt {
	/*
	 * 散列算法一般用于生成数据的摘要信息，是一种不可逆的算法，一般适合存储密码之类的数据，
	 * 常见的散列算法如MD5、SHA等。一般进行散列时最好提供一个salt（盐），比如加密密码“admin”，
	 * 产生的散列值是“21232f297a57a5a743894a0e4a801fc3”，
	 * 可以到一些md5解密网站很容易的通过散列值得到密码“admin”，
	 * 即如果直接对密码进行散列相对来说破解更容易，此时我们可以加一些只有系统知道的干扰数据，
	 * 如用户名和ID（即盐）；这样散列的对象是“密码+用户名+ID”，这样生成的散列值相对来说更难破解。
	 */
	
	public static String DEFAULT_PASSWORD = "123456";
	
	public static String md5(String password, String salt){
		return new Md5Hash(password , salt , 2).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Md5Hash("123456","Pharbers",2).toString());
	}

}
