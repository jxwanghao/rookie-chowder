package com.jxwanghao.rookie.webapp.common.plugin.pagehelper;


import com.jxwanghao.rookie.framework.utils.JacksonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 对Page<E>结果进行包装
 * <p/>
 * 新增分页的多项属性
 *
 * @author administrator
 * @version 3.3.0
 * @since 3.2.2 项目地址
 */
public class PageInfo<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	// 当前页码
	private int pageNum;
	// 每页的数量
	private int pageSize;
	// 排序
	private String orderBy;
	// 由于startRow和endRow不常用，这里说个具体的用法
	// 可以在页面中"显示startRow到endRow 共size条数据"
	// 当前页面第一个元素在数据库中的行号
	// 该页起始值 pageNo * pageSize - pageSize
	private int beginNum = 0;
	// 该页结束值
	private int endNum = 0;
	// 总记录数
	private long total;
	// 总页数
	private int pages;
	// 结果集
	private List<T> dataList;
	// 数据合计
	private Map<String, ? extends Object> summation;
	// 首页 Home-Page, 是否能点击首页
	private boolean home = false;
	// 上一页 Pre-Page, 是否能点击上一页
	private boolean prev = false;
	// 下一页Next-Page, 是否能点击下一页
	private boolean next = false;
	// 尾页 End-Page, 是否能点击最后一页
	private boolean last = false;

	public PageInfo() {
	}

	/**
	 * 结果集
	 * 
	 * @param list
	 */
	public PageInfo(List<T> list) {
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.total = page.getTotal();
			this.pages = page.getPages();
			this.dataList = page.getResult();
			// 由于结果是>startRow的，所以实际的需要+1
			if (page.size() == 0) {
				this.beginNum = 0;
				this.endNum = 0;
			} else {
				this.beginNum = page.getStartRow() + 1;
				// 计算实际的endRow（最后一页的时候特殊）
				this.endNum = this.beginNum - 1 + page.size();
			}
			refresh(pageNum, pages);
		}
	}

	/**
	 * @param list
	 *        结果集
	 * @param summation
	 *        合计集合
	 */
	public PageInfo(List<T> list, Map<String, ? extends Object> summation) {
		if (list instanceof Page) {
			Page<T> page = Page.valueOf(list);
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.total = page.getTotal();
			this.pages = page.getPages();
			this.dataList = page.getResult();
			this.summation = summation;
			// 由于结果是>startRow的，所以实际的需要+1
			if (page.size() == 0) {
				this.beginNum = 0;
				this.endNum = 0;
			} else {
				this.beginNum = page.getStartRow() + 1;
				// 计算实际的endRow（最后一页的时候特殊）
				this.endNum = this.beginNum - 1 + page.size();
			}
			refresh(pageNum, pages);
		}
	}

	/**
	 * 处理 List<T> 实体对象集合数据
	 * 
	 * @param pageNum
	 *        当前页码
	 * @param pageSize
	 *        每页显示记录数
	 * @param totalRecord
	 *        总记录数
	 * @param dataList
	 *        数据库查询返回的结果集
	 */
	public PageInfo(int pageNum, int pageSize, long totalRecord, List<T> dataList) {
		// 每页起始值, pageNo * pageSize - pageSize
		this.setBeginNum(pageNum * pageSize - pageSize);
		// 总记录数
		this.setTotal(totalRecord);
		// 每页显示记录数
		this.setPageSize(pageSize > 0 ? pageSize : this.getPageSize());
		// 求总页数
		this.setPages((int) Math.ceil(Double.valueOf(totalRecord) / Double.valueOf(pageSize)));
		// 判断页码是否小于1
		pageNum = pageNum <= 0 ? 1 : pageNum;
		// 当前页码
		this.setPageNum(pageNum < this.getPages() ? pageNum : this.getPages());
		// 数据集
		this.setDataList(dataList);
		// 刷新按钮是否可用.
		this.refresh(this.pageNum, this.pages);
	}

	/**
	 * 刷新按钮是否可用.
	 * 
	 * @param pageNo
	 * @param pageTotal
	 */
	private void refresh(int pageNo, long pageTotal) {
		if (pageTotal <= 1L) {
			// 如果数据只有一页,那么所有的翻页按钮都不能是用
			this.setBtnEnable(false, false, false, false);
		} else if (pageNo <= 1) {
			// 如果当前页为第一页
			this.setBtnEnable(false, false, true, true);
		} else if (pageNo > 1 && pageNo < pageTotal) {
			// 如果当前页为 大于第一页 并且小于总页数
			this.setBtnEnable(true, true, true, true);
		} else if (pageNo >= pageTotal) {
			// 如果当前页大于或等于总页数
			this.setBtnEnable(true, true, false, false);
		}
	}

	/**
	 * 设定 按钮的可用性 true:可用, false:不可用
	 * 
	 * @param home
	 *        首页
	 * @param prev
	 *        上一页
	 * @param next
	 *        下一页
	 * @param last
	 *        尾页
	 */
	private void setBtnEnable(boolean home, boolean prev, boolean next, boolean last) {
		this.home = home;
		this.prev = prev;
		this.next = next;
		this.last = last;
	}

	@Override
	public String toString() {
		return JacksonUtil.toJson(this);
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(int beginNum) {
		this.beginNum = beginNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getDataList() {
		return dataList == null ? new ArrayList<T>() : dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public Map<String, ? extends Object> getSummation() {
		return summation;
	}

	public void setSummation(Map<String, ? extends Object> summation) {
		this.summation = summation;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}
}
