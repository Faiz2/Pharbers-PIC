<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="navbar navbar-default navbar-static-top">
	<div class="row hoemTop">
		<!--  class="img-responsive " -->
		<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" style="padding-left: 45px;">
			<a href="#"><img src="../assets/images/logo.gif" alt="" /></a>
		</div>
		<div class="col-xs-4 col-sm-4 col-md-8 col-lg-8"></div>
		<div class="col-xs-6 col-sm-6 col-md-2 col-lg-2 text-center">
			<div class="language-box">
				<div id="btnGroup" class="btn-group btn-group-lg">
					<button id="en" type="button" class="btn btn-default">EN</button>
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
<form id="subForm" name="subForm" method="post"></form>