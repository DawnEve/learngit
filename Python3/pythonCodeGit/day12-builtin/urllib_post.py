from urllib import request, parse

# 登录微博

print('Login to weibo.cn...')
email = input('Email: ')
passwd = input('Password: ',type='password')
login_data = parse.urlencode([
    ('username', email),
    ('password', passwd),
    ('entry', 'mweibo'),
    ('client_id', ''),
    ('savestate', '1'),
    ('ec', ''),
    ('pagerefer', 'https://passport.weibo.cn/signin/welcome?entry=mweibo&r=http%3A%2F%2Fm.weibo.cn%2F')
])

req = request.Request('https://passport.weibo.cn/sso/login')
req.add_header('Origin', 'https://passport.weibo.cn')
req.add_header('User-Agent', 'Mozilla/6.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/8.0 Mobile/10A5376e Safari/8536.25')
req.add_header('Referer', 'https://passport.weibo.cn/signin/login?entry=mweibo&res=wel&wm=3349&r=http%3A%2F%2Fm.weibo.cn%2F')

with request.urlopen(req, data=login_data.encode('utf-8')) as f:
    print('Status:', f.status, f.reason)
    for k, v in f.getheaders():
        print('%s: %s' % (k, v))
    print('Data:', f.read().decode('utf-8'))
    
'''
Status: 200 OK
Server: nginx/1.6.1
Date: Sun, 09 Oct 2016 06:20:52 GMT
Content-Type: text/html
Transfer-Encoding: chunked
Connection: close
Vary: Accept-Encoding
Cache-Control: no-cache, must-revalidate
Expires: Sat, 26 Jul 1997 05:00:00 GMT
Pragma: no-cache
Access-Control-Allow-Origin: https://passport.weibo.cn
Access-Control-Allow-Credentials: true
Set-Cookie: SUB=_2A256_ZGUDeTxGedP41US8SzIzDiIHXVWAT_crDV6PUJbkdAKLXf9kW1iZuj-qVQQDL_VgpA7owmmi0--UA..; Path=/; Domain=.weibo.cn; Expires=Mon, 09 Oct 2017 06:20:52 GMT; HttpOnly
Set-Cookie: SUHB=0eb8TrhydELDuW; expires=Monday, 09-Oct-17 06:20:52 GMT; path=/; domain=.weibo.cn
Set-Cookie: SCF=AjnXd7e2373K_Vtzwum4fkNxD-T3B36y2SVbq2UeawZ22CB3AUgBiFU8YzxUzetmBLYzLrif-rQl3_csm4maCMM.; expires=Wednesday, 07-Oct-26 06:20:52 GMT; path=/; domain=.weibo.cn; httponly
Set-Cookie: SSOLoginState=1475994052; path=/; domain=weibo.cn
Set-Cookie: ALF=1478586052; expires=Tuesday, 08-Nov-16 06:20:52 GMT; path=/; domain=.sina.cn
DPOOL_HEADER: kotl46
SINA-LB: aGEuNTQuZzEuYngubGIuc2luYW5vZGUuY29t
SINA-TS: ZGZjNGU0Y2UgMCAwIDAgNCAxOTkK
Data: {"retcode":20000000,"msg":"","data":{"loginresulturl":"https:\/\/passport.weibo.com\/sso\/crossdomain?entry=mweibo&action=login&proj=1&ticket=ST-MTE4NzMxMjQ3NA%3D%3D-1475994052-tc-749396ABABDDD093722AD3EE3F4BBB3B&display=0&cdurl=https%3A%2F%2Flogin.sina.com.cn%2Fsso%2Fcrossdomain%3Fentry%3Dmweibo%26action%3Dlogin%26proj%3D1%26ticket%3DST-MTE4NzMxMjQ3NA%253D%253D-1475994052-tc-63A2021FA3D10C898E563534D7FFFC74%26display%3D0%26cdurl%3Dhttps%253A%252F%252Fpassport.sina.cn%252Fsso%252Fcrossdomain%253Fentry%253Dmweibo%2526action%253Dlogin%2526display%253D0%2526ticket%253DST-MTE4NzMxMjQ3NA%25253D%25253D-1475994052-tc-D3DA76439A5770337E05D498F180505B","uid":"1187312474"}}

'''