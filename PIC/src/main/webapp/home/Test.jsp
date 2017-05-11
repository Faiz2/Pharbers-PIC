<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link type="image/x-icon" rel="icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="shortcut icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="bookmark" href="../assets/images/pharbers.ico">
	
	<style>
	/* 	.data-summary-box ,.img-responsive > img {display: inline-block;} */
		.data-summary-box  .img-responsive {
			display: inline-block;
		}
		.k-icon{margin-top: 20%;}
	</style>
<script src="../assets/js/jquery-1.9.1.min.js" type="text/javascript"></script>

<script src="../assets/js/eachars3.0/echarts.js" type="text/javascript"></script>
<script src="../assets/js/eachars3.0/config.js" type="text/javascript"></script>

</head>
<body>
	<div id="yearBarAtcXse" style="width: 100%; height: 400px"></div>
	<button id="test">Test</button>
	
	
<script type="text/javascript">
var yearBarObj;
	$(document).ready(function(){
		yearBarObj = echarts.init(document.getElementById('yearBarAtcXse'));
		
		yearBarObj.setOption({
			tooltip: {
		        trigger: 'axis'
		    },
		    toolbox: {
		        feature: {
		            dataView: {show: true, readOnly: false},
		            magicType: {show: true, type: ['line', 'bar']},
		            restore: {show: true},
		            saveAsImage: {show: true}
		        }
		    },
		    legend: {
		        data:['蒸发量','降水量','平均温度']
		    },
		    xAxis: [
		        {
		            type: 'category',
		            data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            name: '水量',
		            min: 0,
		            max: 250,
		            interval: 50,
		            axisLabel: {
		                formatter: '{value} ml'
		            }
		        },
		        {
		            type: 'value',
		            name: '温度',
		            min: 0,
		            max: 25,
		            interval: 5,
		            axisLabel: {
		                formatter: '{value} °C'
		            }
		        }
		    ],
		    series: [
		        {
		            name:'蒸发量',
		            type:'bar',
		            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
		        },
		        {
		            name:'降水量',
		            type:'bar',
		            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
		        },
		        {
		            name:'平均温度',
		            type:'line',
		            yAxisIndex: 1,
		            data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
		        }
		    ]
		});
		$("#test").click(function(){
			var picBase64Info = yearBarObj.getDataURL();   //获取base64编码
			var picBase64 = picBase64Info.substring(picBase64Info.indexOf(",")+1,picBase64Info.length);
			$.post("../exportWord/downWord",{"name":"Test","imgBase64URL":picBase64},function(data){
				console.info(data);
			});
 			console.log(picBase64);
		});
	});
</script>
</body>
</html>