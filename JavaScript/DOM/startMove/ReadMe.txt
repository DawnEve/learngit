jQ动画案例 往上飞
1. 基础 basic
获取样式 -> basic1.html 字体变大 startMove()
透明度动画 -> basic2.html 透明度变化函数，基础。全局定时器。startMove(iTarget)
速度动画 -> basic3.html 左边距的变动，基础。全局定时器。startMove(iTarget)
缓冲动画 -> basic4.html 左边距的变动，基础。全局定时器。速度做了缓冲。startMove(iTarget)



2. 进阶 mid: 多物体时，全局定时器会互相干扰，只能绑定到obj上
多物体动画 -> mid1.html 多物体的运动，定时器加到obj上。不透明度变化函数startMove2(obj,iTarget)，像素变化函数startMove(obj,iTarget)。定时器绑定到obj.
任意属性 -> mid2.html 不透明度、长度变化。定时器绑定到obj. startMove(obj,attr,iTarget)



3. 高级 adv: 链式运动(传入回调函数，或返回this值)，同时运动(传入json多目标)
链式动画 -> adv1.html 传入运动fn当参数。定时器绑定到obj上。startMove(obj,attr,iTarget,fn)
同时运动 -> adv2.html 传入json目标属性。 startMove(obj,json,fn)
完美运动框架 -> adv3.html  startMove(obj,json,fn)



案例
抛物线运动从鼠标位置到购物车
https://www.jb51.net/article/134009.htm




更多js动画 https://www.jb51.net/Special/462.htm
move.js 库: https://github.com/visionmedia/move.js


