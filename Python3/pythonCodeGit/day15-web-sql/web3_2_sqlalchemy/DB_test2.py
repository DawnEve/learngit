################### 1. get engine
from sqlalchemy import create_engine

# https://www.jianshu.com/p/47c1c2618812
from sqlalchemy.ext.declarative import declarative_base 
from sqlalchemy import Column, Integer, String ,DateTime, Boolean

# 连接数据库
#engine = create_engine('mysql://root:password@localhost:3306/test?charset=utf8')
engine = create_engine('mysql+pymysql://root:@localhost:3306/test?charset=utf8') #加这一句，防止中文乱码1/2
#engine = create_engine('mysql+pymysql://root:@localhost:3306/test')

## 编码问题
## 获取基类
Base = declarative_base()

class News(Base): # 继承基类
    __tablename__ = 'students1'
    id = Column(Integer, primary_key = True)
    nickname = Column(String(20))
    name = Column(String(20), nullable = False)
    sex = Column(String(10))
    in_time = Column(DateTime)
    is_vaild = Column(Boolean)
    idcard = Column(Integer, unique = True)
    
    __table_args__ = {
        "mysql_charset": "utf8" #加这一句，防止中文乱码2/2
    }
#


News.metadata.create_all(engine)   # 创建表格



################### 2. get session
## 新增数据
from sqlalchemy.orm import sessionmaker
Session = sessionmaker(bind=engine)

class OrmTest(object):
    def __init__(self):
        self.session = Session()

    def add_one(self):
        new_obj = News(
            nickname = '123',
            name = '321',
            sex = '男',
        )
        self.session.add(new_obj)
        self.session.commit()
        return new_obj

    def add_more(self):
        new_obj = News(
            nickname = '123',
            name = '321',
            sex = '男',
        )
        new_obj2 = News(
            nickname = 'wei',
            name = 'lai',
            sex = '女',
        )
        self.session.add_all([new_obj, new_obj2])
        self.session.commit()
        return new_obj

    ## 查询数据        
    def get_one(self, n=1):
        return self.session.query(News).get(n)  # get 是选id为2的

    def get_more(self):
        #return self.session.query(News).filter_by(is_vaild=True)
        return self.session.query(News).filter_by(is_vaild=0)


    ## 修改数据
    ## 将一条当作多条的一种情况
    def update_data(self):
        data_list = self.session.query(News).filter(News.id >= 5)
        for item in data_list:
            if item:
                item.is_vaild = 0
                self.session.add(item)  # 加入
        self.session.commit()  # 提交
    ## filter 与 filter_by 的区别


    ## 删除数据
    def delete_data(self, n=6):
        data = self.session.query(News).get(n)
        if data:
            self.session.delete(data)
            self.session.commit()
        else:
            return False

    def delete_data_more(self, n=5):
        delete_list = self.session.query(News).filter(News.id <= n)
        for item in delete_list:
            if item:
                self.session.delete(item)       
            else:
                return False
        self.session.commit() 


#######
def selLine(model, n=1, more=False): 
    # 2. get one line
    if not more:
        man = model.get_one(n) 
        ## 防止查询失误
        if man:  
            print('ID:{0}, {1} {2}'.format(man.id, man.nickname ,man.sex))
        else:
            print('Not exist')
    
    # get more data
    else:
        data_more = model.get_more()
        print('count =', data_more.count())  # 计数
        for new_obj in data_more:
            print('ID:{0}  {1} {2} {3}'.format(new_obj.id,new_obj.sex,new_obj.name,new_obj.nickname))



    

#增删改查
if __name__ == '__main__':
    model = OrmTest() #0. 创建模型
    #
    # 1. 添加数据, 反复执行，多添加十几条的。
    #model.add_one() #添加一行
    #model.add_more() #添加多行

    # 4. 删除
    #model.delete_data(); print('数据删除成功')
    model.delete_data_more()
    
    # 3. 改
    #model.update_data(); print('数据修改成功')
    
    #selLine(model,n=19);
    selLine(model,more=True);
