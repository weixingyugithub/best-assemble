<%@ page language="java" pageEncoding="utf-8"%>

<html> 
	<head>
		<title>JSP for NewsForm form</title>
	</head>
	<body>
		共${page.totalRecords }条${page.pageCount }页
		当前第<input type="text" style="width: 24px;" id="pageNo" name="pageNo" value="${page.pageNo }">页
		每页<input type="text" style="width: 24px;" id="length" name="length" value="${page.length }">条
		<input type="button" value="确定" onclick="jump();">
		<a href="javascript:;" onclick="goPage(1)">首页</a>
		<a href="javascript:;" onclick="goPage(2)">上一页</a>
		<a href="javascript:;" onclick="goPage(3)">下一页</a>
		<a href="javascript:;" onclick="goPage(4)">末页</a>
	</body>
	<script>
	function jump()
	{
		document.forms[0].submit();
	}
	function goPage(type)
	{
		if (type==1)
		{
			document.getElementById("pageNo").value=1;
			document.forms[0].submit();
		}
		if (type==2)
		{
			if (document.getElementById("pageNo").value >= 2)
			{
				document.getElementById("pageNo").value=parseInt(document.getElementById("pageNo").value)-1;
			}
			else
			{
				alert("已是第一页");
				return false;
			}
			document.forms[0].submit();
		}
		
		if (type==3)
		{
			if (document.getElementById("pageNo").value < ${page.pageCount})
			{
				document.getElementById("pageNo").value=parseInt(document.getElementById("pageNo").value)+1;
			}
			else
			{
				alert("已是末页");
				return false;
			}
			document.forms[0].submit();
		}

		if (type==4)
		{
			document.getElementById("pageNo").value=${page.pageCount};
			document.forms[0].submit();
		}
	}
	</script>
</html>

