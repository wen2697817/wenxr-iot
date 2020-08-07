<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.wenxr.iot.util.Globals"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%  
    String basePath = request.getContextPath() + "/";
    request.setAttribute("basePath", basePath);
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">

<!--[if lt IE 9]>
    <script src="<%=basePath %>js/jquery-1.9.1.min.js"></script>
<![endif]-->
<!--[if !IE]><!-->
    <script src="<%=basePath %>js/jquery-2.1.4.min.js"></script>
 <!--<![endif]-->
<!--[if gte IE 9]>
    <script src="<%=basePath %>js/jquery-2.1.4.min.js"></script>
<![endif]-->
<script src="<%=basePath %>js/public.js"></script>
<script type="text/javascript" >
	var basePath = "<%=basePath %>";


	//var msg = '<s:property value="msg" escapeHtml="false"/>';
	//if(msg){alert(msg);}
</script>
<s:bean name="com.wenxr.iot.util.Tools" id="Tools"/>