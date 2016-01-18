<?php
/* Smarty version 3.1.30-dev/18, created on 2016-01-18 10:36:07
  from "F:\xampp\htdocs\smartyLearn\demo8\templates\demo8.tpl" */

if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'has_nocache_code' => true,
  'version' => '3.1.30-dev/18',
  'unifunc' => 'content_569cb207b5ada2_56308384',
  'file_dependency' => 
  array (
    '2704c6e714c60051fbe8217858332a8b7069aaad' => 
    array (
      0 => 'F:\\xampp\\htdocs\\smartyLearn\\demo8\\templates\\demo8.tpl',
      1 => 1453108985,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_569cb207b5ada2_56308384 ($_smarty_tpl) {
echo '/*%%SmartyNocache:4371569cb207af9309_87024604%%*/<?php $_smarty = $_smarty_tpl->smarty; if (!is_callable(\'smarty_modifier_date_format\')) require_once \'F:\\\\xampp\\\\htdocs\\\\smartyLearn\\\\smarty3\\\\plugins\\\\modifier.date_format.php\';
?>/*/%%SmartyNocache:4371569cb207af9309_87024604%%*/';
$_smarty_tpl->compiled->nocache_hash = '4371569cb207af9309_87024604';
?>
<meta charset='utf-8'>

<?php echo $_smarty_tpl->tpl_vars['num']->value;?>
 | <?php echo $_smarty_tpl->tpl_vars['page']->value;?>

<?php echo '/*%%SmartyNocache:4371569cb207af9309_87024604%%*/<?php $_block_plugin1 = isset($_smarty_tpl->smarty->registered_plugins[\'block\'][\'nocache2\'][0]) ? $_smarty_tpl->smarty->registered_plugins[\'block\'][\'nocache2\'][0] : null;
if (!is_callable($_block_plugin1)) {
throw new SmartyException(\'block tag \\\'nocache2\\\' not callable or registered\');
}
$_block_repeat1=true;
echo $_block_plugin1(array(), null, $_smarty_tpl, $_block_repeat1);
while ($_block_repeat1) {
ob_start();
?>
/*/%%SmartyNocache:4371569cb207af9309_87024604%%*/';?>

	[<?php echo '/*%%SmartyNocache:4371569cb207af9309_87024604%%*/<?php echo smarty_modifier_date_format(time(),"%H:%M:%S");?>
/*/%%SmartyNocache:4371569cb207af9309_87024604%%*/';?>
]
<?php echo '/*%%SmartyNocache:4371569cb207af9309_87024604%%*/<?php $_block_repeat1=false;
echo $_block_plugin1(array(), ob_get_clean(), $_smarty_tpl, $_block_repeat1);
}
?>
/*/%%SmartyNocache:4371569cb207af9309_87024604%%*/';?>

 

<?php }
}
