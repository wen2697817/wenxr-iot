<%@ page language="java" pageEncoding="UTF-8" %>
<!-- 
	add by yanghl,
	common page , for loading js file.
	use : common.jsp?js=a.js&js=b.js......
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/commons/meta.jsp" %>
    <base href="<%=basePath%>">
    
	<script type="text/javascript" src="<%=basePath%>js/ShanDongCity.js"></script>
	<script type="text/javascript" src="<%=basePath%>commons/Ad.js"></script>
	<%
		String[] css = request.getParameterValues("css");
		css = css == null ? new String[0] : css;
		for(String cssFile : css) {
			%><link rel="stylesheet" type="text/css" href="<%=cssFile %>"/><%
		}
		String[] js = request.getParameterValues("js");
		js = js == null ? new String[0] : js;
		for(String jsFile : js) {
			%><script type="text/javascript" src="<%=jsFile %>"></script><%
		}
	%>
	<script type="text/javascript">
		var cityScope = <%="".equals(session.getAttribute(Globals.getProp("CITY_SCOPE"))) ? "city" : "["+session.getAttribute(Globals.getProp("CITY_SCOPE"))+"]"%>;

		var cellPath = "<%=basePath%>";
	</script>
  </head>
  
  <body>
  </body>
</html>
