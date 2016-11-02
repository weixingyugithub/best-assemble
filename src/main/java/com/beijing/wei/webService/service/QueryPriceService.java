package com.beijing.wei.webService.service;

import javax.jws.WebService;

@WebService
public interface QueryPriceService {
	/**
	 * <p>航班查询接口</p>
	 * Parma 的格式如下(Json)：
	 *	{
	 *	"EncodeMsg" : "adfadfadfadfad",
	 *	"SignMsg" : "adfadfadfadfa"
	 *	}
	 */
	public String Query(String param);
	
	
}
