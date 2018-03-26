package com.example.redpacket;

import java.io.Serializable;

/**
 * @author Franer
 * @description: 抢红包实体
 */
public class RedPacket implements Serializable {
	
	private static final long serialVersionUID = 6931417529495627781L;
	
	private int HBActivityID;
	private String Name1;
	private String Name2;
	private String ShareTitle;
	private String ShareContents;
	private String MinScore;
	private String MaxScore;
	private String Score;
	private String BeginDate;
	private String EndDate;
	private String CreateTime;
	
	public int getHBActivityID() {
		return HBActivityID;
	}
	
	public String getTitle(){
		return Name1;
	}
	
	public String getName1() {
		return Name1;
	}
	
	public String getSubTitle(){
		return Name2;
	}
	
	public String getName2() {
		return Name2;
	}
	
	public String getShareTitle() {
		return ShareTitle;
	}
	
	public String getShareContents() {
		return ShareContents;
	}
	
	public String getMinScore() {
		return MinScore;
	}
	
	public String getMaxScore() {
		return MaxScore;
	}
	
	public String getScore() {
		return Score;
	}
	
	public String getBeginDate() {
		return BeginDate;
	}
	
	public String getEndDate() {
		return EndDate;
	}
	
	public String getCreateTime() {
		return CreateTime;
	}
	
	public void setHBActivityID(int hBActivityID) {
		HBActivityID = hBActivityID;
	}
	
	public void setName1(String name1) {
		Name1 = name1;
	}
	
	public void setName2(String name2) {
		Name2 = name2;
	}
	
	public void setShareTitle(String shareTitle) {
		ShareTitle = shareTitle;
	}
	
	public void setShareContents(String shareContents) {
		ShareContents = shareContents;
	}
	
	public void setMinScore(String minScore) {
		MinScore = minScore;
	}
	
	public void setMaxScore(String maxScore) {
		MaxScore = maxScore;
	}
	
	public void setScore(String score) {
		Score = score;
	}
	
	public void setBeginDate(String beginDate) {
		BeginDate = beginDate;
	}
	
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	
	//{"HBActivityID":1,"Name1":"飞芒过年连续九天送大礼",
	//"Name2":"100万积分随机送","ShareTitle":"拉丁谚语：提防那些只念一本书的人。",
	//"ShareContents":"飞芒新年送大礼，9天积分送不停，100万积分随机送，海量图书等你来拿。",
	//"MinScore":150,"MaxScore":300,"Score":245,
	//"BeginDate":"2017-01-05T00:00:00","EndDate":"2017-01-15T00:00:00","CreateTime":"2017-01-03T11:46:06.697"}
	public static RedPacket getInstance() {
		RedPacket rp = new RedPacket();
		rp.setHBActivityID(1);
		rp.setName1("过年连续九天送大礼");
		rp.setName2("100万积分随机送");
		rp.setShareTitle("拉丁谚语：提防那些只念一本书的人。");
		rp.setShareContents("新年送大礼，9天积分送不停，100万积分随机送，海量图书等你来拿。");
		rp.setMinScore("150");
		rp.setMaxScore("300");
		String score = String.valueOf((int)(Math.random()*500));
		rp.setScore(score);
		return rp;
	}
}