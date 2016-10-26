
import itertools

for key, group in itertools.groupby('AaaBBbcCAAacccac', lambda c: c.upper()):
    print(key, list(group))