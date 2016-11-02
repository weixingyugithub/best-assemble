package com.beijing.wei.weixin.weixingyu;

public class EntityWeiXin {
	
	private String 	FromUserName;// 消息发送方
	private String  ToUserName;// 消息接收方
	private String  CreateTime;// 消息创建时间
	private String  MsgType;// 消息类型，文本消息必须填写text
	private String  Content;// 消息内容，大小限制在2048字节，字段为空为不合法请求
	private String  FuncFlag;// 星标字段 
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getFuncFlag() {
		return FuncFlag;
	}
	public void setFuncFlag(String funcFlag) {
		FuncFlag = funcFlag;
	}

	
}
