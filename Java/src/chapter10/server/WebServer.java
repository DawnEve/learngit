package chapter10.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
测试网址：
http://localhost:8082/bb.txt
http://localhost:8082/aa.jpg

测试结果：
Web Server startup on  8082
Method: GET, file name: /bb.txt, HTTP version: HTTP/1.1Thread[Thread-0,5,main]
Method: GET, file name: /bb.txt, HTTP version: HTTP/1.1Thread[Thread-1,5,main]
Method: GET, file name: /bb.txt, HTTP version: HTTP/1.1Thread[Thread-2,5,main]
Method: GET, file name: /bb.txt, HTTP version: HTTP/1.1Thread[Thread-3,5,main]
Method: GET, file name: /aa.jpg, HTTP version: HTTP/1.1Thread[Thread-4,5,main]
 * 
 * @see http://www.cnblogs.com/wangrui-techbolg/archive/2013/03/10/2953108.html
 * 
 * @author admin
 *
 */
public class WebServer {
    /** 默认使用的服务器Socket端口号 */
    public static final int HTTP_PORT = 8082;
    private ServerSocket serverSocket;

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Web Server startup on  " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                // 通过线程的方式来处理客户的请求
                new Processor(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * WebServer类的启动方法，可以通过命令行参数指定当前Web服务器所使用的端口号。
     */
    public static void main(String[] argv) throws Exception {
        WebServer server = new WebServer();
        if (argv.length == 1) {
            server.startServer(Integer.parseInt(argv[0]));
        } else {
            server.startServer(WebServer.HTTP_PORT);
        }
    }
}