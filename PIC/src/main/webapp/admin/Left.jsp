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
	<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.common.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.default.min.css" />

	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- Bootstrap 3.3.5 -->
	<link rel="stylesheet" href="../assets/css/admin/bootstrap/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="../assets/css/admin/bootstrap/fontawesome/css/font-awesome.min.css">
	<!-- Ionicons 
	  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
	  -->
	<!-- Theme style -->
	<link rel="stylesheet" href="../assets/css/admin/bootstrap/dist/css/AdminLTE.min.css">
	<!-- AdminLTE Skins. Choose a skin from the css/skins
	       folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="../assets/css/admin/bootstrap/dist/css/skins/_all-skins.min.css">
	<!-- DataTables -->
	<link rel="stylesheet" href="../assets/css/admin/bootstrap/plugins/datatables/dataTables.bootstrap.css">
	

	
	<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>

	<!-- Bootstrap 3.3.5 -->
	<script src="../assets/css/admin/bootstrap/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	
	<!-- FastClick -->
	<script src="../assets/css/admin/bootstrap/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="../assets/css/admin/bootstrap/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../assets/css/admin/bootstrap/dist/js/demo.js"></script>
	
	<!-- SlimScroll -->
	<script src="../assets/css/admin/bootstrap/plugins/slimScroll/jquery.slimscroll.min.js"></script>
</head>
		  <header class="main-header">
		  	<a href="#" onclick="logoutSys()"><span style="position: absolute;color: #fff;right: 33px;z-index: 9999;line-height: 50px;">退出</span></a>
		    <!-- Logo -->
		    <a href="" class="logo">
		      <!-- mini logo for sidebar mini 50x50 pixels -->
		      <span class="logo-mini"><b>A</b>LT</span>
		      <!-- logo for regular state and mobile devices -->
		      <span class="logo-lg"><b>Admin</b></span>
		    </a>
		    <!-- Header Navbar: style can be found in header.less -->
		    <nav class="navbar navbar-static-top" role="navigation">
		      <!-- Sidebar toggle button-->
		      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
		        <span class="sr-only">Toggle navigation</span>
		      </a>
		    </nav>
		  </header>
		  <!-- Left side column. contains the logo and sidebar -->
		  <aside class="main-sidebar">
		    <!-- sidebar: style can be found in sidebar.less -->
		    <section class="sidebar">
		      <!-- Sidebar user panel -->
		      <div class="user-panel">
		        <div class="pull-left image">
		          <img src="../assets/css/admin/bootstrap/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
		        </div>
		        <div class="pull-left info">
		          <p>Alexander Pierce</p>
		          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
		        </div>
		      </div>
		      <!-- sidebar menu: : style can be found in sidebar.less -->
		      <ul class="sidebar-menu">
		        <li class="user-manage">
		          <a href="../admin/UserManage">
		            <i class="glyphicon glyphicon-user"></i> <span>用户管理</span>
		          </a>
		        </li>
		        <li class="role-manage">
		          <a href="../admin/RoleManage">
		            <i class="fa fa-book"></i> <span>角色管理</span>
		          </a>
		        </li>
		        <li class="module-manage">
		        	<a href="../admin/ModuleManage">
		        	<i class="fa fa-fw fa-cubes"></i> 
		        	<span>模块管理</span></a>
		        </li>
		        <li class="data-manage">
		        	<a href="../admin/DataManage">
		        	<i class="fa fa-table"></i> 
		        	<span>数据同步</span></a>
		        </li>
		        <li class="login-manage">
		        	<a href="../loginLog/query"><!-- ../admin/LoginLog -->
		        	<i class="fa fa-list-alt"></i> 
		        	<span>登录日志</span></a>
		        </li>
		      </ul>
		    </section>
		    <form id="subForm" name="subForm" method="post"></form>
		    <!-- /.sidebar -->
		  </aside>
		  <script type="text/javascript">
		  		function logoutSys(){
		  			$.post("../userInfo/logout",{},function(data){
		  				if(eval("("+data+")") == "ok"){
		  					subForm.action="../userInfo/logoutSystem";
		 		  			subForm.submit();
		  				}else{
		  					alert("因后端异常无法请求数据，请关闭浏览器重试！");
		  				}
		  			});
		  		}
		  </script>
</html>