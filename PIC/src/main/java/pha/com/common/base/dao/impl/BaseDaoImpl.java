package pha.com.common.base.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import pha.com.common.base.dao.BaseDao;
import pha.com.common.base.model.BaseModel;

/**
 * <h2>通用数据操作类</h2>
 * <p>本类为通用架构的一部分，Dao层通用接口{@link dream.keel.BaseDao BaseDao}实现类。</p>
 * @author 武利庆
 * @version 1.1，时间：2013-11-0 10：55，修订者：武利庆，内容：重写实现。
 * @version 1.0，时间：2013-10-18 10：55，修订者：武利庆，内容：创建类。
 * @param <T> 泛型实现，Module层通用类
 * @see dream.keel.BaseDao
 * @see dream.keel.BaseModel
 */
@Repository
public class BaseDaoImpl<T extends BaseModel<?>> extends SqlSessionDaoSupport implements BaseDao<T> {
	
	protected String mapperNamespace = null;

	public String getMapperNamespace() {
			return this.mapperNamespace;
	}

	public void setMapperNamespace(String mapperNamespace) {
			this.mapperNamespace = mapperNamespace;
	}
	
	public BaseDaoImpl(){
		if(this.mapperNamespace == null){
			mapperNamespace = this.getClass().getName();
		}
	}
	
	@Override
	public void finalize() throws Throwable {
		super.finalize();
		if(this.getSqlSession() != null){
			this.getSqlSession().commit();
			this.getSqlSession().clearCache();
			this.getSqlSession().close();
		}
	}
	
	/* ===================== *
	 * 增加数据的相关方法。
	 * ===================== */
	
	/**
	 * 通用的插入数据方法。
	 * @param sqlId MyBatis的插入SQL语句ID
	 * @param record 含有数据的对象
	 * @return 受影响的行数
	 */
	public int insert(String sqlId, T record) {
		return getSqlSession().insert(sqlId, record);
	}
	
	@Override
	public int insert(T record) {
		return insert(this.mapperNamespace + ".insert",record);
	}

	@Override
	public int insertSelective(T record) {
		return insert(this.mapperNamespace + ".insertSelective",record);
	}
	
	/* ===================== *
	 * 删除数据的相关方法。
	 * ===================== */
	
	/**
	 * 通用的根据主键删除数据方法。
	 * @param sqlId MyBatis的删除SQL语句ID
	 * @param id 主键
	 * @return 受影响的行数
	 */
	public int delete(String sqlId, Object id) {
		return getSqlSession().delete(sqlId, id);
	}
	
	@Override
	public int deleteByID(Object id) {
		return delete(mapperNamespace + ".deleteByID", id);
	}
	
	/* ===================== *
	 * 修改数据的相关方法。
	 * ===================== */
	
	public int update(String sqlId,T record) {
		return getSqlSession().update(sqlId, record);
	}	

	@Override
	public int updateByID(T record) {
		return update(mapperNamespace + ".updateByID", record);
	}

	@Override
	public int updateByIDSelective(T record) {
		return update(mapperNamespace + ".updateByIDSelective", record);
	}

	/* ===================== *
	 * 查询数据的相关方法。
	 * ===================== */

	public T selectOne(String sqlId, Object id) {
		return getSqlSession().selectOne(sqlId, id);
	}
	
	public List<T> selectList(String sqlId, Object params) {
		return getSqlSession().selectList(sqlId, params);
	}

	@Override
	public T selectByID(Object id) {
		return selectOne(this.mapperNamespace + ".selectByID", id);
	}

	@Override
	public List<T> selectByParameters(Object params) {
		return selectList(this.mapperNamespace + ".selectByParameters", params);
	}

	@Override
	public T selectFullByID(Object id) {
		return selectOne(this.mapperNamespace + ".selectFullByID", id);
	}

	@Override
	public List<T> selectFullByParameters(Object params) {
		return selectList(this.mapperNamespace + ".selectFullByParameters", params);
	}

	@Override
	public T selectConnectLeafByID(Object id) {
		return selectOne(this.mapperNamespace + ".selectConnectLeafByID", id);
	}

	@Override
	public T selectConnectLeafByLeaf(Object id) {
		return selectOne(this.mapperNamespace + ".selectConnectLeafByLeaf", id);
	}

	@Override
	public List<T> selectConnectLeafByParameters(Object params) {
		return selectList(this.mapperNamespace + ".selectConnectLeafByParameters", params);
	}

	@Override
	public T selectConnectRootByID(Object id) {
		return selectOne(this.mapperNamespace + ".selectConnectRootByID", id);
	}

	@Override
	public T selectConnectRootByRoot(Object id) {
		return selectOne(this.mapperNamespace + ".selectConnectRootByRoot", id);
	}

	@Override
	public List<T> selectConnectRootByParameters(Object params) {
		return selectList(this.mapperNamespace + ".selectConnectRootByParameters", params);
	}


}
