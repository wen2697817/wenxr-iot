<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/website.jsp" %>
</head>
<body>
<s:iterator value="fieldErrors">
	<s:property/><br/>
	<s:iterator value="value_______"> 
		<s:property/>
	</s:iterator> 
</s:iterator>
</body>
</html>