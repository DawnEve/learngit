<?php
/* Smarty version 3.1.30-dev/18, created on 2016-01-17 09:42:29
  from "F:\xampp\htdocs\smartyLearn\demo5\templates\demo5.tpl" */

if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'has_nocache_code' => false,
  'version' => '3.1.30-dev/18',
  'unifunc' => 'content_569b53f5a59968_70015168',
  'file_dependency' => 
  array (
    'fee1e83d38cbcf94a7d6734237daec0170d8bd83' => 
    array (
      0 => 'F:\\xampp\\htdocs\\smartyLearn\\demo5\\templates\\demo5.tpl',
      1 => 1453019731,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_569b53f5a59968_70015168 ($_smarty_tpl) {
if (!is_callable('smarty_block_info2')) require_once 'F:\\xampp\\htdocs\\smartyLearn\\demo5\\plugins_1\\block.info2.php';
?>
<meta charset='utf-8'>

<?php $_block_repeat1=true;
echo smarty_block_info2(array('color'=>'white','background'=>'red'), null, $_smarty_tpl, $_block_repeat1);
while ($_block_repeat1) {
ob_start();
?>

	your age is <?php echo $_smarty_tpl->tpl_vars['age']->value;?>

<?php $_block_repeat1=false;
echo smarty_block_info2(array('color'=>'white','background'=>'red'), ob_get_clean(), $_smarty_tpl, $_block_repeat1);
}
?>


<?php }
}
