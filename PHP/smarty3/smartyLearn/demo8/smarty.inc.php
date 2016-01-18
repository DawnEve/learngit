<?php
//创建实际路径
define('ROOT_PATH',dirname( __FILE__ ));//F:\xampp\htdocs\smartyLearn

require(ROOT_PATH . '/../smarty3/Smarty.class.php');
//实例化
$_smarty=new Smarty();

//模板文件路径
$_smarty->template_dir=ROOT_PATH . '/templates/';
//编译目录
$_smarty->compile_dir=ROOT_PATH . '/templates_c/';
//配置文件目录
$_smarty->config_dir=ROOT_PATH . '/configs/';
//缓存目录
$_smarty->cache_dir=ROOT_PATH . '/cache/';

//是否开启缓存
$_smarty->caching=1;

//左右定界符
$_smarty->left_delimiter='{';//'<!--{'
$_smarty->right_delimiter='}';//'}-->'