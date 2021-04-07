# 享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。
import weakref  

class Card(object):
    """The object pool. Has builtin reference counting"""
    _CardPool = weakref.WeakValueDictionary() 

    """Flyweight implementation. If the object exists in the
    pool just return it (instead of creating a new one)"""
    def __new__(cls, value, suit):         
        obj = Card._CardPool.get(value + suit, None)         
        if not obj:             
            obj = object.__new__(cls)             
            Card._CardPool[value + suit] = obj             
            obj.value, obj.suit = value, suit          
        return obj

    # def __init__(self, value, suit):         
    #     self.value, self.suit = value, suit
    def __repr__(self):         
        return "<Class Card: %s%s>" % (self.value, self.suit)      


if __name__ == '__main__':
    # comment __new__ and uncomment __init__ to see the difference
    c1 = Card('9', 'h')
    c2 = Card('9', 'i')
    c3 = Card('9', 'h')
    print(c1, c3)
    print(c1 == c3)
    print(id(c1), id(c2), id(c3))
# 虽然客户端申请了三个享元对象，但是实际创建的享元对象只有两个，这就是共享的含义。

