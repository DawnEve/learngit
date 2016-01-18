<?php
//引入配置文件
require('smarty.inc.php');
//global $_smarty;//这个貌似没啥用

//定义变量
//$a='12';
//注册变量
$_smarty->assign( 'width', 10 );
$_smarty->assign( 'height', 20 );

//打印
$_smarty->display('demo3.tpl');