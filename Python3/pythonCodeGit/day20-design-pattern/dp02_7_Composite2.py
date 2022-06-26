# Composite Pattern with Python Code
# 创建Employee类，该类带有Employee对象的列表
class Employee():
    _strName = ""
    _strDept = ""
    _intSalary = 0
    _subordinates = None

    def __init__(self,inName,inDept,inSalary):
        self._strName = inName
        self._strDept = inDept
        self._intSalary = inSalary
        self._subordinates = []

    def add(self,inEmployee):
        self._subordinates.append(inEmployee)
    def remove(self,inEmployee):
        self._subordinates.remove(inEmployee)
    def getSubordinates(self):
        return self._subordinates
    def toString(self):
        return("Employee : [ Name : %s, dept : %s, salary: %d]" % \
               (self._strName , self._strDept , self._intSalary))


# 调用输出
if __name__ == '__main__':
    CEO = Employee("John","CEO",30000)
    headSales = Employee("Robert","Head Sales",20000)
    salesExecutive1 = Employee("Richard","Sales",10000)
    salesExecutive2 = Employee("Rob", "Sales", 10000)
    headMarketing = Employee("Michel","Head Marketing",20000)
    clerk1 = Employee("Laura", "Marketing", 10000)
    clerk2 = Employee("Bob", "Marketing", 10000)

    CEO.add(headSales)
    CEO.add(headMarketing)
    headSales.add(salesExecutive1)
    headSales.add(salesExecutive2)
    headMarketing.add(clerk1)
    headMarketing.add(clerk2)

    print(CEO.toString())
    for headEmployee in CEO.getSubordinates() :
        print(" |--", headEmployee.toString())
        for employee in headEmployee.getSubordinates():
            print("    |--", employee.toString())
print("==end==")