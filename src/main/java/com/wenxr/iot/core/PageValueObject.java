package com.wenxr.iot.core;

import com.wenxr.iot.util.Globals;

public class PageValueObject {
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

}
