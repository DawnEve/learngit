#可以有多个except来捕获不同类型的错误：

try:
    print('try...')
    r = 10 / int('a')
    print('result:', r)
except ValueError as e:
    print('ValueError:', e)
except ZeroDivisionError as e:
    print('ZeroDivisionError:', e)
finally:
    print('finally...')
print('END')

#################
# 还可以一个except捕获多个异常类型
def demo_ex(x,y):
    try:
        b=name
        a=x/y
    except (ZeroDivisionError, NameError, TypeError) as e:
        print('\none of ZeroDevisionError, NameError or TypeError: ==> ',e)
demo_ex(2,0)