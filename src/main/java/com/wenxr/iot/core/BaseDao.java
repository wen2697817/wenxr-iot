package com.wenxr.iot.core;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wenxr.iot.util.Tools;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;持久层基类
 * </p>
 * 
 * 创建日期 2016-5-24
 * 
 * @author wxr
 * @version 1.0
 *    
 */
public abstract class BaseDao extends HibernateDaoSupport {
	/**
	 * 日志记录
	 */
	protected Log log = LogFactory.getLog(getClass());

	/**
	 * 保存一个持久对象
	 * 
	 * @param obj
	 */
	protected void addObject(Object obj) {
		this.getHibernateTemplate().save(obj);
	}

	/**
	 * 删除一个持久对象
	 * 
	 * @param obj
	 */
	protected void delObject(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}

	/**
	 * 删除一个持久对象，要先根据根据类型和ID查出该对象
	 * 
	 * @param clazz
	 * @param id
	 */
	protected void delObject(Class<?> clazz, Serializable id) {
		this.getHibernateTemplate().delete(this.getObject(clazz, id));
	}

	/**
	 * 更新一个持久对象
	 * 
	 * @param obj
	 */
	protected void updateObject(Object obj) {
		this.getHibernateTemplate().update(obj);
	}

	/**
	 * 根据类型和主键查找一个持久对象
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	protected <E> E getObject(Class<E> entityClass, Serializable id) {
		return (E) this.getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 根据类型或hql语句查询出所有持久对象的集合
	 * 
	 * @param entityClass
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <E> List<E> getObjects(Class<E> entityClass, String hql) {
		if (hql == null || "".equals(hql)) {
			return getHibernateTemplate().find("From " + entityClass.getName());
		}
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 根据hql语句查询出持久对象集合
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <E> List<E> getObjects(String hql) {
		return (List<E>) getHibernateTemplate().find(hql);
	}

	/**
	 * 根据hql语句和参数查询出持久对象集合
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <E> List<E> getObjects(String hql, Object[] params) {
		return (List<E>) getHibernateTemplate().find(hql, params);
	}

	/**
	 * 执行JDBC更新、删除等，此方法用来处理大数据量，用hibernate API处理时效率很低
	 * 
	 * @param sql
	 * @param param
	 */
	@SuppressWarnings("deprecation")
	protected void executeJDBCSql(String sql, Object[] param) {
		try {
			Connection con = this.getSession().connection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			if (param != null) {
				int i = 1;
				for (Object obj : param) {
					pstmt.setObject(i++, obj);
				}
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 执行JDBC更新、删除等，此方法用来处理大数据量，用hibernate API处理时效率很低
	 * 
	 * @param sql
	 */
	protected void executeJDBCSql(String sql) {
		this.executeJDBCSql(sql, null);
	}

	/**
	 * 根据SQL语句返回查询结果
	 * 
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("deprecation")
	protected List<?> queryBySql(String sql) {
		return this.getSession().createSQLQuery("select * from (" + sql + ") as temptable").list();
	}

	/**
	 * 根据sql语句和参数做查询，使用泛型，注意一定给出查询字段明和as别名，否则key无法找到
	 * 
	 * @param <E>
	 * @param sql
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	protected <E> List<Map<String, E>> queryBySqlMap(String sql) {
		SQLQuery q = this.getSession().createSQLQuery("select * from (" + sql + ") as temptable");
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return q.list();
	}

	/**
	 * 根据hql语句和参数做查询，使用泛型，注意一定给出查询字段明和as别名，否则key无法找到
	 * 
	 * @param <E>
	 * @param hql
	 * @param values
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <E> List<Map<String, E>> findByNativeQueryMap(final String hql, final Object[] values) {
		List<Map<String, E>> list = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (null != values) {
					for (int i = 0; i < values.length; i++) {
						query.setParameter(i, values[i]);
					}
				}
				List result = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * 根据hql语句和参数做查询，使用泛型，注意一定给出查询字段明和as别名，否则key无法找到
	 * 
	 * @param <E>
	 * @param hql
	 * @param value
	 * @return
	 */
	protected <E> List<Map<String, E>> findByNativeQueryMap(final String hql, final Object value) {
		return this.findByNativeQueryMap(hql, new Object[] { value });
	}

	/**
	 * 根据hql语句做查询，使用泛型，注意一定给出查询字段明和as别名，否则key无法找到
	 * 
	 * @param <E>
	 * @param hql
	 * @return
	 */
	protected <E> List<Map<String, E>> findByNativeQueryMap(final String hql) {
		return this.findByNativeQueryMap(hql, (Object[]) null);
	}

	/**
	 * 根据start和limit的信息查询持久对象的集合
	 * 
	 * @param clazz
	 * @param hql
	 * @param page
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <E> List<E> getObjectsByPage(final String hql, final int start, final int limit) {
		List<E> list = this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(start);
				query.setMaxResults(limit);
				return query.list();
			}
		});
		return list;
	}

	/**
	 * 根据当前页面对象pageVO的信息（如分页、查询条件等）和类型或hql查询持久对象的集合
	 * 
	 * @param clazz
	 * @param hql
	 * @param page
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <E> List<E> getObjectsByPage(String hql, final PageValueObject page) {
		if (page == null) {
			return this.getObjects(hql);
		}
		// 组装where语句
		String where = "";
		for (int i = 0; page.getCondition() != null && i < page.getCondition().length; i++) {
			if (Tools.isEmpty(page.getCondition()[i]) || Tools.isEmpty(page.getKeyWord()[i])) {
				continue;
			}
			where += where.equals("") ? "" : (" " + page.getRelation()[i - 1] + " ");
			where += page.getCondition()[i] + " like ";
			where += "'%" + filterKeyWords(page.getKeyWord()[i]) + "%'";
		}
		int w = hql.lastIndexOf("where");
		if (!Tools.isEmpty(where)) {
			where = "(" + where + ")";
			if (w <= 0) {// 表示此hql语句没有where条件,此时需要将放到最后
				// 判断是否有order by,子查询中不会有order by
				if (hql.lastIndexOf("order by") > 0) { // 有order by
					String[] p = Tools.split(hql, "order by");
					hql = p[0] + " where " + where + " order by " + p[1];
				} else { // 无order by
					hql = hql + " where " + where;
				}
			} else {// 此hql有where条件
				if (hql.lastIndexOf("order by") > 0) { // 有order by
					String[] p = Tools.split(hql, "order by");
					hql = p[0] + " and " + where + " order by " + p[1];
				} else { // 无order by
					hql = hql + " and " + where;
				}
			}
		}

		String cHql = hql.trim();
		cHql = cHql.substring(cHql.toLowerCase().lastIndexOf("from"));
		cHql = "Select count(*) " + cHql;
		cHql = cHql.toLowerCase().lastIndexOf("order by") > 0 ? cHql.substring(0, cHql.toLowerCase().lastIndexOf("order by")) : cHql;
		cHql = cHql.toLowerCase().lastIndexOf("group by") > 0 ? cHql.substring(0, cHql.toLowerCase().lastIndexOf("group by")) : cHql;

		List<E> list = this.getObjects(cHql);
		int allSize = ((Number) list.get(0)).intValue();
		page.setTotal(allSize);

		final String fhql = hql;
		list = this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(fhql);
				query.setFirstResult(page.getStart());
				query.setMaxResults(page.getLimit());
				return query.list();
			}
		});
		return list;
	}

	/**
	 * 过滤用户输入的查询条件中的特殊字符
	 * 
	 * @param str
	 * @return
	 */
	private String filterKeyWords(String str) {
		if (Tools.isEmpty(str)) {
			return "";
		}
		// #
		// 过滤数据库的关键字，本处用在页面查询中，对用户输入的查询关键字是否有关键字字符进行转换字符，如'要转换成''(oracle中要使用关键字要在关键字前加')
		// # 格式为：要过滤的字符 + 逗号 + 要转换的字符 + 分号（若后面还有关键字）
		String filter = "',''";
		String[] keyWords = Tools.split(filter, ";");
		for (int i = 0; i < keyWords.length; i++) {
			if (Tools.isEmpty(keyWords[i])) {
				continue;
			}
			String[] keys = Tools.split(keyWords[i], ",");
			str = Tools.replaceAll(str, keys[0], keys[1]);
		}
		return str;
	}

	/**
	 * evict
	 * 
	 * @param obj
	 */
	protected void evict(Object obj) {
		this.getHibernateTemplate().evict(obj);
	}

	/**
	 * flush
	 */
	protected void flush() {
		this.getHibernateTemplate().flush();
	}
}
