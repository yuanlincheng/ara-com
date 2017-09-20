/*
 * 文件名：${PageVO}
 * 作者：${Tree}
 * 版本：
 * 时间：${2014.4.20}
 * 修改：
 * 描述：分页对象  VO类
 *
 *
 * 版权：亚略特
 */
package com.vo;

@SuppressWarnings("unused")
public class PageVO {
	private int pageNum;   //當前的頁碼
    private int start;    //记录开始的
    private int pageSize;   //頁面的大小
    private long maxPage;    //最大頁數
	private int prePage;     //上一頁的頁面
    private int nextPage;    //下一頁的頁碼
    private long totalResult; //记录总条数

    public PageVO() {}

    public PageVO(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageVO(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public int getStart(){
        return start;
    }

	public int getNextPage() {
		return (int) (pageNum + 1 >= getMaxPage() ? getMaxPage() : pageNum + 1);
    }

    public int getPrePage() {
        return pageNum-1<=0?0:pageNum-1;
    }

    public long getMaxPage() {
    	return (int) Math.ceil(((float)getTotalResult())/pageSize);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

	public long getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(long totalResult) {
		this.totalResult = totalResult;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

    public void setStart(int start) {
        this.start = start;
    }
}