from urllib import request

with request.urlopen('https://api.douban.com/v2/book/2129650') as f:
    data = f.read()
    print('Status:', f.status, f.reason)
    for k, v in f.getheaders():
        print('%s: %s' % (k, v))
    print('Data:', data.decode('utf-8'))
    
    
# Status: 200 OK
# Date: Sun, 09 Oct 2016 06:05:41 GMT
# Content-Type: application/json; charset=utf-8
# Content-Length: 2055
# Connection: close
# Vary: Accept-Encoding
# Expires: Sun, 1 Jan 2006 01:00:00 GMT
# Pragma: no-cache
# Cache-Control: must-revalidate, no-cache, private
# Set-Cookie: bid=BJlm6yAhFII; Expires=Mon, 09-Oct-17 06:05:41 GMT; Domain=.douban.com; Path=/
# X-DOUBAN-NEWBID: BJlm6yAhFII
# X-DAE-Node: nain3
# X-DAE-App: book
# Server: dae
# Data: {"rating":{"max":10,"numRaters":16,"average":"7.4","min":0},"subtitle":"","author":["廖雪峰编著"],"pubdate":"2007-6","tags":[{"count":20,"name":"spring","title":"spring"},{"count":11,"name":"Java","title":"Java"},{"count":6,"name":"javaee","title":"javaee"},{"count":4,"name":"j2ee","title":"j2ee"},{"count":3,"name":"POJO","title":"POJO"},{"count":3,"name":"计算机","title":"计算机"},{"count":3,"name":"藏书","title":"藏书"},{"count":3,"name":"编程","title":"编程"}],"origin_title":"","image":"https://img3.doubanio.com\/mpic\/s2648230.jpg","binding":"","translator":[],"catalog":"","pages":"509","images":{"small":"https://img3.doubanio.com\/spic\/s2648230.jpg","large":"https://img3.doubanio.com\/lpic\/s2648230.jpg","medium":"https://img3.doubanio.com\/mpic\/s2648230.jpg"},"alt":"https:\/\/book.douban.com\/subject\/2129650\/","id":"2129650","publisher":"电子工业","isbn10":"7121042622","isbn13":"9787121042621","title":"Spring 2.0核心技术与最佳实践","url":"https:\/\/api.douban.com\/v2\/book\/2129650","alt_title":"","author_intro":"","summary":"本书注重实践而又深入理论，由浅入深且详细介绍了Spring 2.0框架的几乎全部的内容，并重点突出2.0版本的新特性。本书将为读者展示如何应用Spring 2.0框架创建灵活高效的JavaEE应用，并提供了一个真正可直接部署的完整的Web应用程序——Live在线书店(http:\/\/www.livebookstore.net)。\n在介绍Spring框架的同时，本书还介绍了与Spring相关的大量第三方框架，涉及领域全面，实用性强。本书另一大特色是实用性强，易于上手，以实际项目为出发点，介绍项目开发中应遵循的最佳开发模式。\n本书还介绍了大量实践性极强的例子，并给出了完整的配置步骤，几乎覆盖了Spring 2.0版本的新特性。\n本书适合有一定Java基础的读者，对JavaEE开发人员特别有帮助。本书既可以作为Spring 2.0的学习指南，也可以作为实际项目开发的参考手册。","price":"59.80元"}
