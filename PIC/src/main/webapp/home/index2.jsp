<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link type="image/x-icon" rel="icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="shortcut icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="bookmark" href="../assets/images/pharbers.ico">
	
	
	<link rel="stylesheet" type="text/css" href="../assets/css/common.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/Select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap.css" />
	
	<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.common.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/KendoUI/styles/kendo.default.min.css" />
	
	<link rel="stylesheet" type="text/css" href="../assets/css/jQueryScrollBar/jquery.mCustomScrollbar.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/style2.css" />
	
	<style>
		.k-icon{margin-top: 20%;}
	</style>

<title>法伯科技数据中心（Pharbers Data Center）</title>
</head>
<body>
	<div class="container-fluid mCustomScrollbar" data-mcs-theme="minimal-dark" style="height: 100%;">
		<jsp:include page="Top.jsp" />
		<div class="row" style="height: 100%;">
			<jsp:include page="Left.jsp" />
			<div class="col-xs-9 col-sm-9 col-md-9 col-lg-10" style="height: 100%;">
				<div class="h40"></div>
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="height: 100%;">
					<div class="col-xs-10 col-sm-8 col-md-6 col-lg-5 screening-results">您筛选结果的数据小结：</div>
					<div class="h20"></div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;height: 100%;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-5 summary-pictrue">
									<img src="../assets/images/summary-img1.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">市场规模：</span>
							</div>
							<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right">300,000 </span>
							</div>
						</div>
					</div>

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;height: 100%;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-5 summary-pictrue">
									<img src="../assets/images/summary-img2.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">市场增长率：</span>
							</div>
							<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right">30%/yr </span>
							</div>
						</div>
					</div>

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;height: 100%;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-5 summary-pictrue">
									<img src="../assets/images/summary-img3.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">市场份额：</span>
							</div>
							<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right">35% </span>
							</div>
						</div>
					</div>

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;height: 100%;">
						<div class="data-summary-box">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 summary-pictrue">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-5 summary-pictrue">
									<img src="../assets/images/summary-img4.png" alt="" class="img-responsive" />
								</div>
							</div>
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-6 text-right" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="scree-left">新产品上市数：</span>
							</div>
							<div class="col-xs-7 col-sm-7 col-md-7 col-lg-6" style="height: 50px; line-height: 50px; padding: 0;">
								<span class="data-right">12,615 </span>
							</div>
						</div>
					</div>
					<div class="h40"></div>
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="col-xs-10 col-sm-8 col-md-6 col-lg-5 screening-results" style="padding-left: 0;">您需要的数据：</div>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div id="grid"></div>
						</div>
						<div class="presentation-right">
							<a href="index3.jsp">显示市场报告</a> <a href="#">导出数据</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="Footer.jsp" />
	</div>
	<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/js/jQueryUI1.10/jquery-ui-1.10.4.min.js" type="text/javascript"></script>
	<script src="../assets/js/jQueryScrollBar/jquery.mousewheel.min.js" type="text/javascript"></script>
	<script src="../assets/js/jQueryScrollBar/jquery.mCustomScrollbar.js" type="text/javascript"></script>
	
	<script src="../assets/js/KendoUI/kendo.all.min.js" type="text/javascript"></script>
	
	<script src="../assets/js/gridData.js" type="text/javascript"></script>
	
	<script src="../assets/js/Select2/select2.js" type="text/javascript" ></script>
	<script src="../assets/js/Select2/zh-CN.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets/js/common.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<script src="../assets/js/left.js" type="text/javascript"></script>
	<script type="text/javascript">
		var pageTypeIndex="index2Page";
		$(document).ready(function(){
			$('#timeTab a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			});
		});
	</script>
</body>
</html>