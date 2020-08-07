<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<%@ include file="/commons/website.jsp" %>
	</head>
  
  <body>
  	<img alt="" src="<%=basePath%>img/wait.gif">
  	<s:if test="msg != null">
		<script type="text/javascript" language="javascript" charset="UTF-8">
			alert('<s:property value="msg" escapeHtml="false"/>');
			if(self.opener && self.opener.document && self.opener.document.frmMain) {
				$(self.opener.document.frmMain).submit();
			}
			self.close();
		</script>
	</s:if>
  </body>
</html>
