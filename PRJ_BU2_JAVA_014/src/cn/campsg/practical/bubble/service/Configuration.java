package cn.campsg.practical.bubble.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;





import cn.campsg.practical.bubble.entity.Score;

public class Configuration {
	public final static String FILE_NAME = "score.conf";//添加路径
	private Score score  = null;
	public Configuration() {
		score = new Score();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		BufferedReader bufferedReader = new BufferedReader(new   InputStreamReader(inputStream)); //为InputStream对象。
		try{
			score.setLevelScore(Integer.parseInt(bufferedReader.readLine()));
			score.setStep(Integer.parseInt(bufferedReader.readLine()));
			score.setIncrement(Integer.parseInt(bufferedReader.readLine()));
			score.setLength(Integer.parseInt(bufferedReader.readLine()));
			//关闭文件缓存读取器
			bufferedReader.close();
			
		}catch (FileNotFoundException e) {
			score = null;
			System.out.println("未找到文件");
		}catch (IOException e) {
			score = null;
			System.out.println("文件读取失败");
		}
		
	}
	
	
	public Score getScore(){
		return score;
		 
	}
}
