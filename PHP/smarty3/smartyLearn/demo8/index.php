<?php
//引入配置文件
require('smarty.inc.php');

//开启单页面缓存
$_smarty->caching=2;

//设置缓存周期10s
$_smarty->setCacheLifetime(10);
//echo $_smarty->getCacheLifetime();

//是否存在不过期的缓存？
if(!$_smarty->isCached('demo8.tpl',$_SERVER['REQUEST_URI'])) {
	//无有效缓存则进行php操作
	$mypage=$_GET['p'];

	$_smarty->assign('page',$mypage);
	$_smarty->assign('num',1);//这个是缓存的变量
}

//自定义模板块
function no_cache($arr,$content){
	return $content;
}
//注册自定义模板块
$_smarty->registerPlugin('block','nocache2','no_cache',false);

//打印
$_smarty->display('demo8.tpl',$_SERVER['REQUEST_URI']);