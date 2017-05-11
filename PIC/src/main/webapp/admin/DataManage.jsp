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
	<link rel="stylesheet" type="text/css" href="../assets/css/style2.css" />
	
	<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<style>
		.load{
			position: absolute; 
			z-index:99999;
			left: 0; 
			top: 0;
			width:100%;
			height:100%;
			padding-top:25%;
			padding-left:50%;
			background-color:#F3F3F3;
			filter:alpha(opacity=55);   
		    -moz-opacity:0.55;   
		    -khtml-opacity: 0.55;
		    opacity: 0.55;
			display: block;
		}
		.noload{display: none;}
	</style>
</head>
<body class="skin-blue sidebar-mini wysihtml5-supported">
		<jsp:include page="Left.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>数据管理</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">数据同步</a></li>
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
								<button id="index" class="btn btn-block btn-primary">生成最新的数据索引</button>
								<br/>
								<input id="str"/>
								<button id="query" class="btn btn-block btn-primary">查询最新的数据索引</button>
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
			<div id="loads" class="load noload">
				<img src="../assets/images/load2.gif" alt="" class="img-responsive" />
			</div>
		</div>
		<!-- <script src="../assets/js/KendoUI/kendo.all.min.js" type="text/javascript"></script>
		<script src="../assets/js/KendoUI/kendo.grid.js" type="text/javascript"></script> -->
		<script src="../assets/js/admin/dataManage.js" type="text/javascript"></script>
</body>
</html>