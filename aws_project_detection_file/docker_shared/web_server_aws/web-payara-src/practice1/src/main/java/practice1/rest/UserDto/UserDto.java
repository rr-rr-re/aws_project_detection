package practice1.rest.UserDto;

import java.io.InputStream;

public class UserDto {
	
    public int flSrcImageId;  ////id
    public String filename;  /////name
    public String img;  ////sample用
    //public byte[] img;  //////画像のバイト列
 
    /**
	 * JSONのクラス
	export class UserDto {
		  "flSrcImageId" : "number";  //元画像id
		  "filename" : "string";  //元画像ファイル名
		  "img" : "string"; ///byte列コード
		}
	 */
}