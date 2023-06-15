package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class G1 {
	public static void main(String[] args) throws IOException {
		demo1(); //解压缩流
	}

	//解压缩流
	private static void demo1() throws IOException {
		//1 创建一个 File 表示要解压的压缩包
		File src = new File("dustbin//my_r.zip");
		//2. 解压到的目的地
		File dest = new File("backup//");
		
		// 解压缩
		unzip(src, dest);
	}
	
	//递归解压缩
	public static void unzip(File src, File dest) throws IOException {
		//解压的本质：把压缩包中的每一个文件或文件夹读取出来，按照层级拷贝到目的地
		ZipInputStream zip=new ZipInputStream(new FileInputStream(src));
		//获取压缩包里面的每一个 ZipEntry 对象
//		for(int i=0; i<100; i++) {
//			ZipEntry entry = zip.getNextEntry();
//			System.out.println(entry); //读取结束后，输出 null
//		}
		
		//复制文件的缓冲变量
		byte[] buffer = new byte[2048];
		
		// 获取压缩包中每个文件或文件夹
		ZipEntry entry=null;
		while ((entry=zip.getNextEntry()) != null) {
			System.out.println(entry);
			// 目的地文件或文件夹
			File file=new File(dest, entry.toString());
			if(entry.isDirectory()) {
				//如果是文件夹，则在目的地新建文件夹
				file.mkdirs();
			}else {
				//如果目的地文件夹不存在，新建路径
				File fileParent=new File(file.getParent());
				if(! fileParent.exists() ) {
					fileParent.mkdirs();
				}
				//如果是文件，需要读取压缩包中的文件，并复制到desc文件夹中
				FileOutputStream fos = new FileOutputStream(
						new File(dest, entry.toString()));
				// 写文件1
//				int b;
//				while((b=zip.read()) != -1) {
//					//写到目的地
//					fos.write(b);
//				}
				// 写文件2
				int len;
				while((len=zip.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				//压缩包中一个文件处理完毕
				zip.closeEntry();
			}
		}
		zip.close();
	}
}
