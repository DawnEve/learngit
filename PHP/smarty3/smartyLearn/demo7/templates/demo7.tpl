<meta charset='utf-8'>

{section name=arr2 loop=$myarray}
	{$myarray[arr2]["id"]}:{$myarray[arr2]["product"]} |||
	{$myarray[arr2].id}:{$myarray[arr2].product}<br>
{/section}

