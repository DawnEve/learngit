<?php
/* Smarty version 3.1.30-dev/18, created on 2016-01-18 08:12:30
  from "F:\xampp\htdocs\smartyLearn\demo7\templates\demo7.tpl" */

if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'has_nocache_code' => false,
  'version' => '3.1.30-dev/18',
  'unifunc' => 'content_569c905ee55251_60542310',
  'file_dependency' => 
  array (
    '97e9f8dbdcd399fd791f25f4ce4195e34fe39e1e' => 
    array (
      0 => 'F:\\xampp\\htdocs\\smartyLearn\\demo7\\templates\\demo7.tpl',
      1 => 1453101150,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_569c905ee55251_60542310 ($_smarty_tpl) {
?>
<meta charset='utf-8'>

<?php
$__section_arr2_0_saved = isset($_smarty_tpl->tpl_vars['__smarty_section_arr2']) ? $_smarty_tpl->tpl_vars['__smarty_section_arr2'] : false;
$__section_arr2_0_loop = (is_array(@$_loop=$_smarty_tpl->tpl_vars['myarray']->value) ? count($_loop) : max(0, (int) $_loop));
$__section_arr2_0_total = $__section_arr2_0_loop;
$_smarty_tpl->tpl_vars['__smarty_section_arr2'] = new Smarty_Variable(array());
if ($__section_arr2_0_total != 0) {
for ($__section_arr2_0_iteration = 1, $_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index'] = 0; $__section_arr2_0_iteration <= $__section_arr2_0_total; $__section_arr2_0_iteration++, $_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index']++){
?>
	<?php echo $_smarty_tpl->tpl_vars['myarray']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index'] : null)]["id"];?>
:<?php echo $_smarty_tpl->tpl_vars['myarray']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index'] : null)]["product"];?>
 |||
	<?php echo $_smarty_tpl->tpl_vars['myarray']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index'] : null)]['id'];?>
:<?php echo $_smarty_tpl->tpl_vars['myarray']->value[(isset($_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index']) ? $_smarty_tpl->tpl_vars['__smarty_section_arr2']->value['index'] : null)]['product'];?>
<br>
<?php
}
}
if ($__section_arr2_0_saved) {
$_smarty_tpl->tpl_vars['__smarty_section_arr2'] = $__section_arr2_0_saved;
}
?>

<?php }
}
