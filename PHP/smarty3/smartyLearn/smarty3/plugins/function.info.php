<?php 

function smarty_function_info($params)
{
		//为了相应不同参数个数，应用很多if
		$str='';
		if(isset($params['age'])){
			$str .= '您的年龄是：'.$params['age'];
		}
		if(isset($params['weight'])){
			$str .= '您的体重是：'.$params['weight'];
		}
		return $str;
}