<?php
//引入配置文件
require('smarty.inc.php');
//global $_smarty;//这个貌似没啥用

//定义变量
define('PI', 3.1415926);

//注册变量
//$_smarty->assign('a',$a);


//打印
$_smarty->display('demo2.tpl');