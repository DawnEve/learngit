# re.match只匹配字符串开始的字符，如果开始的字符不符合规则，匹配就会失败，返回None
# re.search则匹配整个字符串，知道找到一个匹配的对象，匹配结束没找到匹配值才返回None
#返回的search类也有方法：group(), span()等。
import re 
line="Cats are smarter than dogs, but cats are more naughty."


se = re.search(r'cat', line)
print('1: ',se)


se2 = re.search(r'cat', line, re.I)
print('2: ',se2)

se3 = re.search(r'cat', line, re.M|re.I)
print('3: ',se3) #<_sre.SRE_Match object; span=(0, 3), match='Cat'>
print('3- str(se3): ',str(se3))
print('3- dir(se3): ',dir(se3))
print('3- se3.group():',se3.group())
print('3- se3.span():',se3.span())
