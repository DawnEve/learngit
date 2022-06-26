# 广度优先算法:
# 维护一个队列，先加入一度节点；
# 遍历，如果找到了就停止；没找到，就弹出，并把其好友添加到队列末尾。
# 直到返回，或者找不到。
from re import search

#
# v2: 为了避免死循环，要记录搜寻过的元素，并跳过它。
# 另一个更新，是把函数封装的更好：传入图和要查找的起始点。

# 创建图
graph = {}
graph["you"] = ["alice", "bob", "claire"]
graph["bob"] = ["anuj", "peggy"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "jonny"]
graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["jonny"] = []

# 在Python中，可使用函数deque来创建一个双端队列。
from collections import deque

# 判断这个人是不是芒果经销商，最后一个字母是m 的停止
def person_is_seller(name):
    return name[-1] == 'm'

# 开始搜索
def bfs2(graph, name="you", debug=True):
    search_queue = deque()
    search_queue += graph[name]

    searched=[]
    i=0
    while search_queue:
        i+=1
        person = search_queue.popleft() #左侧弹出一个元素
        if person in searched:
            print(f"[{i}]==>Jump:", person)
            continue;
        else:
            searched.append(person);
        
        if debug:
            print(f"[{i}] Cur:", person);
            print("\t>>>queue:", search_queue);
        
        if person_is_seller(person):
            print(person + " is a mango seller!")
            return True
        else:
            search_queue += graph[person]
    return False

bfs2(graph, "you");
print("==End==")
