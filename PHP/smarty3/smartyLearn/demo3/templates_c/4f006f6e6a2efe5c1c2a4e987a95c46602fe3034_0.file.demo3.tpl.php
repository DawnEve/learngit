<?php
/* Smarty version 3.1.30-dev/18, created on 2016-01-08 04:34:00
  from "F:\xampp\htdocs\smartyLearn\demo3\templates\demo3.tpl" */

if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'has_nocache_code' => false,
  'version' => '3.1.30-dev/18',
  'unifunc' => 'content_568f2e289f8965_85125982',
  'file_dependency' => 
  array (
    '4f006f6e6a2efe5c1c2a4e987a95c46602fe3034' => 
    array (
      0 => 'F:\\xampp\\htdocs\\smartyLearn\\demo3\\templates\\demo3.tpl',
      1 => 1452224037,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_568f2e289f8965_85125982 ($_smarty_tpl) {
if (!is_callable('smarty_function_mailto')) require_once 'F:\\xampp\\htdocs\\smartyLearn\\smarty3\\plugins\\function.mailto.php';
?>
<meta charset='utf-8'>

<?php echo smarty_function_mailto(array('address'=>"me@example.com",'text'=>"send me some mail"),$_smarty_tpl);?>


<a href="mailto:me@example.com" >send me some mail</a>








<?php }
}
