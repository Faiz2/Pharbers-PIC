<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link type="image/x-icon" rel="icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="shortcut icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="bookmark" href="../assets/images/pharbers.ico">
	
	<style>
	/* 	.data-summary-box ,.img-responsive > img {display: inline-block;} */
		.data-summary-box  .img-responsive {
			display: inline-block;
		}
		.k-icon{margin-top: 20%;}
	</style>
<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>


<script type="text/javascript">
	$(document).ready(function(){
		debugger;
		var a = "全国分省-qy";
		var b = "全国汇总-qy";
		var c = "[<shiro:hasPermission name='"+a+"'>]";
		var d = "[</shiro:hasPermission>]";
// 		$("#yearBarAtcXse").append("<shiro:hasPermission name='全国分省-qy'><option>全国分省-qy</option></shiro:hasPermission>");
		$("#yearBarAtcXse").append("<shiro:hasPermission name='全国分省-qy'>").append("<option>全国分省-qy</option>").append("</shiro:hasPermission>");
		$("#yearBarAtcXse").append("<shiro:hasPermission name='全国汇总-qy'>").append("<option>全国汇总-qy</option>").append("</shiro:hasPermission>");

		
// 		$("#yearBarAtcXse").append("<option>全国分省-qy</option>");
// 		$("#yearBarAtcXse").append("<option>全国汇总-qy</option>");

// 		console.info("<shiro:hasPermission name='"+a+"'><option>全国分省-qy</option></shiro:hasPermission>");
// 		console.info("<shiro:hasPermission name='"+b+"'><option>全国分省-qy</option></shiro:hasPermission>");

	});
// 	window.onload = function(){
// 		$("#yearBarAtcXse").append("<shiro:hasPermission name='全国分省-qy'><option>全国分省-qy</option></shiro:hasPermission>");
// 		$("#yearBarAtcXse").append("<shiro:hasPermission name='全国汇总-qy'><option>全国汇总-qy</option></shiro:hasPermission>");
// 	}
</script>
</head>
<body>
<%-- 	<shiro:hasPermission name="治疗类别I"> --%>
<!-- 		<span id="topmenu">治疗类别I</span> -->
<%-- 	</shiro:hasPermission> --%>
<%-- 	<shiro:hasPermission name="治疗类别II"> --%>
<!-- 		<span id="topmenu">治疗类别II</span> -->
<%-- 	</shiro:hasPermission> --%>
<%-- 	<shiro:hasPermission name="治疗类别III"> --%>
<!-- 		<span id="topmenu">治疗类别III</span> -->
<%-- 	</shiro:hasPermission> --%>
<%-- 	<shiro:hasPermission name="全国汇总-qy"> --%>
<!-- 		<span id="topmenu">全国汇总-qy</span> -->
<%-- 	</shiro:hasPermission> --%>
<%-- 	<shiro:hasPermission name="全国分省-qy"> --%>
<!-- 		<span id="topmenu">全国分省-qy</span> -->
<%-- 	</shiro:hasPermission> --%>
<!-- 	<div id="yearBarAtcXse" style="width: 100%; height: 400px"></div> -->
<select id="yearBarAtcXse">
<!-- 	<option>请选择</option> -->
</select>
</body>
</html>