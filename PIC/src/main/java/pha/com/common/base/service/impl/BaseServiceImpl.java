package pha.com.common.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pha.com.common.base.dao.BaseDao;
import pha.com.common.base.model.BaseModel;
import pha.com.common.base.page.Page;
import pha.com.common.base.service.BaseService;


/**
 * <h2>通用业务类</h2>
 * <p>本类为通用架构的一部分，Service层通用接口{@link dream.keel.BaseService BaseService}实现类。</p>
 * @author 武利庆
 * @version 1.3，时间：2013-10-25 10：55，修订者：武利庆，内容：由于创建之初失误，个别方法参数和返回类型不符合设计的通用规则。
 * @version 1.2，时间：2013-10-24 15：55，修订者：陈&nbsp;&nbsp;周，内容：为保存方法的插入数据操作增加条件，使当主键值为0时也可插入数据操作。
 * @version 1.1，时间：2013-10-21 10：55，修订者：武利庆，内容：由于业务或框架使用了反射无法获取多态方法，所以取消了多态方法，使用各自的名称。
 * @version 1.0，时间：2013-10-18 10：55，修订者：武利庆，内容：创建类。
 * @param <T> 泛型实现，Module层通用类
 * @see dream.keel.BaseService
 * @see dream.keel.BaseDao
 * @see dream.keel.BaseModel
 */

@Service
public class BaseServiceImpl<T extends BaseModel<T>> implements BaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int saveOne(T record) {
		int num = 0;
		if (record != null) {
			if (record.getId() == null) {
				num = this.baseDao.insert(record);
			} else {
				num = this.baseDao.updateByID(record);
			}
		}
		return num;
	}

	@Override
	public int saveOneSelective(T record) {
		int num = 0;
		if (record != null) {
			if (record.getId() == null || record.getId() == 0) {
				num = this.baseDao.insertSelective(record);
			} else {
				num = this.baseDao.updateByIDSelective(record);
			}
		}
		return num;
	}

	@Override
	public int saveList(List<T> record) {
		int num = 0;
		if (record != null) {
			List<T> up = new ArrayList<T>();
			for (int i = 0; i < record.size(); i++) {
				T obj = record.get(i);
				if(obj.getId() != null){
					num += this.baseDao.insert(obj);
				} else {
					up.add(obj);
				}
			}
			for (int i = 0; i < up.size(); i++) {
				T obj = up.get(i);
				num += this.baseDao.updateByID(obj);
			}
		}
		return num;
	}

	@Override
	public int saveListSelective(List<T> record) {
		int num = 0;
		if (record != null) {
			List<T> up = new ArrayList<T>();
			for (int i = 0; i < record.size(); i++) {
				T obj = record.get(i);
				if(obj.getId() != null && obj.getId() > 0){
					up.add(obj);
				} else {
					num += this.baseDao.insertSelective(obj);
				}
			}
			
			for (int i = 0; i < up.size(); i++) {
				T obj = up.get(i);
				num += this.baseDao.updateByIDSelective(obj);
			}
		}
		return num;
	}

	@Override
	public int deleteOneByID(Object id) {
		return baseDao.deleteByID(id);
	}

	@Override
	public int deleteArrayByID(Object[] list) {
		int num = 0;
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				num += deleteOneByID(list[i]);
			}
		}
		return num;
	}

	@Override
	public int deleteListByID(List<T> list) {
		int num = 0;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				num += deleteOneByID(list.get(i).getId());
			}
		}
		return num;
	}

	@Override
	public T queryByID(Object id) {
		return baseDao.selectByID(id);
	}

	@Override
	public Page<T> queryByPage(Page<T> page) {
		if (page == null) {
			page = new Page<T>();
		}
		List<T> list = baseDao.selectByParameters(page);
		page.setResult(list);
		return page;
	}

	@Override
	public List<T> queryByParameters(Map<String, Object> params) {
		return baseDao.selectByParameters(params);
	}

	@Override
	public List<T> queryAll() {
		return queryByParameters(null);
	}

	@Override
	public T queryFullByID(Object id) {
		return baseDao.selectFullByID(id);
	}

	@Override
	public Page<T> queryFullByPage(Page<T> page) {
		if (page == null) {
			page = new Page<T>();
		}
		List<T> list = baseDao.selectFullByParameters(page);
		page.setResult(list);
		return page;
	}

	@Override
	public List<T> queryFullByParameters(Map<String, Object> params) {
		return baseDao.selectFullByParameters(params);
	}

	@Override
	public List<T> queryFullAll() {
		return baseDao.selectFullByParameters(null);
	}

	@Override
	public T queryConnectLeafByID(Object id) {
		return baseDao.selectConnectLeafByID(id);
	}

	@Override
	public T queryConnectLeafByLeaf(T leaf) {
		return baseDao.selectConnectLeafByLeaf(leaf);
	}

	@Override
	public Page<T> queryConnectLeafByPage(Page<T> page) {
		if (page == null) {
			page = new Page<T>();
		}
		List<T> list = baseDao.selectConnectLeafByParameters(page);
		page.setResult(list);
		return page;
	}

	@Override
	public List<T> queryConnectLeafByParameters(Map<String, Object> params) {
		return baseDao.selectConnectLeafByParameters(params);
	}

	@Override
	public T queryConnectRootByID(Object id) {
		return baseDao.selectConnectRootByID(id);
	}

	@Override
	public T queryConnectRootByRoot(T root) {
		return baseDao.selectConnectRootByRoot(root.getId());
	}

	@Override
	public Page<T> queryConnectRootByPage(Page<T> page) {
		if (page == null) {
			page = new Page<T>();
		}
		List<T> list = baseDao.selectConnectRootByParameters(page);
		page.setResult(list);
		return page;
	}

	@Override
	public List<T> queryConnectRootByParameters(Map<String, Object> params) {
		Map<Long, T> map = new HashMap<Long, T>();
		List<T> list = new LinkedList<T>();
		List<T> result =  new LinkedList<T>(baseDao.selectConnectRootByParameters(params));
		int size = 0;
		while(result.size() != size && result.size() != 0){
			size = result.size();
			Iterator<T> iterator = result.iterator();
			while(iterator.hasNext()){
				T next = iterator.next();
				map.put(next.getId(), next);
				if (next.getParentId() == null || next.getId() == next.getParentId() || next.getParentId() <= 0) {
					list.add(next);
					iterator.remove();
				} else {
					if (map.containsKey(next.getParentId())) {
						T parent = map.get(next.getParentId());
						if (parent.getChildren() == null) {
							List<T> children = new ArrayList<T>();
							parent.setChildren(children);
						}
						next.setParent(parent);
						parent.getChildren().add(next);
						iterator.remove();
					}
				}
			}
		}
		return list;
	}

	@Override
	public List<T> treeAll() {
		Map<Long, T> map = new HashMap<Long, T>();
		List<T> list = new LinkedList<T>();
		List<T> result =  new LinkedList<T>(this.getBaseDao().selectByParameters(null));
		int size = 0;
		while(result.size() != size && result.size() != 0){
			size = result.size();
			Iterator<T> iterator = result.iterator();
			while(iterator.hasNext()){
				T next = iterator.next();
				map.put(next.getId(), next);
				if (next.getParentId() == null || next.getId() == next.getParentId() || next.getParentId() <= 0) {
					list.add(next);
					iterator.remove();
				} else {
					if (map.containsKey(next.getParentId())) {
						T parent = map.get(next.getParentId());
						if (parent.getChildren() == null) {
							List<T> children = new ArrayList<T>();
							parent.setChildren(children);
						}
						next.setParent(parent);
						parent.getChildren().add(next);
						iterator.remove();
					}
				}
			}
		}
		return list;
	}

}
