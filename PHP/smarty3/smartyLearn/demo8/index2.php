<?php
//引入配置文件
require('smarty.inc.php');

// clear only cache for index.tpl
//$_smarty->clearCache('demo8.tpl');

// clear out all cache files
$_smarty->clearAllCache(5);

//打印
//$_smarty->display('demo8.tpl',$_SERVER['REQUEST_URI']);