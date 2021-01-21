/*
package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerSample {
	public static void main(String[] args) {
		
		// Loggerクラスのインスタンスを生成
        Logger logger = Logger.getLogger(LoggerSample.class.getName());
        
        try {
            // Handlerを生成しloggerに登録
            FileHandler fHandler = new FileHandler("ここにパスを書き込むログファイルを作る.Sample.log", true);
            fHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fHandler);
 
            // ログレベルの設定
            logger.setLevel(Level.INFO);
 
            // Loggerクラスのメソッドを使ってメッセージを出力
            logger.finest("FINEST");
            logger.finer("FINER");
            logger.fine("FINE");
            logger.config("CONFIG");
            logger.info("INFO");
            logger.warning("WARNING");
            logger.severe("SEVERE");
 
            // 例外をスロー
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            logger.log(Level.INFO, "例外のスローを捕捉", e);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}

}*/
