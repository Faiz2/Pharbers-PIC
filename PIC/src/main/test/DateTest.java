import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pha.com.common.util.DateUtil;

public class DateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String date = DateUtil.format(new Date(), DateUtil.PATTERN_YEAR_MONTH);
		System.out.println(DateUtil.formatDate(date,5));
        String webUrl2 = "http://www.baidu.com";//百度
//        String webUrl3 = "http://www.taobao.com";//淘宝
//        String webUrl4 = "http://www.ntsc.ac.cn";//中国科学院国家授时中心
//        String webUrl5 = "http://www.360.cn";//360
//        String webUrl6 = "http://www.beijing-time.org";//beijing-time
        System.out.println(DateUtil.getWebsiteDatetime(webUrl2) + " [百度]");
//        System.out.println(DateUtil.getWebsiteDatetime(webUrl3) + " [淘宝]");
//        System.out.println(DateUtil.getWebsiteDatetime(webUrl4) + " [中国科学院国家授时中心]");
//        System.out.println(DateUtil.getWebsiteDatetime(webUrl5) + " [360安全卫士]");
//        System.out.println(DateUtil.getWebsiteDatetime(webUrl6) + " [beijing-time]");
	}
}
