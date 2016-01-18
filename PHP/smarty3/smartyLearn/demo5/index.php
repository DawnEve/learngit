<?php
//引入配置文件
require('smarty.inc.php');
//global $_smarty;//这个貌似没啥用

// 给贮存的插件添加目录 
$_smarty->addPluginsDir('./plugins_1');

//查看插件目录链
//var_dump($_smarty->getPluginsDir());

//以插件形式定义的块
$_smarty->assign('age',10);

//打印
$_smarty->display('demo5.tpl');