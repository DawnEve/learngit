<?php 

function smarty_block_info2($params, $content)
{
	$str="<p style='color:{$params['color']};background:{$params['background']}'>{$content}</p>";
	return $str;
}