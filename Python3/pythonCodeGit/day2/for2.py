#for-if
rangelist = range(10)
print(rangelist)
#[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
for number in rangelist:
    # Check if number is one of
    # the numbers in the tuple.
    if number in (3, 19):
        # "Break" terminates a for without
        # executing the "else" clause.
        print('break: %s'%(number));
        break
    else:
        # "Continue" starts the next iteration
        # of the loop. It's rather useless here,
        # as it's the last statement of the loop.
        print('continue: %s'%(number));
        continue
else:
    # The "else" clause is optional and is
    # executed only if the loop didn't "break".
    print('the for -> else');
    pass # Do nothing

#if
if rangelist[1] == 2:
    print("The second item (lists are 0-based) is 2")
elif rangelist[1] == 3:
    print( "The second item (lists are 0-based) is 3")
else:
    print( "Dunno")

