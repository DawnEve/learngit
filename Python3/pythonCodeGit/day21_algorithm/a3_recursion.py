def fact(x):
    if x<=1:
        return 1;
    else:
        if debug:
            print(x)
        return x*fact(x-1)

debug=True
x=fact(5)
print(x)
