<%@page import="pha.com.code.system.model.UserInfo"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
	Subject subject = SecurityUtils.getSubject();
	//3.从realm得到用户信息
	UserInfo userInfo = (UserInfo) subject.getPrincipal();
	String userName = userInfo.getName();
	String list = (String)subject.getSession().getAttribute("AuthList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
	<link type="image/x-icon" rel="icon" href="../assets/images/pharbers.ico"/>
	<link type="image/x-icon" rel="shortcut icon" href="../assets/images/pharbers.ico"/>
	<link type="image/x-icon" rel="bookmark" href="../assets/images/pharbers.ico"/>
	
	
	<link rel="stylesheet" type="text/css" href="../assets/css/common.css" />
<!-- 	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap-select.min.css" /> -->
	<link rel="stylesheet" type="text/css" href="../assets/css/Select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap.css" />
	
	<link rel="stylesheet" type="text/css" href="../assets/css/flavr/animate.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/flavr/flavr.css" />
	
	<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.common.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.default.min.css" />
	
	<link rel="stylesheet" type="text/css" href="../assets/css/jQueryScrollBar/jquery.mCustomScrollbar.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/style2.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/report.css" />
	<style>
	/* 	.data-summary-box ,.img-responsive > img {display: inline-block;} */
		.data-summary-box  .img-responsive {
			display: inline-block;
		}
		.k-icon{margin-top: 20%;}
		.flavr-container{
			z-index: 9999;
		}
		.xiaojieli ul li {
		    list-style-type:square; 
		}
	</style>
<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="../assets/js/KendoUI/kendo.all.min.js" type="text/javascript"></script>

<script src="../assets/js/jQueryUI1.10/jquery-ui-1.10.4.min.js" type="text/javascript"></script>
<script src="../assets/js/jQueryScrollBar/jquery.mousewheel.min.js" type="text/javascript"></script>
<script src="../assets/js/jQueryScrollBar/jquery.mCustomScrollbar.js" type="text/javascript"></script>

<script src="../assets/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript" src="../assets/js/Select2/select2.js"></script>
<script type="text/javascript" src="../assets/js/Select2/zh-CN.js"></script>

<script src="../assets/js/eachars3.0/echarts.js" type="text/javascript"></script>
<script src="../assets/js/eachars3.0/map/china.js" type="text/javascript"></script>
<script src="../assets/js/eachars3.0/config.js" type="text/javascript"></script>

<script src="../assets/js/accounting.min.js" type="text/javascript"></script>

<script type="text/javascript" src="../assets/js/lhgdialog/lhgdialog.min.js?skin=iblue&self=true"></script>

<script src="../assets/js/flavr/flavr.min.js" type="text/javascript"></script>

<!-- <script type="text/javascript" src="http://www.xdocin.com/xdoc.js"></script> -->

<title>法伯科技数据中心（Pharbers Data Center）</title>
</head>
<body>
	<div class="container-fluid mCustomScrollbar" ><!-- mCustomScrollbar data-mcs-theme="minimal-dark" -->
		<jsp:include page="Top.jsp" />
		<div class="row">
			<jsp:include page="Left.jsp" />
			<div class="col-xs-9 col-sm-9 col-md-9 col-lg-10" style="">
				<div class="h40"></div>
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 topfourwidth">
					<div class="col-xs-10 col-sm-8 col-md-6 col-lg-5 screening-results">您筛选结果的数据小结：</div>
					<div class="h20"></div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-4 summary-pictrue">
									<img src="../assets/images/01.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-5 col-md-5 col-lg-4 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">市场规模：</span>
							</div>
							<div class="col-xs-8 col-sm-7 col-md-7 col-lg-8" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right" id="guim"></span>
							</div>
							<div class="topfourdiv loadNone">
								<img src="../assets/images/load2.gif" alt="" class="img-responsive" />
							</div>
						</div>
					</div>

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-4 summary-pictrue">
									<img src="../assets/images/02.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-5 col-md-5 col-lg-4 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">市场增长率：</span>
							</div>
							<div class="col-xs-8 col-sm-7 col-md-7 col-lg-8" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right" id="zengzl"></span>
							</div>
							<div class="topfourdiv loadNone">
								<img src="../assets/images/load2.gif" alt="" class="img-responsive" />
							</div>
						</div>
					</div>

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-4 summary-pictrue">
									<img src="../assets/images/03.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-5 col-md-5 col-lg-4 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">市场份额：</span>
							</div>
							<div class="col-xs-8 col-sm-7 col-md-7 col-lg-8" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right" id="fene"></span>
							</div>
							<div class="topfourdiv loadNone">
								<img src="../assets/images/load2.gif" alt="" class="img-responsive" />
							</div>
						</div>
					</div>

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-4 summary-pictrue">
									<img src="../assets/images/04.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-4 col-sm-5 col-md-5 col-lg-4 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">产品数量：</span>
							</div>
							<div class="col-xs-8 col-sm-7 col-md-7 col-lg-8" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right" id="chanps"></span>
							</div>
							<div class="topfourdiv loadNone">
								<img src="../assets/images/load2.gif" alt="" class="img-responsive" />
							</div>
						</div>
					</div>
					<div class="h40"></div>
					<div id="show">
<%-- 						<jsp:include page="Report.jsp" /> --%>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							 <div class="brief-introduction">
								<div class="brief-picture">
									<img src="../assets/images/content1.png" alt="" class="imgcontent"/><!-- class="img-responsive" -->
								</div>
							</div> 
							<div class="h10"></div>
						</div>
					</div>
					<!--<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						 <div class="brief-introduction">
							<div class="brief-picture">
								<img src="../assets/images/content1.jpg" alt="" class="img-responsive"/>
							</div>
						</div> 
						<div class="h10"></div>
					</div>-->
				</div>
			</div>
		</div>
		<jsp:include page="Footer.jsp" />
		<div class="excelReportLoad loadNone"><!--  excelDataLoad -->
			<img src="../assets/images/load2.gif" alt="" class="img-responsive" />
		</div>
	</div>
	<script src="../assets/js/common.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<script src="../assets/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	<script src="../assets/js/left.js" type="text/javascript"></script>
	<script type="text/javascript">
	var pageTypeIndex="index1Page";
	var userName = "<%=userName%>";
	var list = <%=list%>;
	var temp = false;
	$(document).ready(function(){
		$('#timeTab a').click(function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		});
		$("#userName").text(userName);
		$("#jxname").text(userName.substring(userName.length-1));
		$("#grzl").click(function(){
			if(!temp){
				myAlert();
			}
			temp = true;
		});
		
		$("#en").click(function(){
			if(!temp){
				myAlert();
			}
			temp = true;
		});
		$(".mCustomScrollbar").mCustomScrollbar({
			theme:"minimal-dark",
			 scrollEasing:"easeOutCirc",
			scrollInertia:400
		});
	});
	
	function myAlert(){
		new $.flavr({
		    animateEntrance : "flipInX",
		    animateClosing  : "flipOutX",
		    content         : "该功能暂未开放！",
		    buttons     : {
		    	info  : { text: "知道了", style: "info"}
		    },
		    onClose     : function(){
		    	temp = false;
		    }
		});
	}
	
	function logoutSys(){
		$.post("../userInfo/logout",{},function(data){
			if(eval("("+data+")") == "ok"){
				location="../userInfo/logoutSystem";
			}else{
				alert("因后端异常无法请求数据，请关闭浏览器重试！");
			}
		});
	}
</script>
<!-- 	<script src="../assets/js/report.js" type="text/javascript"></script> -->
</body>
</html>