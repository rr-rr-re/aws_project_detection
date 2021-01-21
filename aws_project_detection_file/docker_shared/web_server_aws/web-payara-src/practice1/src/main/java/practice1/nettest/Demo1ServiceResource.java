package practice1.nettest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import practice1.rest.UserDto.UserDto;
import practice1.rest.UserDto.UserLogDto;
import process.ProcessService;
import process.PythonCall;
import python.http.PythonHttpConnection;

@Path("sample2")
public class Demo1ServiceResource {


////////////画像のGETの処理//////////////////////////////////////////////
	@GET //
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSample")
	public UserDto GetSampleMethod() throws Exception {
//インスタンス化されたsetImgを処理していく
		//python呼び出し実行opencv
		/*
		ProcessBuilder pb = new ProcessBuilder("python", "/Users/ruimac/study/do_opencv.py");
		pb.redirectErrorStream(true);      // 標準出力と標準エラー出力の出力先を同じにする。
		pb.redirectOutput(log.toFile());
		
		try
		{
			Process process = pb.start();
			process.waitFor();
		};*/
		
		
	
		
		byte[] result = ProcessService.ProcessImport();  //画像の読み込み
		String encoded = Base64.getEncoder().encodeToString(result);
	//	byte[] encoded = Base64.getEncoder().encode(result);
		//resultに入っているbyteを変換
		UserDto user = new UserDto();
		
		user.flSrcImageId = 1;
		user.filename = "aaaa1111";
		user.img = encoded; ////ここを新しく作成したファイル
		
        return user;
	}

//////////POSTの処理/////////////////////////////////////////////
	@POST
	@Path("postSample")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void PostSampleMethod(UserDto setImg
		/*	@FormDataParam("flSrcImageId") int id,
			@FormDataParam("filename") String name,
			@FormDataParam("img") String image
		//	@FormDataParam("img") FormDataContentDisposition dispoosition
			*/) throws Exception {
//インスタンス名setImgをインスタンス化
		//String sbyte = setImg.img;
		byte[] decoded = Base64.getDecoder().decode(setImg.img);//jpeg に戻すBAse64変換
 
		ProcessService.ProcessImage(decoded); //送られてきた画像をファイルに保存　OK
		
		PythonHttpConnection.sendGet();
		//PythonCall.do_python();
	
	}
	

//////////POSTLOGIN/////////////////////////////////////////////
@POST
@Path("postlogin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public int PostSampleMethod(UserLogDto setLog) throws Exception {
////送られてきたIDパスワードをインスタンス化
	UserLogDto aaa = new UserLogDto();
	aaa.username = setLog.username;
	aaa.password = setLog.password;
	
	
	
	int result;
	if((aaa.username.equals("iamabcd")) && (aaa.password.equals("aaabbbccc"))) {
		result = 1;
	}else {
		result = 0;
	}	return result;
	
  }	
}
