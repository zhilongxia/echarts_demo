<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<script src="<%=request.getContextPath() %>/resources/js/echarts/echarts.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery/jquery-1.9.1.min.js"></script>
