from urllib import request

req = request.Request('http://www.douban.com/')
req.add_header('User-Agent', 'Mozilla/6.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/8.0 Mobile/10A5376e Safari/8536.25')
with request.urlopen(req) as f:
    print('Status:', f.status, f.reason)
    for k, v in f.getheaders():
        print('%s: %s' % (k, v))
    print('Data:', f.read().decode('utf-8'))
    
'''
Status: 200 OK
Date: Sun, 09 Oct 2016 06:07:29 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 95691
Connection: close
Vary: Accept-Encoding
X-Xss-Protection: 1; mode=block
X-Douban-Mobileapp: 0
Expires: Sun, 1 Jan 2006 01:00:00 GMT
Pragma: no-cache
Cache-Control: must-revalidate, no-cache, private
Set-Cookie: ll="118237"; path=/; domain=.douban.com; expires=Mon, 09-Oct-2017 06:07:29 GMT
Set-Cookie: bid=f9c2cXp5ASY; Expires=Mon, 09-Oct-17 06:07:29 GMT; Domain=.douban.com; Path=/
X-DOUBAN-NEWBID: f9c2cXp5ASY
X-DAE-Node: sindar13d
X-DAE-App: sns
Server: dae
Strict-Transport-Security: max-age=15552000;
Data: <!DOCTYPE HTML>
<html lang="zh-cms-Hans" class="ua-iphone ua-webkit">
<head>
<meta charset="UTF-8">
<meta name="description" content="提供图书、电影、音乐唱片的推荐、评论和价格比较，以及城市独特的文化生活。">
<meta name="keywords" content="豆瓣,广播,登陆豆瓣">
<meta property="qc:admins" content="2554215131764752166375" />
<meta property="wb:webmaster" content="375d4a17a4fa24c2" />
<meta name="mobile-agent" content="format=html5; url=https://m.douban.com">
<title>豆瓣</title>
'''
    