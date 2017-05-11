<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	<div class="col-xs-10 col-sm-8 col-md-6 col-lg-5 screening-results" style="padding-left: 0;">您需要的数据：</div>
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div id="grid"></div>
	</div>
	<div class="presentation-right">
		<a id="xsssbg" onclick="showView(0)">显示市场报告</a> <a onclick="reportExcelDataGrid()">导出数据</a>
	</div>
</div>
<script src="../assets/js/gridData.js" type="text/javascript"></script>
<script src="../assets/js/report.js" type="text/javascript"></script>