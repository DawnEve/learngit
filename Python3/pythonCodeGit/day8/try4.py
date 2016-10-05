def some_function(n):
    print('    begin')
    try:
        # Division by zero raises an exception
        r=10 / n
        print('如果出错，该行不会被打印. 结果是',r);
    #except ZeroDivisionError:
    except ZeroDivisionError as e:
        print("Oops, invalid.",e)
    else:
        # Exception didn't occur, we're good.
        pass
    finally:
        # This is executed after the code block is run
        # and all exceptions have been handled, even
        # if a new exception is raised while handling.
        print("We're done with that.本行总是被打印")
 
some_function(0.1)
#结果是 100.0
#We're done with that.

some_function(0)
#Oops, invalid.
#We're done with that.