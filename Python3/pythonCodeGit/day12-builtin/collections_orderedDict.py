from collections import OrderedDict
d = dict([('a', 1), ('b', 2), ('c', 3)])
print(d) # dict的Key是无序的
#{'a': 1, 'c': 3, 'b': 2}



od = OrderedDict([('a', 1), ('b', 2), ('c', 3)])
print(od) # OrderedDict的Key是有序的
#OrderedDict([('a', 1), ('b', 2), ('c', 3)])


