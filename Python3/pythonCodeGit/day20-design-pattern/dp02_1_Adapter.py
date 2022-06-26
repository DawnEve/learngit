# 这个实例是把几种不同类并列到一起工作。

class Dog(object):
    def __init__(self):
        self.name = "Dog"

    def bark(self):
        return "woof!"


class Cat(object):
    def __init__(self):
        self.name = "Cat"

    def meow(self):
        return "meow!"


class Human(object):
    def __init__(self):
        self.name = "Human"

    def speak(self):
        return "Hello!"


class Car(object):
    def __init__(self):
        self.name = "Car"

    def make_noise(self, octane_level):
        return "vroom%s" % ("!" * octane_level)


class Adapter(object):
    """
    Adapts an object by replacing methods.
    Usage:
    dog = Dog
    dog = Adapter(dog, dict(make_noise=dog.bark))
    """
    def __init__(self, obj, adapted_methods):
        """We set the adapted methods in the object's dict"""
        self.obj = obj
        self.__dict__.update(adapted_methods)

    def __getattr__(self, attr):
        """All non-adapted calls are passed to the object"""
        return getattr(self.obj, attr)


if __name__ == "__main__":
    objects = []
    
    dog = Dog()
    objects.append(Adapter(dog, dict(make_noise=dog.bark)))
    
    cat = Cat()
    objects.append(Adapter(cat, dict(make_noise=cat.meow)))
    
    human = Human()
    #objects.append(Adapter(human, dict(make_noise=human.speak)))
    objects.append(Adapter(human, {"make_noise": human.speak}))
    
    car = Car()
    car_noise = lambda: car.make_noise(10)
    objects.append(Adapter(car, dict(make_noise=car_noise)))

    for obj in objects:
        print("A", obj.name, "goes", obj.make_noise())


