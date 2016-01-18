<?php
//引入配置文件
require('smarty.inc.php');
//global $_smarty;//这个貌似没啥用


//设置时区
date_default_timezone_set('PRC');

//定义变量

//注册变量
$_smarty->assign('cust_ids', array(1000,1001,1002,1003));
$_smarty->assign('cust_names', array(
		'Joe Schmoe',
		'Jack Smith',
		'Jane Johnson',
		'Charlie Brown')
	);
$_smarty->assign('customer_id', 1001);

//打印
$_smarty->display('demo4.tpl');