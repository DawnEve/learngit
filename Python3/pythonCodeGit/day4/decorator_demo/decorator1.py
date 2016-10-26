def login():
    print('in login')
 
def printdebug(func):
    print('enter the login')
    func()
    print('exit the login')
 
printdebug(login)