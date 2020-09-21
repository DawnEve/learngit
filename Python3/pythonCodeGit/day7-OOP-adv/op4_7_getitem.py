class Foo:
    def __init__(self,name):
        self.name=name
 
    def __getitem__(self, item):
        print(self.__dict__[item])
 
    def __setitem__(self, key, value):
        print('  set obj[key]时,我执行')
        self.__dict__[key]=value
    def __setattr__(self, key, value):
        print('  set obj.key时,我执行')
        self.__dict__[key]=value
    
    def __delitem__(self, key):
        print('del obj[key]时,我执行')
        self.__dict__.pop(key)
    def __delattr__(self, item):
        print('del obj.key时,我执行')
        self.__dict__.pop(item)
 
f1=Foo('sb')
f1.age=18
f1['age1']=19
print(f1.__dict__)

del f1.age1
del f1['age']

f1['name']='alex'
print(f1.__dict__)