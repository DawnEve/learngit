<?php
//引入配置文件
require('smarty.inc.php');
//global $_smarty;//这个貌似没啥用

//赋值
$arr=array(
	array('id'=>'10','product'=>'apple'),
	array('id'=>'20','product'=>'boy'),
	array('id'=>'30','product'=>'cat'),
	array('id'=>'40','product'=>'dog'),
);
$_smarty->assign('myarray',$arr);

//打印
$_smarty->display('demo7.tpl');