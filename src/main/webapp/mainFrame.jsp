<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath %>"/>
		<meta charset="utf-8">
	</head>
		
	<FRAMESET style="height:100%;" id="subMainFrameSet" border="0" frameSpacing="0" frameBorder="0" cols="200px,10px,*">
			<FRAME id="funcTreeFrame" name="funcTreeFrame" src="left.jsp" frameBorder="0"></FRAME>
			<FRAME id="pageline" name="pageline" src="frameline.jsp" scrolling="no" noresize="noresize"></FRAME>
			<FRAME id="contentFrame" name="contentFrame" src="<%=basePath %>monitor/monitorList.jsp" frameBorder="0" scrolling="auto"></FRAME>
	</FRAMESET>
</html>