class Chain(object):

    def __init__(self, path=''):
        self._path = path

    def __getattr__(self, path):
        return Chain('%s/%s' % (self._path, path))

    def __str__(self):
        return self._path

    __repr__ = __str__
	
# 链式调用
url=Chain().status.user.timeline.list
print(url) #/status/user/timeline/list






class Chain2(object):

    def __init__(self, path=''):
        self._path = path

    def __getattr__(self, path):
        if path == 'users':
            return Chain2('%s/%s' % (self._path, path))._users
        return Chain2('%s/%s' % (self._path, path))

    def __str__(self):
        return self._path
		
    def _users(self, name):
        return Chain2("%s/%s" % (self._path, name))

    __repr__ = __str__



url2=Chain2().users('michael').repos
print(url2) #/users/michael/repos
