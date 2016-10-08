import base64
print(base64.b64encode(b'binary\x00string'))
#b'YmluYXJ5AHN0cmluZw=='
print(base64.b64decode(b'YmluYXJ5AHN0cmluZw=='))
#b'binary\x00string'