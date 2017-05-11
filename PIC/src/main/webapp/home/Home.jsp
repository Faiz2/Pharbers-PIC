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
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="image/x-icon" rel="icon" href="../assets/images/pharbers.ico">
<link type="image/x-icon" rel="shortcut icon" href="../assets/images/pharbers.ico">
<link type="image/x-icon" rel="bookmark" href="../assets/images/pharbers.ico">
<link rel="stylesheet" type="text/css" href="../assets/css/common.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/flavr/animate.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/flavr/flavr.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.common.min.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.default.min.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap.css" />
<!-- <link rel="stylesheet" type="text/css" href="../assets/css/video/video-js.min.css" /> -->
<link rel="stylesheet" type="text/css" href="../assets/css/style2.css" />
<script src="../assets/js/html5media.min.js"></script> 
<title>法伯科技数据中心（Pharbers Data Center）</title>
<style type="text/css">
.no-border>thead>tr>th, .no-border>tbody>tr>th, .no-border>tfoot>tr>th,
	.no-border>thead>tr>td, .no-border>tbody>tr>td, .no-border>tfoot>tr>td
	{
	border-top: 0;
	padding-top: 0;
	vertical-align: middle;;
}

html, body {
	height: 100%;
}

h1 {
	font-size: 3vw;
}

/* 	#ypxs { */
/* 	    border-color: rgba(82, 168, 236, 0.8); */
/* 	    box-shadow: 0 0 8px rgba(82, 168, 236, 0.6); */
/* 	    outline: 0 none; */
/* 	} */
table a {
	cursor: pointer;
}

.searchLoding, .alertDilogText {
	position: absolute;
	z-index: 1234;
	height: 100%;
	width: 100%;
	padding-top: 20%;
	padding-left: 48%;
	display: none;
}
</style>
</head>
<body leftMargin=0 topMargin=0 style="width: 100%;height: 100%;" oncontextmenu="return false" onselectstart="return false" ondragstart="return false" oncopy="return false" oncut="return false; >
	<div class="searchLoding" id="loding">
		<img alt="" src="../assets/images/loding1.gif">
	</div>
	<div class="alertDilogText" id="dilogText"></div>
	<!-- <div class="Text" id="dilogText">
		<div style="border: 1px solid black; padding: 10px;">没有搜索到您<br/>要找的数据！</div>
	</div> -->
	<div class="container-fluid">
		<jsp:include page="homeTop.jsp" />
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
				<h1 style="margin-top: 0;">法伯科技信息中心</h1>
			</div>
			<div class="h10"></div>
			<div
				class="col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
				<div class="input-group input-group-lg">
					<div class="input-group-addon input-group-addon-lg">
						<span class="glyphicon glyphicon-search glyphicon-lg"></span>
					</div>
					<input type="text" class="form-control input-md" id="search" placeholder="请搜索关键词" data-toggle="tooltip" data-placement="right" title="回车搜索">
				</div>
				<div class="h10"></div>
				<div class="table-responsive" style="overflow-y: hidden;">
					<table class="table no-border">
						<tr>
							<td rowspan="2" colspan="2">
								<div id="ypxs" class="artGroup slide">
									<div class="artwork" id="test">
										<a href="index1" class="detail">
											<!-- <div class="modelTop">医院药品销售数据库</div>
											<div>style="padding-top: 30%;"
												<p>最小颗粒度数据：全面、准确、更新迅速</p>
												<p>多维分析报告：便捷、可视、一键获取</p>
												<p>洞悉市场，轻松决策，大大节约时间和成本</p>
											</div> -->
											<video id="mv" src="../assets/video/yyypxssjk.mp4" style="border: 0;padding: 0;margin: 0;" loop="true" controls preload></video>
										</a> <img src="../assets/images/mess-img1.png" class="img-responsive img-rounded" alt="" width="100%"></img>
									</div>
								</div> <!-- 				    		<div style="width: 100%;height: 100%;"> --> <!-- 				    			<a href="index1.jsp"  ><img src="../assets/images/mess-img1.png" class="img-responsive img-rounded" alt="" width="100%"></img></a> -->
								<!-- 				    		</div> -->
							</td>
							<td></td>
							<td>
								<!-- 				    		<div class="artGroup slide"> --> <!-- 								<div class="artwork">  -->
								<!-- 									<a href="#" class="detail" > --> <!-- 										<div> -->
								<!-- 											222 --> <!-- 										</div> --> <!-- 									</a> -->
								<!-- 									<img src="../assets/images/mess-img3.png" class="img-responsive img-rounded" alt="" width="100%"></img> -->
								<!-- 								</div> --> <!-- 							</div> -->
								<div>
									<a  href="#" class="un"><img src="../assets/images/mess-img3.png" class="img-responsive img-rounded" alt="" width="100%"></img></a>
								</div>
							</td>
							<td>
								<div>
									<a href="#" class="un"><img src="../assets/images/mess-img4.png" class="img-responsive img-rounded" alt="" width="100%"></img></a>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div>
									<a href="#" class="un"><img src="../assets/images/mess-img2.png" class="img-responsive img-rounded" alt="" width="100%"></img></a>
								</div>
							</td>
							<td colspan="2">
								<div>
									<a href="#" class="un"><img src="../assets/images/mess-img5.png" class="img-responsive img-rounded" alt="" width="100%"></img></a>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<jsp:include page="homeFooter.jsp" />
	</div>
	<div id="contactus" style="display: none;"></div>
	<div id="about" style="display: none;"></div>
	<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/js/KendoUI/kendo.all.min.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets/js/common.js" type="text/javascript"></script>
	<script src="../assets/js/jquery.easing.min.js" type="text/javascript"></script>
	<script src="../assets/js/modernizr.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="../assets/js/lhgdialog/lhgdialog.min.js?skin=iblue&self=true"></script>
	<script src="../assets/js/flavr/flavr.min.js" type="text/javascript"></script>
<!-- 	<script src="../assets/js/video/video.min.js" type="text/javascript"></script> -->
	<script src="../assets/js/home.js" type="text/javascript"></script>
	<script type="text/javascript">
	    var userName = "<%=userName%>";
		var temp = false;
		$(document).ready(function(){
			$("#userName").text(userName);
			$("#jxname").text(userName.substring(userName.length-1));
			$("#grzl").click(function(){
				if(!temp){
					myAlert();
				}
				temp = true;
			});
			$(".un").click(function(){
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
			$("#test").mouseover(function(){
 				//console.info($(this).width()+"--"+$(this).height());
 				$('#mv').attr("width",$(this).width()-1);//$(this).width()
 				$('#mv').attr("height",$(this).height());//$(this).height()
				$('#mv').trigger('play');
			}).mouseout(function(){
				$('#mv').trigger('pause');
			})
			
			var contactus = $("#contactus"),contactusbtn = $("#contactusbtn").bind("click", function() {
				window(0);
				contactus.data("kendoWindow").open().center();
	            contactusbtn.hide();
            });
			
			var about = $("#about"),aboutbtn = $("#aboutbtn").bind("click", function() {
				window(1);
				about.data("kendoWindow").open().center();
	            aboutbtn.hide();
            });
			var onClose = function() {
				aboutbtn.show();
                contactusbtn.show();
            }
			
			function window(type){
				var title,content,winObj;
				if(type == 0){
					title = "联系方式";
					content = "contactus.jsp";
					winObj = contactus;
				}else if(type == 1){
					title = "关于";
					content = "about.jsp";
					winObj = about;
				}
				
				if (!winObj.data("kendoWindow")) {
					winObj.kendoWindow({
	                    width: '80%',
	                    height: '90%',
	                    title: title,
	                    actions: [
	                        "Close"
	                    ],
	                    close: onClose,
	                    content: content
	                });
	            }
			}
			
			/* if (!contactus.data("kendoWindow")) {
				contactus.kendoWindow({
                    width: '80%',
                    height: '90%',
                    title: "联系方式",
                    actions: [
                        "Close"
                    ],
                    close: onClose,
                    content: "contactus.jsp"
                });
            } */
            
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
			subForm.action="../userInfo/logoutSystem";
			subForm.submit();
		}
	</script>
</body>
<script type="text/javascript"> 
	document.body.onselectstart=document.body.oncontextmenu=function(){ return false;} 
</script> 
</html>