# 多国语言翻译

class GreekGetter:
    """A simple localizer a la gettext"""
    def __init__(self):
        self.trans = dict(dog="σκύλος", cat="γάτα")

    def get(self, msgid):
        """We'll punt if we don't have a translation"""          
        try:
            return self.trans[msgid]
        except KeyError:
            return str(msgid)


class EnglishGetter:
    """Simply echoes the msg ids"""     
    def get(self, msgid):
        return str(msgid)

# 工厂方法
def get_localizer(language="English"):
    """The factory method"""
    languages = dict(English=EnglishGetter, Greek=GreekGetter)
    return languages[language]()

# Create our localizers
e, g = get_localizer("English"), get_localizer("Greek")
# Localize some text
for msgid in "dog parrot cat bear".split():
    print(e.get(msgid), g.get(msgid))


print("="*20)
###################
# 新增汉语工厂
class ChineseGetter:
    """A simple localizer a la gettext"""
    def __init__(self):
        self.trans = dict(dog="狗", cat="猫")

    def get(self, msgid):
        """We'll punt if we don't have a translation"""          
        try:
            return self.trans[msgid]
        except KeyError:
            return str(msgid)
# 修改工厂, 能不能不修改呢？能，使用 工厂方法模式
def get_localizer2(language="English"):
    """The factory method"""
    languages = dict(English=EnglishGetter, 
                     Greek=GreekGetter,
                     Chinese=ChineseGetter)
    return languages[language]()
c=get_localizer2("Chinese")
arr=[]
for msgid in "dog parrot cat bear".split():
    arr.append(c.get(msgid))
print(arr)