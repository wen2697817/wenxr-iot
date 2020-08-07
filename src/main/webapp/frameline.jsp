<%@ page contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/commons/website.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" />
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>
<base href="<%=basePath%>" />
<TITLE>功能菜单</TITLE>
</HEAD>
<script type="text/javascript">
	function ShowHideLeft(objtd) {
		if (parent.window.frames['subMainFrameSet'].cols == "200px,10px,*") {
			parent.window.frames['subMainFrameSet'].cols = "0px,10px,*";
			objtd.innerHTML = '&gt;';
		} else {
			parent.window.frames['subMainFrameSet'].cols = "200px,10px,*";
			objtd.innerHTML = '&lt;';
		}
	}
</script>
<BODY>
	<table border="0" cellpadding="0" height="100%" >
		<tr>
			<td valign="middle" title="显示隐藏左菜单" onMouseOver=""
				onClick="ShowHideLeft(this);">&lt;</td>
		</tr>
	</table>

</BODY>
</HTML>
