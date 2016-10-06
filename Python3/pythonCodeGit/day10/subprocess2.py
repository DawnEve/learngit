import subprocess

print('$ nslookup www.python.org')
r = subprocess.call(['nslookup', 'www.python.org'])
# r = subprocess.call(['ping','python.org'])

print('Exit code:', r)