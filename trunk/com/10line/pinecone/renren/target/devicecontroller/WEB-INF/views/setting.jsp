﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"  href="css/style.css">
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/tanchu.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	
	$(".showbox").click(function(){
		$("#TB_overlayBG").css({
			display:"block",height:$(document).height()
		});
		$(".box").css({
			left:($("body").width()-$(".box").width())/2-20+"px",
			top:($(window).height()-$(".box").height())/2+$(window).scrollTop()+"px",
			display:"block"
		});
	});
	
	$(".close").click(function(){
		$("#TB_overlayBG").css("display","none");
		$(".box ").css("display","none");
	});
	
})
</script>

<title>松果后台</title>
</head>
<body>
<div class="mian">
  <div class="title"></div>
  <div class="content">
    <div class="left">
      <ul class="navlist">
        <li class="top"> 设备信息参数 </li>
        <li><a id="List_devices" href="devices.html">设备列表</a></li>
        <li><a style="background: url(images/select_bg.jpg) no-repeat 0 0px; color: #fff;" id="Device_parameters" href="setting.html">设备参数</a></li>
        <li><a href="user.html">用户信息</a></li>
      </ul>
    </div>
    <div class="right">
            <div class="Guide"><p>控制台 ><a href="#">基本信息管理</a></p><span><a href="login.html">注销</a></span></div>
      <div class="name">
        <p>设备参数</p>
        <div class="timing"><a href="#"><img src="images/timing.jpg" /></a></div>
      </div>
      <table style="text-align: center;"width="980" cellpadding="0" cellspacing="0">
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6;  background: url(images/table_top.jpg) repeat-x;"><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; background: url(images/table_top.jpg) repeat-x; text-align: left;">用户姓名</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6; background: url(images/table_top.jpg) repeat-x;">邮件</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;   background: url(images/table_top.jpg) repeat-x;">好友列表</td>
          <td height="45" colspan="2" style="border-bottom: 1px solid #c6c6c6;  background: url(images/table_top.jpg) repeat-x; text-align: left;">&nbsp;</td>
          </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td width="157" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6; ">
          	<img class="showbox" src="images/speaker_se.jpg" />

	<div id="TB_overlayBG" class="close"></div>
	<div class="box" style="display:none">
    
    <img src="images/music.gif" />
	</div>
          
          
          
          
          </td>
          <td width="226" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;  ">
          	<img class="popbox-link" src="images/Video.jpg" />
            <div class="close-btn" id="screen"></div>
<div class="popbox">
<img src="images/voide.gif" />
</div>
            
          </td>
          <td width="268" style="border-bottom: 1px solid #c6c6c6; text-align: left; padding-left: 20px;"></td>
        </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
        </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
        </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
        </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
        </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
        </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
        </tr>
        <tr>
          <td width="68" height="45" style="border-bottom: 1px solid #c6c6c6; "><input type="checkbox" value="checkbox"></td>
          <td width="87" height="45" style="border-bottom: 1px solid #c6c6c6; text-align: left;">机器猫</td>
          <td width="172" height="45" style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">Arek_kajda@gmail.com</td>
          <td style="border-bottom: 1px solid #c6c6c6; border-left: 1px solid #c6c6c6;">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
          <td height="45" style="border-bottom: 1px solid #c6c6c6; ">&nbsp;</td>
        </tr>
      </table>
            <div class="page_list">
            	<ul>
                	<li><a href="#"><img src="images/page_down.jpg" /></a></li>
                	<li><a href="#">4</a></li>
                	<li><a href="#">3</a></li>
                	<li><a href="#">...</a></li>
                	<li><a href="#">2</a></li>
                	<li><a href="#">1</a></li>
                	<li><a href="#"><img src="images/page_up.jpg" /></a></li>
                </ul>
            </div>
    </div>
  </div>
</div>
</body>
</html>
