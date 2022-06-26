# 贪婪算法： 集合覆盖度问题
# 每个电台覆盖几个州，2个电台覆盖的州可能有重叠。求覆盖全部州需要至少哪几个电台？

# 传入所有的州，转为一个集合
states_needed=set(["mt", 'wa', 'or', 'id','nv','ut','ca','az'])

# 电台，及覆盖的州
stations={}
stations["kone"]=set(['id','nv','ut'])
stations['ktwo']=set(['wa','id','mt'])
stations['kthreee']=set(['or','nv','ca'])
stations['kfour']=set(['nv','ut'])
stations['kfive']=set(['ca','az'])

# 最终选用的电台
final_stations=set();

i=0;
while len(states_needed)>0:
    i+=1;
    if i>1000:
        break; #防止死循环
    
    # 一轮挑选一个覆盖(未覆盖区域)最广泛的电台
    best_station = None;
    # 覆盖的州
    states_covered=set();
    # 遍历电台
    for station, states_for_station in stations.items():
        # 求交集：未覆盖的州，该电台覆盖的州
        covered= states_needed & states_for_station;
        # 记录覆盖最多未覆盖州的电台
        if len(covered) > len(states_covered):
            best_station = station;
            states_covered = covered;
    # for 结束，就找到了覆盖最多的(未覆盖)州的电台
    # 则从未覆盖州中去掉这几个州
    states_needed -= states_covered;
    # 最终选用的电台增加一个
    final_stations.add(best_station)
    print(i, best_station)

# 集合无法保证顺序，添加顺序和打印集合的输出不一致。
print(final_stations)

