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
	<style>
	/* 	.data-summary-box ,.img-responsive > img {display: inline-block;} */
		.data-summary-box  .img-responsive {
			display: inline-block;
		}
		.k-grid-pager .k-icon{margin-top: 20%;}
		
		#treeView .k-checkbox-label:before {
			  position: absolute;
			  top: -5px;
			  left: 0;
			  border-width: 1px;
			  border-style: solid;
			  width: 1em;
			  height: 1em;
			  font-size: 1em;
			  line-height: 1em;
			  text-align: center;
			}
		
		#treeView .k-checkbox:indeterminate+.k-checkbox-label:after {
		    position: absolute;
		    left: 50%;
		    top: 3px;
		    -webkit-transform: translate(-50%,-50%);
		    -ms-transform: translate(-50%,-50%);
		    transform: translate(-50%,-50%);
		    border-width: 1px;
		    border-style: solid;
		    width: 8px;
		    height: 8px;
		    font-size: 1em;
		    text-align: center;
		    content: " ";
		    margin-left: -2px;
		}
	</style>
</head>
<body class="skin-blue sidebar-mini wysihtml5-supported">
		<jsp:include page="Left.jsp"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>用户管理</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">用户管理</a></li>
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
<!-- 							/.box-header -->
							<div class="box-body">
								<div id="grid"></div>
								<div id="treeView"></div>
							</div>
							<div id="template" style="display:none;">
						    	<a class="k-button" href="javascript:void;" onclick="deleteByIds();">批量删除</a>
						  	</div>
						  	<div id="templateRole" style="display:none;">
						    	<a class="k-button" href="javascript:void;" onclick="userSetRoles(this);">分配权限</a>
						  	</div>
<!-- 							/.page-index -->
							<div class="row" id="pagaIndex"></div>
							
							<div id="details"></div> 
							<div id="editTemplate" style="display:none;">
                   				<div id="details-container">
                        				用户名：<input type="text" value=" #= loginName #"/>
                        				用户状态: <dt>#= status #</dt>
                				</div>
            				</div> 
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<script src="../assets/js/KendoUI/kendo.all.min.js" type="text/javascript"></script>
		<script src="../assets/js/KendoUI/kendo.grid.js" type="text/javascript"></script>
		<script src="../assets/js/admin/UserManage.js" type="text/javascript"></script>
</body>
</html>