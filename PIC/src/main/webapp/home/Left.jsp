<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<div class="col-xs-3 col-sm-3 col-md-3 col-lg-2 main-left"style="background-color: #ccc;">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
<!-- 		<div class="input-group input-group-md"> -->
<!-- 			<div class="input-group-addon input-group-addon-md"> -->
<!-- 				<span class="glyphicon glyphicon-search glyphicon-md"></span> -->
<!-- 			</div> -->
<!-- 			<input type="text" class="form-control input-md"  placeholder="请搜索关键词"> -->
<!-- 			 data-toggle="tooltip" data-placement="top" title="回车搜索"  -->
<!-- 		</div> -->
		<div class="box-wrap2">
			<input type="hidden" id="timeType" value="1"/>	
			<ul id="timeTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a id="tabYear" href="#year" aria-controls="year" role="tab" data-toggle="tab">年</a></li>
				<li role="presentation" class=""><a id="tabMonth" href="#month" aria-controls="month" role="tab" data-toggle="tab">月</a></li>
				<li role="presentation" class=""><a id="tabQuarter" href="#quarter" aria-controls="quarter" role="tab" da a-toggle="tab">季度</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="year">
					<div class="form-group" style="margin: 0;">
						<div class="input-group date timepk_year" data-date="" data-link-field="dtp_input2">
							<input class="form-control time" id="yearInputb" size="16" type="text" value="" readonly placeholder="截止时间">
							<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
					<!-- 至
				            	<div class="form-group" style="margin: 0;">
					                <div class="input-group date timepk_year" data-date="" data-link-field="dtp_input2">
					                    <input class="form-control time" id="yearInpute" size="16" type="text" value="" readonly placeholder="结束时间">
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
					                </div>
				            	</div> -->
				</div>
				<div class="tab-pane" id="month">
					<div class="form-group" style="margin: 0;">
						<div class="input-group date timepk_month" data-date="" data-link-field="dtp_input2">
							<input class="form-control time" id="monthInputb" size="16" type="text" value="" readonly placeholder="截止时间""> 
							<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
					<!-- 至
				            	<div class="form-group" style="margin: 0;">
					                <div class="input-group date timepk_month" data-date="" data-link-field="dtp_input2">
					                    <input class="form-control time" id="monthInpute" size="16" type="text" value="" readonly placeholder="结束时间">
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
					                </div>
				            	</div> -->
				</div>
				<div class="tab-pane" id="quarter">
					<div class="form-group" style="margin-bottom: 8px;">
						<div class="input-group date timepk_year" data-date="" data-link-field="dtp_input2">
							<input class="form-control time" id="quarterInput" size="16" type="text" value="" readonly placeholder="截止时间"">
							<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
					<select id="quarterSelect" class="selectWidth">
						<option value="1-3">第一季度</option>
						<option value="4-6">第二季度</option>
						<option value="7-9">第三季度</option>
						<option value="10-12">第四季度</option>
					</select>
				</div>
			</div>
		</div>
		<shiro:hasPermission name="治疗类别I">
			<div class="box-wrap">
				<select id="ATC1" class="selectWidth" name="atc1Name"></select>
			</div>
		</shiro:hasPermission>
		
		<div class="box-wrap">
			<select id="ATC2" class="selectWidth" name="atc2Name"></select>
		</div>
		<div class="box-wrap">
			<select id="ATC3" class="selectWidth" name="atc3Name"></select>
		</div>
		<div class="box-wrap">
			<select id="genericnameinfo" class="selectWidth" name="genericnameName"></select>
		</div>
		<div class="box-wrap">
			<select id="product" class="selectWidth" name="productName"></select>
		</div>
		<shiro:hasPermission name="qy">
			<div class="box-wrap">
				<select id="province" class="selectWidth" name="provinceName"></select>
			</div>
		</shiro:hasPermission>
		<div class="box-wrap">
			<select id="manufacturetype" class="selectWidth" name="manuTypeName"></select>
		</div>
		<div class="box-wrap">
			<select id="manufacture" class="selectWidth" name="manuName"></select>
		</div>
		<div class="box-wrap">
			<select id="dosage" class="selectWidth" name="dosageformName"></select>
		</div>
		<div class="box-wrap">
			<select id="specification" class="selectWidth" name="specificationsName"></select>
		</div>
		<div class="box-wrap">
			<select id="package" class="selectWidth" name="packagingName"></select>
		</div>
		
		<div class="screen-box"  id="screen_box"><!-- class="screen-box" -->
<!-- 			<a href="#">保存筛选器</a> <a onclick="resetbtn()" style="margin-left: 10px;">重置</a> <a class="search-btn" onclick="serachbtn()" style="margin-left: 5px;">搜索</a> -->
<!-- 			<a href="index3.jsp" class="search-btn" style="margin-left: 10px;">显示报告</a><a class="search-btn" href="index2.jsp" style="margin-left: 5px;">列表</a> -->
<!-- 			<a onclick="seachGrid()" class="search-btn" style="margin-left: 10px;">确认</a> -->
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"><a id="xsbg" class="search-btn" onclick="showView(0)">显示报告</a></div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"><a id="xssj" class="search-btn" onclick="showView(1)">显示数据</a></div>
			
<!-- 			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"><a class="search-btn" onclick="Test()">啦啦啦啦</a></div> -->
			
			
			
		</div>
		<div class="h100"></div>
		<div class="h10"></div>
		<!-- <div class="comment-box">
			<div class="comment-center">
				<textarea class="form-control textarea-input" style="height: 300px;"
					placeholder="留下您的评论……"></textarea>
			</div>
			<div class="comment-submit">
				<a href="#">取消</a> <a href="#" class="keep-btn">保存</a>
			</div>
		</div> -->
	</div>
</div>