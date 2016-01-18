<?php
//引入配置文件
require('smarty.inc.php');


//定义变量
$myName='Dawn8';

//注册变量
$_smarty->assign('name',$myName);

//打印
$_smarty->display('demo1.tpl');