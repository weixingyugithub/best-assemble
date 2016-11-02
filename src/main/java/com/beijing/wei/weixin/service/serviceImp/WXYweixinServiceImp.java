package com.beijing.wei.weixin.service.serviceImp;

import org.springframework.stereotype.Service;

import com.beijing.wei.util.file.Dom4jUtil;
import com.beijing.wei.weixin.service.WXYweixinService;
import com.beijing.wei.weixin.weixingyu.EntityWeiXin;

@Service
public class WXYweixinServiceImp implements WXYweixinService{

	@Override
	public String checkEntityToString(EntityWeiXin entity) {
		Dom4jUtil<EntityWeiXin> dom4j = new Dom4jUtil<EntityWeiXin>();
		String xml = dom4j.writeWeiXinBeanToXmlDocument(entity, "UTF-8");
		return xml;
	}
	
}
