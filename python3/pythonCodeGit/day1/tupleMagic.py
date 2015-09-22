
#tuple is not changable
t = ('a', 'b', ['A', 'B'])
print(t)

#but we can still change something
t[2][0] = 'X'
t[2][1] = 'Y'

print(t)