package com.wenxr.iot.core;

import com.wenxr.iot.util.Globals;

public class PageValueObject {
	/**
	 * 搜索器条件
	 */
	private String[] condition = null;

	/**
	 * 搜索器条件的类型
	 */
	private String conditionType = null;

	/**
	 * 搜索器关键字
	 */
	private String[] keyWord = null;

	/**
	 * 搜索器关系
	 */
	private String[] relation = null;

	/**
	 * start
	 */
	private int start = 0;

	/**
	 * limit
	 */
	private int limit = Integer.parseInt(Globals.getProp("PAGE_LIST_SIZE"));

	/**
	 * 总数据
	 */
	private int total = 0;

	/**
	 * @return the condition
	 */
	public String[] getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String[] condition) {
		this.condition = condition;
	}

	/**
	 * @return the keyWord
	 */
	public String[] getKeyWord() {
		return keyWord;
	}

	/**
	 * @param keyWord
	 *            the keyWord to set
	 */
	public void setKeyWord(String[] keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * @return the relation
	 */
	public String[] getRelation() {
		return relation;
	}

	/**
	 * @param relation
	 *            the relation to set
	 */
	public void setRelation(String[] relation) {
		this.relation = relation;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the conditionType
	 */
	public String getConditionType() {
		return conditionType;
	}

	/**
	 * @param conditionType
	 *            the conditionType to set
	 */
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

}
