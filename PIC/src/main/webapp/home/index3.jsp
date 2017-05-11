<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link type="image/x-icon" rel="icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="shortcut icon" href="../assets/images/pharbers.ico">
	<link type="image/x-icon" rel="bookmark" href="../assets/images/pharbers.ico">
	
	
	<link rel="stylesheet" type="text/css" href="../assets/css/common.css" />
<!-- 	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap-select.min.css" /> -->
	<link rel="stylesheet" type="text/css" href="../assets/css/Select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/jQueryScrollBar/jquery.mCustomScrollbar.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/style2.css" />
	<link rel="stylesheet" type="text/css" href="../assets/css/report.css" />
	<title>法伯科技数据中心（Pharbers Data Center）</title>
</head>
<body >
	<div class="container-fluid mCustomScrollbar" data-mcs-theme="minimal-dark" >
		<jsp:include page="Top.jsp" />
		<div class="row">
			<jsp:include page="Left.jsp" />
			<div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
				<div class="h40"></div>
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="col-xs-10 col-sm-8 col-md-6 col-lg-5 screening-results">您筛选结果的数据小结：</div>
					<div class="h20"></div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;">
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

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 0 0 0 15px;">
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

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"
						style="padding: 0 0 0 15px;">
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

					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"
						style="padding: 0 0 0 15px;">
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
						<div class="col-xs-10 col-sm-8 col-md-6 col-lg-5 screening-results" style="padding-left: 0;">您需要的市场报告：</div>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="market-report mCustomScrollbar" data-mcs-theme="minimal-dark"><!-- mCustomScrollbar -->
								<!-- <img src="../assets/images/reportimg/001.png" alt="" style="width: 90%;" class="img-responsive" />
								<img src="../assets/images/reportimg/002.png" alt="" style="width: 90%;" class="img-responsive" /> -->
								
								<!--
								
								
								<div id="yearTop10XseZzlZb" style="width:60%;height: 40%;"></div>
								<div id="yearTop10XseZb" style="width:60%;height: 40%;"></div> -->
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="border: 1px dashed #0070C0;">
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-top: 30px;">
										<div class="col-xs-4 col-sm-4 col-md-3 col-lg-2 text-center">
											<p><img src="../assets/images/reportimg/logo.png" alt="Logo"/></p>
											<p class="logoText">WWW.PHARBERS.COM</p>
											<p class="logoText">法伯科技</p>
										</div>
										<div class="col-xs-8 col-sm-8 col-md-9 col-lg-10 text-right">
											<p class="retortTitleCh">中国调脂药市场分析报告:医院市场 • 他汀类</p>
											<p class="retortTitleEn">China Lipid-modulating Drugs Report: Hospital Channel • Statins</p>
											<p class="reportTime">2016年6月</p>
										</div>
									</div>
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 reportSplitLine"></div>
									<div class="h20"></div>
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 text-center smallContent">
											小结
										</div>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1" style="padding-left: 0;">
											<div class="smallTitle">
												中国调脂药市场潜力巨大
											</div>
											<div class="h10"></div>
											<div class="smallText">
												高脂血症易诱发心血管疾病，发病率高且诊疗情况有待大力提高。而中国的调脂药市场容量巨大，他汀类化药占据绝对主导。客户定义的市场外资西药占主导，品牌集中度较高，竞争激烈，仿制药出现频率高。
												他汀类主导市场且将继续稳固增长，<span style="color:#C40F0F;">A</span>领跑<span style="color:#C40F0F;">（top10产品中排名第一的商品名）</span>。
												提高知晓率、治疗率和依从性，关注年轻化患者群体从而有效扩容市场。
												高脂血症新药市场有待于向他汀类无法触及的方向发展，且应关注对心血管系统的积极作用。
											</div>
										</div>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 text-center smallContent">
											高血脂症及其用药市场概括
										</div>
										<div style="height: 5px; line-height: 5px;clear: both;"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 descriContent" style="padding-left: 0;line-height: 25px;">
											<ul style="padding-left: 20px;margin-bottom: 0px;">
												<li>高血脂症疾病综述：易诱发心血管疾病，发病率高且还将上升，知晓率、就诊率和治疗率低，依从性差。</li>
												<li>调脂药用药市场总体分析：市场容量大且前景广阔；他汀类化药主导。</li>
											</ul>
										</div>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 text-center smallContent">
											医院<span style="color: #C00000;">他汀类调脂药</span>市场表现
										</div>
										<div style="height: 5px; line-height: 5px;clear: both;"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 descriContent" style="padding-left: 0;line-height: 25px;">
											<ul style="padding-left: 20px;margin-bottom: 0px;">
												<li>医院市场总体表现：<span class="biaozhuColor">2011-2016</span>增长率在<span class="biaozhuColor">x%-x%</span>
													截止<span class="biaozhuColor">2016年2月</span>年累计销售规模<span class="biaozhuColor">xxx</span>亿元
												</li>
												<li>不同省份市场表现：<span class="biaozhuColor">2011-2016，A、B、C</span>省份销售额复合增长率高达<span class="biaozhuColor">a%、b%、c%</span>
													到<span class="biaozhuColor">2016年2月累计一年X、Y、Z</span>省份市场贡献率达到<span class="biaozhuColor">a%、b%、c%</span>。
												</li>
												<li>
													外资和本土产品竞争态势：市场集中度高，<span class="biaozhuColor">2011-2016</span>，外资产品占<span class="biaozhuColor">90%</span>以上的市场份额，
													<span class="biaozhuColor">2016年2月累计一年</span>以<span class="biaozhuColor">xx</span>亿元占<span class="biaozhuColor">x%</span>。
												</li>
											</ul>
										</div>
<!-- 										页脚 -->
										<jsp:include page="yejiao.jsp"/>
<!-- 										页眉 -->
										<jsp:include page="yemei.jsp"/>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 descriContent" style="padding-left: 0;line-height: 30px;">
											<ul style="padding-left: 20px;margin-bottom: 0px;">
												<li>
													<span class="biaozhuColor">他汀类</span>个通用名自雷市场分析<span class="biaozhuColor">（客户定义的市场是某一通用名时，没有这部分；客户定义的市场属于治疗I类或者II类或者III类时，则对属于定义范围内的各通用名的市场分析）2011-2016年（客户定义的时间段），A、B和C</span>
													分别在医院他汀类调脂药市场的销售额占比分别为<span class="biaozhuColor">X%、X%和X%（列出最新月份MAT对应的 排名前三的通用名和销售额占比即可）</span>
												</li>
												<li>
													各产品市场表现：<span class="biaozhuColor">2016年2月累计一年（客户定义时间里，最新的年月MAT）</span>，<span class="biaozhuColor">xx</span>类药物
													中排名前三的品牌分别为<span class="biaozhuColor">A、B、C</span>市场份额分别是<span class="biaozhuColor">a、b、c</span>，占比为<span class="biaozhuColor">x%、x%、x%</span>。
												</li>
												<li>
													Top10厂家：<span class="biaozhuColor">外资占主导</span>，<span class="biaozhuColor">2011-2015</span>，Top10厂家合集占<span class="biaozhuColor">80%</span>
													<span class="biaozhuColor">x</span>厂家表现最为出色。
												</li>
												<li>
													Top10产品：<span class="biaozhuColor">2011-2016</span>，中国医院<span class="biaozhuColor">他汀类调脂药</span>，Top10的产品销售总额占到<span class="biaozhuColor">中国医院他汀类调脂药</span>
													市场的<span class="biaozhuColor">70%</span>以上。<span class="biaozhuColor">2016年2月累计一年</span>，Top10产品中<span class="biaozhuColor">x</span>个为外资，<span class="biaozhuColor">Y</span>个为内资产品，
													<span class="biaozhuColor">A</span>产品表现最为突出。
												</li>
												<li>
													历年上市新产品市场表现：<span class="biaozhuColor">201x</span>年上市多达<span class="biaozhuColor">x</span>个，<span class="biaozhuColor">内资产品居多</span>，
													<span class="biaozhuColor">阿托伐他汀</span>。
												</li>
											</ul>
										</div>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 text-center smallContent">
											市场需求和机遇
										</div>
										<div style="height: 5px; line-height: 5px;clear: both;"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1 descriContent" style="padding-left: 0;line-height: 25px;">
											<ul style="padding-left: 20px;margin-bottom: 0px;">
												<li>提高知晓率，治疗率和依从性。</li>
												<li>关注年轻化的患者群体；新型调脂类应关注对心血管的积极作用。</li>
											</ul>
										</div>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1" style="padding-left: 0;">
											<div class="contentTitle">
												高脂血症及其用药市场概述
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												高脂血症疾病综述
											</div>
											<div class="h10"></div>
											<div class="smallText">
												高脂血症是脂质代谢运转异常，使血清中总胆固醇（Total cholesterol，TC）、甘油三酯（Triglyceride，TG）及低密度脂蛋白（Low-density lipoprotein，LDL-C）含量升高，
												高密度脂蛋白（High-density lipoprotein，HDL-C）含量降低的临床综合征。
											</div>
											<div class="smallText">
												中国高脂血症的患病率大于20%，发病率大于10%，其中需要药物干预的约占总数的80%。伴随人口老龄化加速、不合理的饮食结构及生活方式，高脂血症的发病率将逐年上升。
												我国高脂血症的发病率呈年轻化和地域性分布，北方高于南方，城市高于农村。中国高脂血症的知晓率、就诊率和治疗率均低。
												由于血脂异常患者本身无任何症状，因此对治疗的依从性差。近年来，中国进行调脂治疗患者中的达标率仅为60%，不达标与停药、减药、漏药等相关。
												高脂血症是动脉粥样硬化、心血管疾病和脂肪肝发病的主因。心血管系统疾病发病率和死亡率第一且致残率高，积极治疗高脂血症是预防心血管疾病的重要手段。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												调脂药市场总体分析
											</div>
											<div class="h10"></div>
											<div class="smallText">
												中国调脂药物是所有心血管系统用药中惟一市场份额大且翻倍高速增长的药物。未来十年，随着高血脂患者增多，基本医疗保障制度的全面推进，治疗率增加，规范化诊疗及新药上市，调脂药市场规模将增长至500亿元以上，平均年复合增长率不低于18%，调脂药市场前景广阔，竞争也愈发激烈。
											</div>
											<div class="smallText">
												中国调脂药以医院市场为主，处方药为核心。化学药为主，中成药为辅的市场格局中，化学药占90%左右份额且还在不断增加。
												调脂药市场原研产品种类多，随着专利到期、效果和价格等因素，仿制药悄然崛起，厂家众多，竞争激烈，有效降低支付成本、扩大覆盖人群。调脂药市场集中于一线城市，市场品种较多但产品同质化程度高也相对集中。
												调脂药市场可分为他汀类药物为代表的降胆固醇药物市场和贝特类为代表的降甘油三酯药物市场。
												在以立普妥为代表的他汀类药物推出后，降胆固醇药物迅速主导调脂药市场。
												按照细分作用机理，国内主要的降脂药物进一步分为：他汀类、贝特类（苯氧芳酸类）、烟酸及其衍生物类、多烯脂肪酸类、天然来源类及其他类。
												调脂药市场份额排名靠前的药物均是他汀类，他汀类合计占比达80％以上；其次是占比不到10%的非特类；余下的份额主要由血脂康占据。未来他汀类药物的主导地位在短期内不会发生改变。
											</div>
										</div>
<!-- 										页脚 -->
										<jsp:include page="yejiao.jsp"/>
<!-- 										页眉 -->
										<jsp:include page="yemei.jsp"/>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1" style="padding-left: 0;">
											<div class="contentTitle">
												医院他汀类调脂药市场表现
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												医院市场总体表现
											</div>
											<div class="smallText">
												根据法伯科技(PHA)对我国他汀类调脂药医院市场的数据来看，2011-2016年，中国医院市场的<span class="biaozhuColor">他汀类调脂药市场</span>总体呈现上升趋势；
												未来调脂药总体市场仍会继续保持增长。
												<span class="biaozhuColor">2016年2月中国医院市场他汀类调脂药的年累计（MAT）达人民币100亿元，
												增长率达到<span class="biaozhuColor">X%</span>，此市场前景广阔。
											</div>
											<div class="h10"></div>
											<div class="text-center">
												<!-- <img src="../assets/images/reportimg/report01.png" width="600" height="300"/> -->
												<div id="yearBar" style="width: 600px;height: 400px;"></div>
											</div>
											<div class="text-center smallText">
												图1.<span class="biaozhuColor">MAT2012.2-MAT2016.2</span>中国医院<span class="biaozhuColor">他汀类调脂药年累计销售额</span>表现。
											</div>
											<div class="h10"></div>
											<!-- <div class="text-center">
												<img src="../assets/images/reportimg/report02.png" width="600" height="300"/>
											</div>
											<div class="text-center smallText">
												图1.<span class="biaozhuColor">MAT2012.2-MAT2016.2</span>中国医院<span class="biaozhuColor">他汀类调脂药年累计销售额</span>表现。
											</div> -->
											<div class="h10"></div>
											<div class="contentSubTitle">
												不同省份市场表现
											</div>
											<div class="smallText">
												国内的调脂药市场主要集中在几个一线城市，其中，北京、上海、广州是国内的三大降脂药市场，一线城市调脂药物品种齐全，竞争激烈。2011-2016年，
												<span class="biaozhuColor">A、B、C省份</span>医院<span class="biaozhuColor">他汀类调脂药市场</span>
												销售额复合增长率高达<span class="biaozhuColor">a%b%c%</span>，到2016年<span class="biaozhuColor">X、Y、Z</span>省份市场贡献率高达
												<span class="biaozhuColor">a%b%c%</span>。卫生支出居高的省份往往市场份额较高且增长潜力良好，各省<span class="biaozhuColor">他汀类调脂药市场</span>是以
												<span class="biaozhuColor">北京、上海、广东</span>的潜力更大，北方高于南方区域市场潜力，大城市集中的二级省份以较高增长率和财政支出未来增长潜力巨大。
												
											</div>
											<div class="h10"></div>
											<div class="text-center">
												<!-- <img src="../assets/images/reportimg/report03.png" width="600" height="300"/> -->
												<div id="yearScatter" style="width:600px; height: 400px"></div>
											</div>
											<div class="text-center smallText">
												图2.各省<span class="biaozhuColor">他汀类调脂药</span>医院市场份额占比和销售额复合增长率。
											</div>
											<div class="h10"></div>
											<div class="text-center">
												<!-- <img src="../assets/images/reportimg/report04.png" width="600" height="300"/> -->
												<div id="yearMapQlt" style="width:600px; height: 400px"></div>
											</div>
											<div class="text-center smallText">
												图3.各省<span class="biaozhuColor">他汀类调脂药</span>医院市场潜力地图。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												国内外产品竞争态势
											</div>
											<div class="smallText">
												外资合资企业在调脂药市场中处于优势地位。外资合资企业占据调脂药2/3的市场份额，其在三级医院的市场集中度更高。外企及合资企业因其专利药和成功的市场推广，占据主导地位。
												<span class="biaozhuColor">2011-2016年</span>，外资药物占<span class="biaozhuColor">他汀类调脂药</span>
												份额<span class="biaozhuColor">70%</span>以上，销售额占比呈现<span class="biaozhuColor">XX</span>趋势。
												到2016年，外资企业销售额达到<span class="biaozhuColor">xxx</span>亿元，销售额占比达到
												<span class="biaozhuColor">xxx</span>亿元，销售额占比达到<span class="biaozhuColor">x%</span>；国内企业销售额仅为<span class="biaozhuColor">xxx</span>亿元。
											</div>
											<div class="h10"></div>
											<div class="text-center">
												<!-- <img src="../assets/images/reportimg/report05.png" width="600" height="300"/> -->
												<div id="yearBarXse" style="width:600px; height: 400px"></div>
											</div>
											<div class="text-center smallText">
												图2.<span class="biaozhuColor">2011-2016年</span>，中国医院<span class="biaozhuColor">他汀类调脂药</span>外资/合资与内资企业销售表现。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												<span style="color: red;">他汀类</span>各通用名子类别市场分析
											</div>
											<div class="smallText">
												他汀类是羟甲基戊二酰辅酶A（HMG-CoA）还原酶抑制剂，主要降低LDL。
												他汀类是一线调脂药，因为其通过LDL，将调脂治疗与降低心血管风险紧密联系，借助心血管循证依据占据调脂药主流市场，从而占据调脂药市场的绝对主导。
												他汀类还可用于急性缺血性脑卒中后的神经保护，为他汀类药物进一步拓展了市场。
												目前，在我国销售的他汀类调血脂药物主要是阿托伐他汀、瑞舒伐他汀、辛伐他汀、普伐他汀钠、洛伐他汀和氟伐他汀等。
												除瑞舒伐他汀进入各省医保目录，其它产品均于2004年9月，进入了《国家基本医疗保险药品目录》乙类目录。
											</div>
											<div class="smallText">
												从各他汀类分子<span class="biaozhuColor">2011-2016年销售额</span>市场占有率来看，排名前三的他汀类分子种类为
												<span class="biaozhuColor">A、B和C</span>,分别在医院他汀类调脂药市场的<span class="biaozhuColor">销售额</span>
												占比分别为<span class="biaozhuColor">X%、X%和X%</span>。
												<div class="h10"></div>
												<p><span class="contentLi">阿托伐他汀：</span>自在中国上市以来，一路领先，在他汀类调脂药医院市场占有率迅速增加到<span class="biaozhuColor">60%</span>。</p>
												<p><span class="contentLi">瑞舒伐他汀：</span>其市场份额自上市迅速攀升，抢占了调脂药市场近 1/4 的市场份额，是调脂药中增长最快的药物。到<span class="biaozhuColor">2016年</span>已经占到他汀类调脂药<span class="biaozhuColor">x%</span>的市场份额。</p>
												<p><span class="contentLi">辛伐他汀：</span>自2012年销售排名逐渐下降，但较高的性价比，依然在市场占据重要地位，更适用于经济受限患者。到<span class="biaozhuColor">2016年</span>仍然占他汀类调脂药<span class="biaozhuColor">x%</span>的市场份额。</p>
												<p><span class="contentLi">普伐他汀：</span>市后表现突出，但自2012年销售额排序降至调脂药的第4位。到<span class="biaozhuColor">2016年</span>降至他汀类调脂药<span class="biaozhuColor">x%</span>的市场份额。</p>
												<p><span class="contentLi">洛伐他汀：</span>洛伐他汀类市场份额逐年下降至占整个调脂药市场的不足5%。到<span class="biaozhuColor">2016年</span>降至他汀类调脂药<span class="biaozhuColor">x%</span>的市场份额。</p>
												<p><span class="contentLi">氟伐他汀：</span>受其适应症限制，市场份额占比不高，到<span class="biaozhuColor">2016年</span>占到他汀类调脂药<span class="biaozhuColor">x%</span>的市场份额。</p>
											</div>
											<div class="h10"></div>
											<div class="text-center">
<!-- 												<img src="../assets/images/reportimg/report06.png" width="600" height="300"/> -->
												<div id="yearBarAtcXse" style="width:600px; height: 400px"></div>
											</div>
											<div class="text-center smallText">
												图5.<span class="biaozhuColor">2011-2016年</span>，各分子类别在医院他汀类调脂药市场销售额占比。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												**市场产品市场表现
											</div>
											<div class="smallText">
												他汀类调脂药市场有上百个产品，仿制药众多，竞争激烈。从每一类分子在市场上的产品所表现的销售情况来看：
											</div>
											<div class="smallText">
												他汀类调脂药市场有上百个产品，仿制药众多，竞争激烈。从每一类分子在市场上的产品所表现的销售情况来看：
											</div>
											<div class="smallText">
												<div class="h10"></div>
												<p><span class="contentLi">阿托伐他汀：</span>
													对HMG-CoA还原酶具有选择性强效抑制作用，半衰期长，治疗剂量（10～80 mg/d）下可显著减低TC及 LDL-C水平且安全性高。
													原研药是辉瑞公司的立普妥。立普妥上市后，逐步增加适应症以及更新使用方法，有效的维持了其稳定增长。
													立普妥在中国的专利已于2011底到期，更多仿制药进入市场，竞争激烈。以两个国产产品阿托伐他汀钙片（阿乐）和阿托伐他汀钙胶囊（尤佳）为代表，疗效与合资外资产品相差无几，每日服药费用相对较低，销售额逐步上升。
													阿托伐他汀的治疗费用相对较高，限制了其在低收入人群中的使用。但是仿制药众多，竞争中端市场。
													<div class="smallText">
														<span class="biaozhuColor">2016年</span>，此类药物中排名前三的品牌分别为<span class="biaozhuColor">ABC</span>，销售额分别是<span class="biaozhuColor">abc</span>，在他汀类调脂药医院市场的占比分别为<span class="biaozhuColor">xxx</span>。
													</div>
												</p>
												<p><span class="contentLi">瑞舒伐他汀：</span>
													原研药是阿斯利康于2006年在我国上市的可定。是第3代他汀类药物，因其作用强、使用剂量低（是阿托伐他汀的一半）、半衰期长、安全性高、药物相互作用少和费用较低等优点，被誉为“超级他汀”。
													另外，瑞舒伐他汀可以逆转动脉粥样硬化，从而有效用于心脑血管事件一、二级预防，未来市场前景光明。
													<div class="smallText">
														<span class="biaozhuColor">2016年</span>，此类药物中排名前三的品牌分别为<span class="biaozhuColor">ABC</span>，销售额分别是<span class="biaozhuColor">abc</span>，在他汀类调脂药医院市场的占比分别为<span class="biaozhuColor">xxx</span>。
													</div>
												</p>
												<p><span class="contentLi">辛伐他汀：</span>
													是治疗原发性高胆固醇血症的药物。辛伐他汀因其疗效确切、耐受性良好和治疗费用低廉，成为2009年版《国家基本药物目录》中唯一的调脂西药。上市较早的辛伐他汀由于致严重肌损害风险较高，使用明显受限。
													辛伐他汀在国内市场上的主要品牌是杭州默沙东的舒降之，专利于2005年12月到期，目前国内有京必舒新、辛可、西之达、幸露、泽之浩等30多家仿制药。
													<div class="smallText">
														<span class="biaozhuColor">2016年</span>，此类药物中排名前三的品牌分别为<span class="biaozhuColor">ABC</span>，销售额分别是<span class="biaozhuColor">abc</span>，在他汀类调脂药医院市场的占比分别为<span class="biaozhuColor">xxx</span>。
													</div>
												</p>
												<p><span class="contentLi">普伐他汀：</span>
													源于微生物，属亲水性他汀类药物，普伐他汀可显著降低LDL-C，调脂作用与辛伐他汀相当，可较少通过肝脏细胞色素P450酶系统代谢，药物相互作用较少。
													具有老年人口服吸收迅速、蛋白结合率低和不良反应少等特点。由日本三共制药株式会社研制，百时美施贵宝在国内商品名为“普拉固”来经营。普拉固占普伐他汀市场一半以上的份额，日本三共株式会社和上海三共制药公司分别占10%。
													仿制药众多且仿制药市场份额逐年缓慢增加，如北京诺华、北京双鹤、广州南新制药、海正药业（富利他之）、华北制药（福他宁）。
													<div class="smallText">
														<span class="biaozhuColor">2016年</span>，此类药物中排名前三的品牌分别为<span class="biaozhuColor">ABC</span>，销售额分别是<span class="biaozhuColor">abc</span>，在他汀类调脂药医院市场的占比分别为<span class="biaozhuColor">xxx</span>。
													</div>
												</p>
												<p><span class="contentLi">洛伐他汀：</span>
													是第一个他汀类，原研药是默克的美降脂。仿制药30家以上，主要生产厂家有北京生物化学制药厂、华北制药集团、扬子江药业和浙江瑞邦制药。
													<div class="smallText">
														<span class="biaozhuColor">2016年</span>，此类药物中排名前三的品牌分别为<span class="biaozhuColor">ABC</span>，销售额分别是<span class="biaozhuColor">abc</span>，在他汀类调脂药医院市场的占比分别为<span class="biaozhuColor">xxx</span>。
													</div>
												</p>
												<p><span class="contentLi">氟伐他汀：</span>
													是第二代全合成调血脂产品，水溶性，进入体内吸收后80%被代谢，经肠道排出体外，难以通过血脑屏障，对中枢系统影响小，未见组织残留，是治疗家族性高脂血症的药物。原研药是诺华公司的来适可，占氟伐他汀市场份额主导地位，但专利于2015年到期，仿制药不多，但也将分割部分市场。
													<div class="smallText">
														<span class="biaozhuColor">2016年</span>，此类药物中排名前三的品牌分别为<span class="biaozhuColor">ABC</span>，销售额分别是<span class="biaozhuColor">abc</span>，在他汀类调脂药医院市场的占比分别为<span class="biaozhuColor">xxx</span>。
													</div>
												</p>
											</div>
											<div class="h10"></div>
											<div class="text-center">
<!-- 												<img src="../assets/images/reportimg/report07.png" width="600" height="300"/> -->
												<div id="yearMiniUnitXseZb" style="width:600px;height: 400px"></div>
											</div>
											<div class="text-center smallText">
												图6. 2011-2016年<span class="biaozhuColor">阿托伐他汀</span>，类别中各产品医院市场的销售额及销售额在他汀类调脂药医院市场的占比。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												Top10 厂家
											</div>
											<div class="smallText">
												市场相对集中，2011-2016年，排名前十的公司为医院他汀类调脂药市场贡献销售额在<span class="biaozhuColor">x%</span>以上。
												跨国药企在医院他汀类调脂药市场占主导地位。到<span class="biaozhuColor">2016</span>年，排名前十的企业中，外资和合资企业多大<span class="biaozhuColor">x</span>家。
												其中最为突出的是<span class="biaozhuColor">xxx</span>公司，到<span class="biaozhuColor">2016</span>年，其他产品线丰富，产品多达<span class="biaozhuColor">xx</span>个，
												重磅集中，为医院他汀类调脂药市场贡献<span class="biaozhuColor">x%</span>的销售额，且增长率为<span class="biaozhuColor">x%</span>。<span class="biaozhuColor">2016</span>年，增长率最为迅速的公司为xxx，增长率高达<span class="biaozhuColor">x%</span>。
											</div>
											<div class="h10"></div>
											<div class="smallText">
												表1.<span class="biaozhuColor">2011-2016年</span>，中国他汀类调脂药TOP 10 厂家市场表现 □外资或合资公司 △ 国内公司。
											</div>
											<div class="text-center">
												<img src="../assets/images/reportimg/report08.png" width="600" height="300"/>
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												Top10 产品
											</div>
											<div class="smallText">
												品牌集中度较高，<span class="biaozhuColor">2011-2016年</span>，中国医院<span class="biaozhuColor">他汀类调脂药</span>TOP10的产品销售总额占到中国医院<span class="biaozhuColor">他汀类调脂药</span>市场的70%以上。
											</div>
											<div class="smallText">
												他汀类表现突出的品牌有辉瑞制药生产的阿托伐他汀钙片（立普妥）、阿斯利康的瑞舒伐他汀（可定）、默沙东的辛伐他汀片（舒降之）、诺华的氟伐他汀（来适可）、百时美施贵宝的普伐他汀（普拉固）、日本三共株式会社的普伐他汀（美百乐镇）和法国利博福尼制药的非诺贝特胶囊（力平之）等。到2016年，TOP10的产品中有<span class="biaozhuColor">x</span>家都为外资产品。
												<span class="biaozhuColor">A</span>公司的产品<span class="biaozhuColor">a</span>占<span class="biaozhuColor">他汀类调脂药</span>近<span class="biaozhuColor">30%</span>。
												到2016年，仅有<span class="biaozhuColor">3</span>家为国内企业的产品，分别为<span class="biaozhuColor">ABC</span>，占比总和为<span class="biaozhuColor">abc</span>。
											</div>
											<div class="h10"></div>
											<div class="text-center">
												<img src="../assets/images/reportimg/report09.png" width="600" height="300"/>
											</div>
											<div class="text-center smallText">
												图7.2011-2016年，中国他汀类调脂药医院市场TOP10品牌销售总额占比。
											</div>
											<div class="text-center">
												<img src="../assets/images/reportimg/report10.png" width="600" height="300"/>
											</div>
											<div class="text-center smallText">
												图8.2011-2016年，中国他汀类调脂药医院市场TOP10品牌销售总额占比。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												历年上市新产品市场表现
											</div>
											<div class="smallText">
												他汀类调脂药的每年新上市产品频率高，以<span class="biaozhuColor">xx</span>分子居多，以<span class="biaozhuColor">内资企业</span>居多。<span class="biaozhuColor">xxx</span>年推出新产品个数最多，达<span class="biaozhuColor">xx</span>个。
												<span class="biaozhuColor">Xx</span>年上市场的<span class="biaozhuColor">x</span>个新产品在上市后一年内累计销售额最高，达到<span class="biaozhuColor">xx</span>亿元。
											</div>
											<div class="h10"></div>
											<div class="text-center">
												<img src="../assets/images/reportimg/report11.png" width="600" height="300"/>
											</div>
											<div class="text-left smallText">
												图9.<span class="biaozhuColor">2011-2016年</span>，他汀类调脂药新产品当年上市数量及当年上市后一年累计销售额。
											</div>
											<div class="h10"></div>
											<div class="text-left smallText">
												表2.<span class="biaozhuColor">2011-2016年</span>，上市新产品列表。
											</div>
											<div class="text-center">
												<img src="../assets/images/reportimg/report12.png" width="600" height="300"/>
											</div>
										</div>
										<div class="h10"></div>
										<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1" style="padding-left: 0;">
											<div class="contentTitle">
												市场需求和机遇
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												提高知晓率，治疗率和依从性
											</div>
											<div class="smallText">
												晓率低、就诊率低、依从性差是目前该治疗领域发展最大的障碍。正确调脂理念在基层和非专科医生群体的普及是当下和未来中国调脂领域的关键。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												关注年轻化的患者群体
											</div>
											<div class="smallText">
												高脂血症患病率呈年轻化趋势，原因在于青年人面临巨大的工作和生活压力、饮食不合理及缺乏运动，使超重和肥胖严重，也增加了高脂血症患者。高脂血症患者应注重改善饮食结构、加强运动，必要时进行药物治疗。而医疗行业也应该投注更多关注在年轻化的患者群体。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												调脂治疗理念革新，预防为主，个性化治疗
											</div>
											<div class="smallText">
												医师应重视治疗性生活方式改变（TLC）的重要性，不过分依赖药物治疗。加强健康生活的宣教，建议患者减少摄入动物性脂肪和胆固醇，多运动，对超重或肥胖的患者应鼓励其减轻体质量。根据患者的具体情况制订个体化的治疗方案。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												在研新药丰富，新型调脂药应继续关注对心血管系统的积极作用
											</div>
											<div class="smallText">
												降脂药已经成为现代药物研究的重点。目前，调脂药物很大程度上能满足临床调脂需求，但在进一步降低LDL，升高HDL，有效治疗家族性高血脂症这三方面，仍有空间，这也给在研的新药带来机会。
											</div>
											<div class="smallText">
												降低 LDL方面：针对更强效、更安全耐受以及和他汀联用等方面着力。如，PCSK9抑制剂目前是一个热点，在研新药有: 安进的Evolocumab、赛诺菲的Alirocumab和辉瑞的Bococizumab。
											</div>
											<div class="smallText">
												升高HDL方面：在研药物包括CETP抑制剂、Apo合成肽等。
											</div>
											<div class="smallText">
												有效治疗家族性高血脂症方面：如已经在美国上市的Lomitapide (Aegerio)和Mipomersen (ISIS) ，适应症的区别使得它们能够与他汀类进行错位竞争。
											</div>
											<div class="smallText">
												未来十年，中国调脂市场仍更青睐有益于心血管系统的药物，或更好降低LDL的新药。从在研新药看，关注于他汀类药物无法企及的病人群，比如未满足治疗需求的难治性血脂异常或他汀不耐受患者。而证明对心血管疾病的积极作用是跟随最新治疗理念，进入主市场，迅速占据市场份额的关键。
											</div>
											<div class="h10"></div>
											<div class="contentSubTitle">
												联合用药为治疗提供更多选择
											</div>
											<div class="smallText">
												高血脂症也是一种综合性疾病，单独用药往往不能达到非常理想的治疗效果，合理的联合用药是非常不错的选择。企业间也应竞争与合作共存。
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- <div class="more-box">
								<a class="more-btn" href="#">More</a>
							</div> -->
							<div class="presentation-right">
								<a href="index2.jsp">显示市场数据</a> <a href="#">导出报告</a>
							</div>
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
	
	<script src="../assets/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="../assets/js/Select2/select2.js"></script>
	<script type="text/javascript" src="../assets/js/Select2/zh-CN.js"></script>
<!-- 	<script src="../assets/js/bootstrap/bootstrap-select.min.js" type="text/javascript"></script> -->
	<script src="../assets/js/bootstrap/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<script src="../assets/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	<script src="../assets/js/common.js" type="text/javascript"></script>
	<script src="../assets/js/eachars3.0/echarts.js" type="text/javascript"></script>
	<script src="../assets/js/eachars3.0/map/china.js" type="text/javascript"></script>
	<script src="../assets/js/eachars3.0/config.js" type="text/javascript"></script>
	<script src="../assets/js/report.js" type="text/javascript"></script>
	<script src="../assets/js/left.js" type="text/javascript"></script>
	<script type="text/javascript">
		var pageTypeIndex="reportPage";
		$(document).ready(function(){
			/* $("#ATC").change(function(){
				console.info($(this).val());
			}); */
			$('#timeTab a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			});
			
			
		});
	</script>
</body>
</html>