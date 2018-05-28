
#tuple is not changable
t = ('a', 'b', ['A', 'B'])
print(t)
#t[0]="100" #TypeError: 'tuple' object does not support item assignment


#but we can still change something in the list of tuple
t[2][0] = 'X'
t[2][1] = 'Y'

print(t)