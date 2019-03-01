# 1. {}直接定义：类似json的定义
hash={
	"baidu":'李彦宏',
	"taobao":'马云',
	"qq":'马化腾',
}

print(hash['baidu']);

# 2. dict函数定义：构造函数式定义
d = dict(name='Bob', age=20, score=88)
print(d)

# 或者键值对构建dict
student=[('name', 'Tom'), ("number",1002),('score', 95)]
student2=dict(student)
print(type(student),student)
print(type(student2),student2)

# 计算键值对个数
print( len(student) )


#访问不存在的元素
#print("不存在的元素：",student2['gender']) #KeyError: 'gender'
rs=student2.get('gender')
print('不存在的元素：', rs) # None

