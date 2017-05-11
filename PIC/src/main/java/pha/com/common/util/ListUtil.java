package pha.com.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListUtil {
	/**
	 * 检测<?>集合是否不为空(null,0)
	 * 
	 * @param s
	 * 			指定<?>集合
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(List<?> list){
		return  list!=null && list.size()>0 && list.get(0)!=null;
	}
	
	/**
	 * 检测<?>集合是否为空(null,0)
	 * 
	 * @param list
	 * 			指定<?>集合
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(List<?> list){
		return list==null || list.size()==0;
	}
	
	/**
	 * 只针对于List<String> 的去重复
	 * @param list
	 * @return
	 */
	public static List<String> removeDuplicate(List<String> list) {
		Set<String> set = new HashSet<String>();
		List<String> newList = new ArrayList<String>();
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			if (set.add(element))
				newList.add(element);
		}
		return newList;
	}
	
	/**
	 * 冒泡排序 从大到小
	 * @param array
	 * @return
	 */
	public static double[] maoPaoSort(double[] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(array[i] < array[j]){
					double temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}
