<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="navbar navbar-default navbar-static-top" style="margin-bottom: 0;">
	<div class="row hoemTop">
		<!--  class="img-responsive " -->
		<div class="col-xs-1 col-sm-1 col-md-2 col-lg-2" style="padding-left: 45px;">
			<a href="#"><img src="../assets/images/logo.gif" alt="" /></a>
		</div>
		<div class="col-xs-8 col-sm-5 col-md-6 col-lg-8 header-title" style="height: 70px;">
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-8" style="padding-left: 0;">
				<h2>中国等级医院药品销售信息库</h2>
			</div>
		</div>
		<form id="subForm" name="subForm" method="post"></form>
		<div class="col-xs-3 col-sm-5 col-md-4 col-lg-2 text-center">
			<div class="language-box">
				<div id="btnGroup" class="btn-group btn-group-lg">
					<button type="button" id="en" class="btn btn-default">EN</button>
					<button id="btnShow" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<span id="jxname">NULL</span> <span class="caret"></span>
					</button>
					<div id="content" class="dropdown-menu" role="menu"
						style="padding: 0;">
						<div class="drop-down">
							<div class="manager-text">
								<span id="userName">NULL</span>
							</div>
							<div class="personal-text">
								<a class="border-left" href="#" id="grzl">个人资料</a> <a href="#" onclick="logoutSys()">退出</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>