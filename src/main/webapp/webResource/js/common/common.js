/**
 * @author com.beijing.wei@live.com
 * @version 1.0
 * @desc 常用的通用方法
 */
var win = {};
win.nav = "";//浏览器版本
/**
 * iframe操作 父亲获取儿子对像
 */
function parentGetSon(parentName) {
	return $(window.frames[parentName].document);
}

/**
 * iframe操作 儿子获取父亲对像
 */

function sonGetParent() {
	return $(parent.document);
}

if (window.navigator.userAgent.indexOf("MSIE")>=1) { 
	win.nav = "IE";
} 
//firefox 
else if(window.navigator.userAgent.indexOf("Firefox")>=1) { 
	win.nav = "Firefox";
} 
//chrome
else if(window.navigator.userAgent.indexOf("Chrome") !== -1){
	win.nav = "Chrome";
}
//Safari
else if(window.navigator.userAgent.indexOf("Safari") !== -1){
	win.nav = "Safari";
}
//Opera
else if(window.navigator.userAgent.indexOf("Opera") !== -1){
	win.nav = "Opera";
}

var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
/**
 * 判断是否满足上传需要
 * 
 * @例如：<input type="file" name="contractFileName" style="width: 500px;"
 *      onchange="fileChange(this);" />
 */
function fileChange(target, id) {
	var fileSize = 0;
	var filetypes = [ ".jpg", ".png", ".rar", ".txt", ".zip", ".doc", ".ppt",
			".xls", ".pdf", ".docx", ".xlsx" ];
	var filepath = target.value;
	var filemaxsize = 1024 * 400; // 400M
	if (filepath) {
		var isnext = false;
		var fileend = filepath.substring(filepath.indexOf("."));
		if (filetypes && filetypes.length > 0) {
			for (var i = 0; i < filetypes.length; i++) {
				if (filetypes[i] == fileend) {
					isnext = true;
					break;
				}
			}
		}
		if (!isnext) {
			alert("不接受此文件类型！");
			target.value = "";
			return false;
		}
	} else {
		return false;
	}
	if (isIE && !target.files) {
		var filePath = target.value;
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
		if (!fileSystem.FileExists(filePath)) {
			alert("附件不存在，请重新输入！");
			return false;
		}
		var file = fileSystem.GetFile(filePath);
		fileSize = file.Size;
	} else {
		fileSize = target.files[0].size;
	}

	var size = fileSize / 1024;
	if (size > filemaxsize) {
		alert("附件大小不能大于" + filemaxsize / 1024 + "M！");
		target.value = "";
		return false;
	}
	if (size <= 0) {
		alert("附件大小不能为0M！");
		target.value = "";
		return false;
	}
}

/**
 * <p>
 * 对Date的扩展，将 Date 转化为指定格式的String 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * </p>
 * 
 * @param fmt
 *            数据格式 例：(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02
 *            08:09:04.423 (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2
 *            8:9:4.18
 * @author com.beijing.wei@live.com
 */
Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}

/**
 * <p>
 * 		object转字符串
 * </p>
 * @date 2015-04-30
 */
var Obj2String = function(O) {
	// return JSON.stringify(jsonobj);

	var S = [];
	var J = "";
	if (Object.prototype.toString.apply(O) === '[object Array]') {
		for (var i = 0; i < O.length; i++)
			S.push(O2String(O[i]));
		J = '[' + S.join(',') + ']';
	} else if (Object.prototype.toString.apply(O) === '[object Date]') {
		J = "new Date(" + O.getTime() + ")";
	} else if (Object.prototype.toString.apply(O) === '[object RegExp]'
			|| Object.prototype.toString.apply(O) === '[object Function]') {
		J = O.toString();
	} else if (Object.prototype.toString.apply(O) === '[object Object]') {
		for ( var i in O) {
			O[i] = typeof (O[i]) == 'string' ? '"' + O[i] + '"'
					: (typeof (O[i]) === 'object' ? O2String(O[i]) : O[i]);
			S.push(i + ':' + O[i]);
		}
		J = '{' + S.join(',') + '}';
	}

	return J;
};