package pha.com.common.base.util.mail;

import org.apache.log4j.HTMLLayout;

public class MailLayout_seth extends HTMLLayout {
	@Override
	public String getContentType() {
		return "text/html;charset=UTF-8";
	}
}
