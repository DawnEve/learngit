package chapter8;
import java.io.*;


/**
 * 验证管道流
 */
  
public class PipedDemo {
	/**
	 * 测试类
	 * */
   public static void main(String[] args) throws IOException {
	   Send send=new Send();
	   Receive receive=new Receive();
	   try{
		   //管道连接
		   send.getOut().connect(receive.getInput());
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   new Thread(send).start();
	   new Thread(receive).start();
    }
}


/**
 * 消息发送类
 * */
class Send implements Runnable{
   private PipedOutputStream out=null;
   public Send() {
       out=new PipedOutputStream();//this可以省略？
    }
   public PipedOutputStream getOut(){
       return this.out;
    }
   public void run(){
       String message="hello , Boys...Today is a good sunny day.";
       try{
           out.write(message.getBytes());
       }catch (Exception e) {
           e.printStackTrace();
       }try{
           out.close();
       }catch (Exception e) {
           e.printStackTrace();
       }
    }
}
  
/**
 * 接收消息类
 * */
class Receive implements Runnable{
   private PipedInputStream input=null;
   public Receive(){
       this.input=new PipedInputStream();
    }
   public PipedInputStream getInput(){
       return this.input;
    }
   public void run(){
       byte[] b=new byte[8];
       int len=0;
       try{
           while((len=this.input.read(b))!=-1){
        	   System.out.println("接收的内容为: "+(new String(b,0,len)));
           }
       }catch (Exception e) {
           e.printStackTrace();
       }try{
           input.close();
       }catch (Exception e) {
           e.printStackTrace();
       }
    }
}
