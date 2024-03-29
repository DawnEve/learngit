# Strategy
# 策略（Strategy）模式 :定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。

"""http://stackoverflow.com/questions/963965/how-is-this-strategy-pattern-written-in-python-the-sample-in-wikipedia

In most of other languages Strategy pattern is implemented via creating some base strategy interface/abstract class and
subclassing it with a number of concrete strategies (as we can see at http://en.wikipedia.org/wiki/Strategy_pattern),
however Python supports higher-order functions and allows us to have only one class and inject functions into it's
instances, as shown in this example.
"""

import types

class StrategyExample:
    def __init__(self, func=None):
        self.name = 'Strategy Example 0'         
        if func is not None:
            self.execute = types.MethodType(func, self)      

    def execute(self):         
        print('Original: ' + self.name+" is running...")   


def execute_replacement1(self):
    print('from out1: '+self.name + ' from execute 1')   


def execute_replacement2(self):
    print('from out2: '+self.name + ' from execute 2')  


if __name__ == '__main__':
    strat0 = StrategyExample()     

    strat1 = StrategyExample(execute_replacement1) #传入策略 函数
    strat1.name = 'Strategy Example 1'     

    strat2 = StrategyExample(execute_replacement2)
    strat2.name = 'Strategy Example 2'

    strat0.execute()
    strat1.execute()     
    strat2.execute()