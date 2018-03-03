package com.huan.springsecurity.social.qq;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * QQ的用户信息
 * 
 * @描述
 * @作者 huan
 * @时间 2018年3月3日 - 下午5:54:30
 */
@Data
public class QQUserInfo {
	private int ret;
	private String msg;
	private int isLost;
	private String nickname;
	private String gender;
	private String province;
	private String city;
	private String year;
	private String figureurl;
	private String figureurl_1;
	private String figureurl_2;
	private String figureurl_qq_1;
	private String figureurl_qq_2;
	@SerializedName(value = "is_yellow_vip")
	private String isYellowVip;
	private String vip;
	@SerializedName(value = "yellow_vip_level")
	private String yellowVipLevel;
	private String level;
	@SerializedName(value = "is_yellow_year_vip")
	private String isYellowYearVip;
}
