import java.text.DecimalFormat;

public class CalcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("######0.0000");
		System.out.println((double)(145135276)/(double)(123364998));
		double a = Math.pow(((double)(145135279)/(double)(123364988)), 1)-1;
		System.out.println(df.format(a));
		//公式=（北京2015年12月MAT的销售总额/北京2014年12月MAT的销售总额）^(1/（2015-2014)） - 1
	}

}
