package com.beijing.wei.weixin.service;

import com.beijing.wei.weixin.weixingyu.EntityWeiXin;

public interface WXYweixinService {
	
	/**
	 * <p>将数据转化为xml</p>
	 * @param cla
	 * @param obj
	 * @return
	 */
	public String checkEntityToString(EntityWeiXin entity);
}
