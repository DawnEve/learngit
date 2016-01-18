<?php
//引入配置文件
require('smarty.inc.php');
//global $_smarty;//这个貌似没啥用

//定义php自定义函数
//模板中传入的参数被转化为关联数组
function block_info($_arr,$_content){
	//为了相应不同参数个数，应用很多if
	$str="<p style='color:{$_arr['color']};background:{$_arr['background']}'>{$_content}</p>";
	return $str;
}

//注册插件
$_smarty->registerPlugin('block','info', 'block_info');
/*
void registerPlugin(string type, string name, mixed callback, bool cacheable, mixed cache_attrs);
本方法在脚本中注册函数或方法作为插件。其参数如下： 
	“type”定义插件的类型，其值为下列之一：“function”、“block”、“compiler”和“modifier”； 
	“name”定义插件的函数名； 
	“callback”为定义的php回调函数，其类型为下列之一：
		1、包含函数名的字符串；
		2、格式为(&$object, $method)的数组，其中，&$object为引用对象，$method为包含方法名的字符串；
		3、格式为($class, $method)的数组，其中，$class为类名，$method为类中的方法。 
*/

//打印
$_smarty->display('demo5.tpl');