package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

//import org.apache.commons.io.IOUtils;

public class PythonCall {
	public static void do_python() throws IOException, InterruptedException{
		ProcessBuilder processBuilder = new ProcessBuilder("/home/ubuntu/.pyenv/shims/python", resolvePythonScriptPath("do_opencv.py"));
		processBuilder.redirectErrorStream(true);

		Process process = processBuilder.start();
	//	List<String> results = readProcessOutput(process.getInputStream());
	//	System.out.println(results);

		int exitCode = process.waitFor();
		System.out.println(exitCode);
		System.out.println("-------------------------------------------------");

        ScriptEngineManager manager = new ScriptEngineManager();
		List<ScriptEngineFactory> engines = manager.getEngineFactories();

		for (ScriptEngineFactory engine : engines) {
			System.out.println("Engine name:"+ engine.getEngineName());
			System.out.println("Version:"+ engine.getEngineVersion());
			System.out.println("Language:"+ engine.getLanguageName());

			System.out.println("\nShort Names:");
			for (String names : engine.getNames()) {
				System.out.println(names);
			}
		}
	}
 /*	private static List<String> readProcessOutput(InputStream inputStream) throws IOException {
		return IOUtils.readLines(inputStream, "UTF-8");
	}*/

	private static String resolvePythonScriptPath(String filename) {
		File file = new File("/home/ubuntu/program/" + filename);
		return file.getAbsolutePath();
	}
}
	
	
		
	/*	Runtime runtime = Runtime.getRuntime();
        String analysisFilePath = "/Users/ruimac/study/do_opencv.py"; // mecabで形態素解析したいtxtファイルを指定

        String[] Command = { "/bin/bash", "-c", "python" + analysisFilePath }; // cmd.exeでmecab.exeを起動し指定したファイル(filePath)を形態素解析する

        Process p = null;
        File dir = new File("/Users/ruimac/study");// 実行ディレクトリの指定
        try {
            p = runtime.exec(Command, null, dir); // 実行ディレクトリ(dir)でCommand(mecab.exe)を実行する
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            p.waitFor(); // プロセスの正常終了まで待機させる
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        InputStream is = p.getInputStream(); // プロセスの結果を変数に格納する
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); // テキスト読み込みを行えるようにする
     
        while (true) {
            String line = br.readLine();
            System.out.println("line :" + line);
            if (line == null) {
                break; // 全ての行を読み切ったら抜ける
            } else {
                System.out.println("aaa : " + line); // 実行結果を表示
            }
        }
	}
	
}
		
		
		
		
		ProcessBuilder processBuilder = new ProcessBuilder("python", resolvePythonScriptPath("do_opencv.py"));
		processBuilder.redirectErrorStream(true);

		Process process = processBuilder.start();
		List<String> results = readProcessOutput(process.getInputStream());
		System.out.println(results);
		
		int exitCode = process.waitFor();
		 
		System.out.println(exitCode);
		System.out.println("-------------------------------------------------");

        ScriptEngineManager manager = new ScriptEngineManager();
		List<ScriptEngineFactory> engines = manager.getEngineFactories();

		for (ScriptEngineFactory engine : engines) {
			System.out.println("Engine name:"+ engine.getEngineName());
			System.out.println("Version:"+ engine.getEngineVersion());
			System.out.println("Language:"+ engine.getLanguageName());

			System.out.println("\nShort Names:");
			for (String names : engine.getNames()) {
				System.out.println(names);
			}
		}
	}
		
		private static List<String> readProcessOutput(InputStream inputStream) throws IOException {
			return IOUtils.readLines(inputStream, "UTF-8");
		}

		private static String resolvePythonScriptPath(String filename) {
			File file = new File("/Users/ruimac/study/" + filename);
			return file.getAbsolutePath();
		}

}*/



//String aa = "/Users/ruimac/study/do_opencv.py";
        /*
        	ProcessBuilder p = new ProcessBuilder(Arrays.asList(
    		        "python", "/Users/ruimac/study/do_opencv.py")); 
    		     
        
        p.redirectErrorStream(true);

        
        Process process = p.start();
        process.waitFor();
        }
        catch(IOException | InterruptedException e)
        {
        	System.out.println("例外が発生しました。");
            System.out.println(e);
        }
	}*/

