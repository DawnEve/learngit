<?php
/* Smarty version 3.1.30-dev/18, created on 2016-01-17 11:23:22
  from "F:\xampp\htdocs\smartyLearn\demo6\templates\demo6.tpl" */

if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'has_nocache_code' => false,
  'version' => '3.1.30-dev/18',
  'unifunc' => 'content_569b6b9ad736d2_72861790',
  'file_dependency' => 
  array (
    '7a21de8a7f680a7c57c9b8ed988595bd17b1cfd2' => 
    array (
      0 => 'F:\\xampp\\htdocs\\smartyLearn\\demo6\\templates\\demo6.tpl',
      1 => 1453026201,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_569b6b9ad736d2_72861790 ($_smarty_tpl) {
if (!is_callable('smarty_modifier_zw_truncate')) require_once 'F:\\xampp\\htdocs\\smartyLearn\\demo6\\myPlugin\\modifier.zw_truncate.php';
?>
<meta charset='utf-8'>

<p><?php echo $_smarty_tpl->tpl_vars['text']->value;?>
</p>
<p><?php echo smarty_modifier_zw_truncate($_smarty_tpl->tpl_vars['text']->value,20,'utf-8');?>
</p>















<?php }
}
