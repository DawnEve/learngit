# 广度优先算法:
# 维护一个队列，先加入一度节点；
# 遍历，如果找到了就停止；没找到，就弹出，并把其好友添加到队列末尾。
# 直到返回，或者找不到。

#
# 这个粗糙的实现有个问题，就是有人(peggy) 被查询了2次。
# 首先同一个元素检查2次是在浪费时间，其次这有可能陷入死循环，如果两个人互为好友。
# 应该使用一个表格，记录检查过的元素。

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
search_queue = deque()
search_queue += graph["you"]

# 判断这个人是不是芒果经销商，最后一个字母是m 的停止
def person_is_seller(name):
    return name[-1] == 'm'

# 开始搜索
def bfs(search_queue, debug=True):
    i=0
    while search_queue:
        person = search_queue.popleft() #左侧弹出一个元素
        
        i+=1
        if debug:
            print(f"[{i}] Cur:", person);
            print("\t>>>queue:", search_queue);
        
        if person_is_seller(person):
            print(person + " is a mango seller!")
            return True
        else:
            search_queue += graph[person]
    return False

bfs(search_queue);
print("==End==")
