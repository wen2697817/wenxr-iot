package com.wenxr.iot.core;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 通用dao
 * 
 * @author wxr
 * 
 */
public class CommonDao extends BaseDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(Object obj) {
		super.addObject(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#getObject(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public <E> E getObject(Class<E> clazz, Serializable id) {
		return super.getObject(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#updateObject(java.lang.Object)
	 */
	@Override
	public void updateObject(Object obj) {
		super.updateObject(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#delObject(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public void delObject(Class<?> clazz, Serializable id) {
		super.delObject(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#delObject(java.lang.Object)
	 */
	@Override
	public void delObject(Object obj) {
		super.delObject(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#findObjects(java.lang.String, java.lang.Object[])
	 */
	@Override
	public <E> List<E> getObjects(String hql, Object[] params) {
		return super.getObjects(hql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#findObjects(java.lang.String)
	 */
	@Override
	public <E> List<E> getObjects(String hql) {
		return super.getObjects(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#getObjects(java.lang.Class, java.lang.String)
	 */
	@Override
	public <E> List<E> getObjects(Class<E> clazz, String hql) {
		return super.getObjects(clazz, hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wenxr.iot.core.BaseDao#getObjectsByPage(java.lang.String, int, int)
	 */
	@Override
	public <E> List<E> getObjectsByPage(String hql, int start, int limit) {
		return super.getObjectsByPage(hql, start, limit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#getObjectsByPage(java.lang.String, com.ad.core.PageValueObject)
	 */
	@Override
	public <E> List<E> getObjectsByPage(String hql, PageValueObject page) {
		return super.getObjectsByPage(hql, page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#executeJDBCSql(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void executeJDBCSql(String sql, Object[] param) {
		super.executeJDBCSql(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#executeJDBCSql(java.lang.String)
	 */
	@Override
	public void executeJDBCSql(String sql) {
		super.executeJDBCSql(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#queryBySql(java.lang.String)
	 */
	@Override
	public List<?> queryBySql(String sql) {
		return super.queryBySql(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#queryBySqlMap(java.lang.String)
	 */
	public <E> List<Map<String, E>> queryBySqlMap(String sql) {
		return super.queryBySqlMap(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#findByNativeQueryMap(java.lang.String, java.lang.Object[])
	 */
	public <E> List<Map<String, E>> findByNativeQueryMap(final String hql, final Object[] values) {
		return super.findByNativeQueryMap(hql, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#findByNativeQueryMap(java.lang.String, java.lang.Object)
	 */
	public <E> List<Map<String, E>> findByNativeQueryMap(final String hql, final Object value) {
		return super.findByNativeQueryMap(hql, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ad.core.BaseDao#findByNativeQueryMap(java.lang.String)
	 */
	public <E> List<Map<String, E>> findByNativeQueryMap(final String hql) {
		return super.findByNativeQueryMap(hql);
	}

	/**
	 * 执行JDBC查询
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public ResultSet sqlNormalQuery(String sql) throws SQLException {
		Connection con = this.getSession().connection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wenxr.iot.core.BaseDao#evict(java.lang.Object)
	 */
	@Override
	public void evict(Object obj) {
		super.evict(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wenxr.iot.core.BaseDao#flush()
	 */
	@Override
	public void flush() {
		super.flush();
	}

}
