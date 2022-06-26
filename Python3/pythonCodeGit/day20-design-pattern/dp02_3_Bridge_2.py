# 桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。
# 它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。

# 画笔 颜色5 和 粗细3 共15种组合。
# 如果使用彩笔，需要15个类；如果使用毛笔，则分离了 笔头和颜料，只需要5+3+1=9个类

# 这是抽象画笔类
class BrushPenAbstraction:
    colorImp=None; #对颜色的引用
    def setImplementorColor(self, colorImp):
        self.colorImp=colorImp

## 粗画笔
class BigBrushPen(BrushPenAbstraction):
    def operationDraw(self):
        print("Big and "+self.colorImp.getColor()+ " drawing!")


# 颜色接口
class ImplementorColor:
    color=None;
## 红色的实现
class ColorRed(ImplementorColor):
    color="red"
    
    def getColor(self):    
        return self.color

# 客户端
bigPen=BigBrushPen()

col=ColorRed()
bigPen.setImplementorColor(col)
bigPen.operationDraw()

print('='*20)
################
## 新定义蓝色
class ColorBlue(ImplementorColor):
    color="blue"
    
    def getColor(self):    
        return self.color
col2=ColorBlue()
bigPen.setImplementorColor(col2)
bigPen.operationDraw()
#
################
## 新定义细画笔
class SmallBrushPen(BrushPenAbstraction):
    def operationDraw(self):
        print("Small and "+self.colorImp.getColor()+ " drawing!")
smallPen=SmallBrushPen()
smallPen.setImplementorColor(col2)
smallPen.operationDraw()
#


