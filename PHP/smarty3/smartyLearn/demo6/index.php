<?php
//引入配置文件
require('smarty.inc.php');
//global $_smarty;//这个貌似没啥用

// 给贮存的插件添加目录 
$_smarty->addPluginsDir('./myPlugin');

//查看插件目录链
//var_dump($_smarty->getPluginsDir());


//赋值
$name='   听说<b>Smarty3</b>比老版本好用。  不知道change有多大.   Any one who can give me a list.';
$_smarty->assign('text',$name);


//打印
$_smarty->display('demo6.tpl');