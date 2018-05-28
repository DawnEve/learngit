# 返回函数，可以实现预定义

def getSpliter(pattern):
    #内函数能对外函数（不是在全局作用域）的变量进行引用，内部函数就被认为是闭包
    def split_str(str):
        import re;
        return re.split(pattern,str);
    return split_str;#返回的是内函数

# 定制化spliter
spliter_tab=getSpliter(r'\t')
spliter_e=getSpliter(r'e')

# 使用spliter
print(spliter_tab)
s2="name\tage\tgrade\tgender";
print(spliter_tab(s2))
print(spliter_e(s2))
