import os

print("Process (%s) start...", os.getpid())

#only works on Unix/Linux/Mac:
pid=os.fork()
if pid==0:
    print("I am child process (%s) and my parent is %s." % (os.getpid(),os.getppid()))
else:
    print("I (%s) just created a child process (%s)." %(os.getpid(),pid))

#子进程永远返回0，而父进程返回子进程的ID。这样做的理由是，一个父进程可以fork出很多子进程，
#所以，父进程要记下每个子进程的ID，而子进程只需要调用getppid()就可以拿到父进程的ID。
