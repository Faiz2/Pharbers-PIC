import java.util.ArrayList;
import java.util.List;

import pha.com.common.util.RunDate;
import pha.com.common.util.excel.ReadExcel2007;

public class TestExcelRead {

	public static void main(String[] args) {
		long b = RunDate.startDate();
		String path = "C:\\Users\\Faiz\\Desktop\\导入数据\\final_delivery_2015-2016.xlsx";
		String[] title = new String[]{"城市","最小产品单位（标准_中文）","Date","Value（金额）","年","月","通用名（标准_中文）","商品名（标准_中文）","生产厂家（标准_中文）","剂型（标准_中文）","药品规格（标准_中文）","包装数量（标准_中文）","企业类型","区域","省份","城市级别","Price","unit"};
		String[] fieldNames = new String[]{"city","minunitch","Date","value","year","month","tym","spm","sccj","jx","ypgg","bzsl","qylx","qy","province","citytiger","price","unit"};
		ReadExcel2007 excel2007 = new ReadExcel2007(path);//读取2007
		List<TestExcelClasses> list = new ArrayList<TestExcelClasses>();
		list = excel2007.readExcel(excel2007, TestExcelClasses.class, 1, false, false, fieldNames, title);
		/*for (TestExcelClasses testExcelClasses : list) {
			System.out.println(testExcelClasses.getQy());
		}*/
		System.out.println(list.size());
		RunDate.endDate("用时：", b);
	}
}

