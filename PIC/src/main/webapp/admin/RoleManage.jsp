<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/js/common.js" type="text/javascript"></script>
</head>
<body class="skin-blue sidebar-mini wysihtml5-supported">
		<jsp:include page="Left.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>角色管理</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">角色管理</a></li>
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
								<div id="gridRole">暂无角色</div>
							</div>
							
							<!-- /.page-index -->
							<div class="row" id="pagaIndex"></div>
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
		<script src="../assets/js/admin/RoleManage.js" type="text/javascript"></script>
</body>
</html>