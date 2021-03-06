package pha.com.common.base.service;

import java.util.List;
import java.util.Map;

import pha.com.common.base.dao.BaseDao;
import pha.com.common.base.model.BaseModel;
import pha.com.common.base.page.Page;


/**
 * <h2>通用业务接口</h2>
 * <p>本接口为通用架构的一部分，Service层通用接口。通用架构设计之初的使用的以下方面的技术：</p>
 * <ul>
 * <li>MVC框架：Struts2</li>
 * <li>IOC和AOP框架：Spring3</li>
 * <li>ORM框架：MyBatis3.1</li>
 * <li>数据库：Oracle 11g r2</li>
 * </ul>
 * <p>本接口使用了泛型，使用了通用架构的其它部分：Dao层通用接口{@link dream.keel.BaseDao BaseDao}和Module层通用类{@link dream.keel.BaseModel BaseModel}。并有默认的实现{@link dream.keel.BaseServiceImpl BaseServiceImpl}，可直接继承使用。</p>
 * <p>本接口的方法包含常见的对数据库执行简单操作的业务方法。涉及到普通的增、删、改、查，以及复杂查询（条件、分页、级联、外键关联）。</p>
 * @author 武利庆
 * @version 1.2，时间：2013-10-25 10：55，修订者：武利庆，内容：由于创建之初失误，个别方法参数和返回类型不符合设计的通用规则。
 * @version 1.1，时间：2013-10-21 10：55，修订者：武利庆，内容：由于业务或框架使用了反射无法获取多态方法，所以取消了多态方法，使用各自的名称。
 * @version 1.0，时间：2013-10-18 10：55，修订者：武利庆，内容：创建接口。
 * @param <T> 泛型实现，Module层通用类
 * @see dream.keel.BaseServiceImpl
 * @see dream.keel.BaseDao
 * @see dream.keel.BaseModel
 */

public interface BaseService<T extends BaseModel<?>> {
	/**
	 * 获取其业务相关数据库操作对象。
	 * @return 数据库操作对象
	 */
	public BaseDao<T> getBaseDao();

	/**
	 * 设置其业务相关数据库操作对象。
	 * @param baseDao 数据库操作对象
	 */
	public void setBaseDao(BaseDao<T> baseDao);
	
	/* ===================== *
	 * 增加数据和修改数据的相关方法。
	 * ===================== */

	/**
	 * <h3>普通数据处理：保存一个数据。</h3>
	 * <p>功能约定为将其所有的属性值保存到数据库，当数据的主键ID不为NULL或为0时执行插入数据库，否则依照ID更新的数据库。
	 * 最终功能视具体的实现而定。</p>
	 * @param record 一个数据
	 * @return 成功次数
	 */
	public int saveOne(T record);

	/**
	 * <h3>普通数据处理：保存一个数据。</h3>
	 * <p>功能约定为将其所有不为NULL的属性值保存到数据库，当数据的主键ID不为NULL或为0时执行插入数据库，否则依照ID更新的数据库。
	 * 最终功能视具体的实现而定。</p>
	 * @param record
	 * @return 成功次数
	 */
	public int saveOneSelective(T record);

	/**
	 * <h3>普通数据处理：保存多个数据。</h3>
	 * <p>功能约定为将其所有的属性值保存到数据库，当数据的主键ID不为NULL或为0时执行插入数据库，否则依照ID更新的数据库。
	 * 最终功能视具体的实现而定。</p>
	 * @param record 多个数据集合
	 * @return 成功次数
	 */
	public int saveList(List<T> record);

	/**
	 * <h3>普通数据处理：保存多个数据。</h3>
	 * <p>功能约定为将其所有不为NULL的属性值保存到数据库，当数据的主键ID不为NULL或为0时执行插入数据库，否则依照ID更新的数据库。
	 * 最终功能视具体的实现而定。</p>
	 * @param record 多个数据集合
	 * @return 成功次数
	 */
	public int saveListSelective(List<T> record);
	
	/* ===================== *
	 * 删除数据的相关方法。
	 * ===================== */
	
	/**
	 * <h3>普通数据处理：删除一个数据。</h3>
	 * <p>功能约定为根据数据的主键ID从数据表中删除。最终功能视具体的实现而定。</p>
	 * @param id 数据的主键ID
	 * @return 成功次数
	 */
	public int deleteOneByID(Object id);
	
	/**
	 * <h3>普通数据处理：删除多个数据。</h3>
	 * <p>功能约定为根据数据的主键ID从数据表中删除。最终功能视具体的实现而定。</p>
	 * @param array 多个数据的主键ID
	 * @return 成功次数
	 */
	public int deleteArrayByID(Object[] array);
	
	/**
	 * <h3>普通数据处理：删除多个数据。</h3>
	 * <p>功能约定为根据数据的主键ID从数据表中删除。最终功能视具体的实现而定。</p>
	 * @param list 多个数据
	 * @return 成功次数
	 */
	public int deleteListByID(List<T> list);

	/* ===================== *
	 * 查询数据的相关方法。
	 * ===================== */

	/**
	 * <h3>普通数据处理：查询一个数据。</h3>
	 * <p>功能约定为根据数据的主键ID从数据表中查询单个数据。最终功能视具体的实现而定。</p>
	 * @param id 数据的主键ID
	 * @return 单个数据
	 */
	public T queryByID(Object id);
	/**
	 * <h3>普通数据处理：按条件分页查询多个数据。</h3>
	 * <p>功能约定为根据件条件和分页设置从数据表中按分页查询多个数据。最终功能视具体的实现而定。</p>
	 * @param page 分页数据
	 * @return 分页数据
	 */
	public Page<T> queryByPage(Page<T> page);
	/**
	 * <h3>普通数据处理：按条件查询所有数据。</h3>
	 * <p>功能约定为根据条件设置从数据表中按查询所有数据。最终功能视具体的实现而定。</p>
	 * @param params 条件
	 * @return 数据集合
	 */
	public List<T> queryByParameters(Map<String, Object> params);
	/**
	 * <h3>普通数据处理：查询所有数据。</h3>
	 * <p>功能约定为无条件从数据表中按查询表所有数据。最终功能视具体的实现而定。</p>
	 * @return 数据集合
	 */
	public List<T> queryAll();
	
	/**
	 * <h3>关联多种数据处理：查询一个数据。</h3>
	 * <p>功能约定为根据数据的主键ID从数据表中查询单个数据，包括相关的外键数据。最终功能视具体的实现而定。</p>
	 * @param id 数据的主键ID
	 * @return 单个数据及其外键数据
	 */
	public T queryFullByID(Object id);
	/**
	 * <h3>关联多种数据处理：按条件分页查询多个数据。</h3>
	 * <p>功能约定为根据件条件和分页设置从数据表中按分页查询多个数据，包括相关的外键数据。最终功能视具体的实现而定。</p>
	 * @param page 分页数据
	 * @return 分页数据
	 */
	public Page<T> queryFullByPage(Page<T> page);
	/**
	 * <h3>关联多种数据处理：按条件查询所有数据。</h3>
	 * <p>功能约定为根据条件设置从数据表中按查询所有数据，包括相关的外键数据。最终功能视具体的实现而定。</p>
	 * @param params 条件
	 * @return 数据集合
	 */
	public List<T> queryFullByParameters(Map<String, Object> params);
	/**
	 * <h3>关联多种数据处理：查询所有数据。</h3>
	 * <p>功能约定为无条件从数据表中按查询表所有数据，包括相关的外键数据。最终功能视具体的实现而定。</p>
	 * @return 数据集合
	 */
	public List<T> queryFullAll();

	/**
	 * <h3>向上级联数据处理：查询一个数据。</h3>
	 * <p>功能约定为根据叶子数据的主键ID从级联数据表中查询单个叶子数据，包括其所有父数据。最终功能视具体的实现而定。</p>
	 * @param id 叶子数据的主键ID
	 * @return 叶子数据及其所有父数据
	 */
	public T queryConnectLeafByID(Object id);
	/**
	 * <h3>向上级联数据处理：查询一个数据。</h3>
	 * <p>功能约定为根据叶子数据的主键ID从级联数据表中查询单个叶子数据，包括其所有父数据。最终功能视具体的实现而定。</p>
	 * @param leaf 叶子数据
	 * @return 叶子数据及其所有父数据
	 */
	public T queryConnectLeafByLeaf(T leaf);
	/**
	 * <h3>向上级联数据处理：按条件分页查询多个数据。</h3>
	 * <p>功能约定为根据叶子数据的主键ID从级联数据表中按条件分页查询多个叶子数据，包括其所有父数据。最终功能视具体的实现而定。</p>
	 * @param page 分页数据
	 * @return 分页数据
	 */
	public Page<T> queryConnectLeafByPage(Page<T> page);
	/**
	 * <h3>向上级联数据处理：按条件查询所有数据。</h3>
	 * <p>功能约定为根据叶子数据的主键ID从级联数据表中按条件查询所有叶子数据，包括其所有父数据。最终功能视具体的实现而定。</p>
	 * @param params 条件
	 * @return 叶子数据集合及其所有父数据
	 */
	public List<T> queryConnectLeafByParameters(Map<String, Object> params);
	
	/**
	 * <h3>向下级联数据处理：查询一个数据。</h3>
	 * <p>功能约定为根据根数据的主键ID从级联数据表中查询单个根数据，包括其所有子数据。最终功能视具体的实现而定。</p>
	 * @param id 根数据的主键ID
	 * @return 根数据及其所有子数据
	 */
	public T queryConnectRootByID(Object id);
	/**
	 * <h3>向下级联数据处理：查询一个数据。</h3>
	 * <p>功能约定为根据根数据的主键ID从级联数据表中查询单个根数据，包括其所有子数据。最终功能视具体的实现而定。</p>
	 * @param leaf 根数据
	 * @return 根数据及其所有子数据
	 */
	public T queryConnectRootByRoot(T root);
	/**
	 * <h3>向下级联数据处理：按条件分页查询多个数据。</h3>
	 * <p>功能约定为根据根数据的主键ID从级联数据表中按条件分页查询多个根数据，包括其所有子数据。最终功能视具体的实现而定。</p>
	 * @param page 分页数据
	 * @return 分页数据
	 */
	public Page<T> queryConnectRootByPage(Page<T> page);
	/**
	 * <h3>向下级联数据处理：按条件查询所有数据。</h3>
	 * <p>功能约定为根据根数据的主键ID从级联数据表中按条件查询所有根数据，包括其所有子数据。最终功能视具体的实现而定。</p>
	 * @param params 条件
	 * @return 根数据集合及其所有子数据
	 */
	public List<T> queryConnectRootByParameters(Map<String, Object> params);
	/**
	 * 查询树状数据
	 */
	public List<T> treeAll();
}
