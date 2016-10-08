#使用list存储数据时，按索引访问元素很快，但是插入和删除元素就很慢了，
#因为list是线性存储，数据量大的时候，插入和删除效率很低。

#deque是为了高效实现插入和删除操作的双向列表，适合用于队列和栈：

from collections import deque

q = deque(['a', 'b', 'c'])
q.append('x')
q.appendleft('y')
print(q) #deque(['y', 'a', 'b', 'c', 'x'])
print(type(q)) #<class 'collections.deque'>

#deque除了实现list的append()和pop()外，还支持appendleft()和popleft()，这样就可以非常高效地往头部添加或删除元素。

