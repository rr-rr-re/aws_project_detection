package process;

import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;//書き込むファイルを指定
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;//ファイルに文字列を書き込む、
import java.util.Base64;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import practice1.nettest.Demo1ServiceResource;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.imageio.ImageIO;

public class ProcessService {

/////////////ファイルを作成してゲットした画像のバイトデータをそのファイルに書き込む/////////////////
	 public static void ProcessImage(byte[] decoded){ ///引数にByte列
		try {		
			FileOutputStream bf = new FileOutputStream("/home/ubuntu/img/getImg.jpg");
			bf.write(decoded);
			bf.close();
		}
			
			
			
			
			
			/*ByteArrayOutputStream baos = new ByteArrayOutputStream(decoded);
					InputStream input = new FileInputStream();
					BufferedImage image = ImageIO.read(input);
					FileOutputStream output =
					new FileOutputStream("/Users/ruimac/Pictures/getImg.jpg");
					ImageIO.write(image, "jpg", output);
		
			
					InputStream in = new FileInputStream(sbyte);
	        BufferedImage bImageFromConvert = ImageIO.read(in);
	        ImageIO.write(bImageFromConvert, "jpg", new File(
                    "/Users/ruimac/Pictures/getImg.jpg"));
 
	       BufferedOutputStream bf = new BufferedOutputStream
                    (new FileOutputStream("/Users/ruimac/Pictures/getImg.jpg"));
			byte[] b1 = sbyte;///ここにPOSTで得た画像のバイト列を引数で挿入

            bf.write(b1); //ここの引数に入れる？
            //ファイルに書き込む
            bf.flush();
            //ファイルを閉じる
            bf.close();
		*/ catch (IOException e) {
            e.printStackTrace();
        }
	} 
/////////////から作成されたファイルのインポート////////////////////
	 public static byte[] ProcessImport() throws Exception {
		 byte[] b = new byte[1];
	 	 FileInputStream fis = new FileInputStream("/home/ubuntu/img/kansei.jpg");
	 	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 	 while (fis.read(b) > 0) {
	 	   baos.write(b);
	 	 }
	 	   baos.close();
	 	   fis.close();
	 	   b = baos.toByteArray();
	 return b;
	}	
}
