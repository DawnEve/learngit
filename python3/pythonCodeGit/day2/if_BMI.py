#计算体重指标

height = input('请输入您的身高（单位/米）：')
weight = input('请输入您的体重（单位/千克）：')

h = float(height)
w = float(weight)

bmi = w/(h*h)

if bmi > 32:
    print('您的BMI指数是%.1f，' %bmi,'严重肥胖。')
elif bmi > 28:
    print('您的BMI指数是%.1f，' %bmi,'肥胖。')
elif bmi > 25:
    print('您的BMI指数是%.1f，' %bmi,'过重。')
elif bmi > 18.5:
    print('您的BMI指数是%.1f，' %bmi,'正常。')
else:
    print('您的BMI指数是%.1f，' %bmi,'过轻。')