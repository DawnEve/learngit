# Queue和Pipe只是实现了数据交互，并没实现数据共享。
# 即一个进程去更改另一个进程的数据。那么就要用到Managers
from multiprocessing import Process, Manager

def fun1(dic, lis, index):
    dic[index] = 'a'+str(index)
    dic['2'] = dic.get("2","")+ '_'+str(index)
    
    lis.append(index)    #[0,1,2,3,4,0,1,2,3,4,5,6,7,8,9]
    print(index)

if __name__ == '__main__':
    with Manager() as manager:
        dic1 = manager.dict() #注意字典的声明方式，不能直接通过{}来定义
        lis2 = manager.list(range(5)) #[0,1,2,3,4]

        process_list = []
        for i in range(5):
            p = Process(target=fun1, args=(dic1,lis2,i))
            p.start()
            process_list.append(p)

        for pr in process_list:
            pr.join()
        
        print(dic1)
        print(lis2)
