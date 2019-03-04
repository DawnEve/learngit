def login():
    print('in login')
 
def printdebug(func):
    def __decorator():
        print('enter the login2')
        func()
        print('exit the login2')
    return __decorator  #function as return value
 
debug_login = printdebug(login)  #function assign to variable

debug_login()  #execute the returned function