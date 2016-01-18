<?php 
function smarty_modifier_zw_truncate($string, $length, $encoding)
{
	if(mb_strlen($string)<$length){
		return mb_substr($string,0,$length,$encoding);
	}else{
		return mb_substr($string,0,$length,$encoding) . '...';
	}

}