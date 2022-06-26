# 模板方法（TemplateMethod）模式：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，
#   使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。

"""An example of the Template pattern in Python"""  

ingredients = "spam eggs apple"
line = '-' * 10

# Skeletons
def iter_elements(getter, action):     
    """Template skeleton that iterates items"""      
    for element in getter():         
        action(element)     
        print(line)  


def rev_elements(getter, action):
    """Template skeleton that iterates items in reverse order"""      
    for element in getter()[::-1]:         
        action(element)     
        print(line)  

# Getters
def get_list():     
    return ingredients.split()  

def get_lists():
    return [list(x) for x in ingredients.split()]  

# Actions
def print_item(item):     
    print(item)  

def reverse_item(item):
    print(item[::-1])  

# Makes templates
def make_template(skeleton, getter, action):     
    """Instantiate a template method with getter and action"""     
    def template():         
        skeleton(getter, action)     
    return template  

# Create our template functions 
templates = [make_template(s, g, a)              
             for g in (get_list, get_lists)              
             for a in (print_item, reverse_item)              
             for s in (iter_elements, rev_elements)]  

# Execute them 
for template in templates:
    print("="*50)
    template()