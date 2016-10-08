import threading, multiprocessing

print('CPU个数：',multiprocessing.cpu_count()) #4

def loop():
    x = 1
    while True:
        x = x ^ 1

for i in range(multiprocessing.cpu_count()):
    t = threading.Thread(target=loop)
    t.start()

