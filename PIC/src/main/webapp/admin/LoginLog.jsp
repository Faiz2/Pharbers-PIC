<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Pharbers Data Center</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link type="image/x-icon" rel="icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="shortcut icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="bookmark" href="../assets/images/pharbers.ico">
	
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/dist/css/AdminLTE.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/style2.css" />
	
	<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<!-- 	<script src="../assets/js/common.js" type="text/javascript"></script> -->
	<style>
		.k-grid-pager .k-icon{margin-top: 20%;}
	</style>
</head>
<body class="skin-blue sidebar-mini wysihtml5-supported">
		<jsp:include page="Left.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>日志管理</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Login日志</a></li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content" id="parentDataTable">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title"></h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
<!-- 								<div id="grid"></div> -->
								<table id="grid" class="table table-bordered table-hover">
					              <thead>
						              <tr>
						                <th>用户名</th>
						                <th>登入时间</th>
						                <th>登出时间</th>
						                <th>停留时长</th>
						                <th>登录IP</th>
						                <th>登录类型</th>
						              </tr>
					              </thead>
					              <tbody>
					              	<c:forEach var="list" items="${list}" varStatus="index">
					              		<tr>
					              			<td>${list.loginname }</td>
							                <td>
							                	<fmt:formatDate value="${list.loginstart }" pattern="yyyy-MM-dd HH:mm:ss"/>
							                </td>
							                <td>
							                	<fmt:formatDate value="${list.loginend }" pattern="yyyy-MM-dd HH:mm:ss"/>
							                </td>
							                <td>${list.timesum }</td>
							                <td>${list.ip }</td>
							                <td>
							                	<c:if test="${list.logintype == 0}">
							                		登出
							                	</c:if>
							                	<c:if test="${list.logintype == 1}">
							                		登入
							                	</c:if>
							                </td>
					              		</tr>
					              	</c:forEach>
					              </tbody>
					            </table>
							</div>
							<!-- /.page -->
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- <script src="../assets/js/KendoUI/kendo.all.min.js" type="text/javascript"></script>
		<script src="../assets/js/KendoUI/kendo.grid.js" type="text/javascript"></script> -->
		<!-- DataTables -->
		<script src="../assets/css/admin/bootstrap/plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="../assets/css/admin/bootstrap/plugins/datatables/dataTables.bootstrap.min.js"></script>
		<script src="../assets/js/admin/loginLog.js" type="text/javascript"></script>
		<script>
		  $(function () {
		    
		  });
		</script>
</body>
</html>