package cn.campsg.practical.bubble.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;





import cn.campsg.practical.bubble.entity.Score;

public class Configuration {
	public final static String FILE_NAME = "score.conf";//���·��
	private Score score  = null;
	public Configuration() {
		score = new Score();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		BufferedReader bufferedReader = new BufferedReader(new   InputStreamReader(inputStream)); //ΪInputStream����
		try{
			score.setLevelScore(Integer.parseInt(bufferedReader.readLine()));
			score.setStep(Integer.parseInt(bufferedReader.readLine()));
			score.setIncrement(Integer.parseInt(bufferedReader.readLine()));
			score.setLength(Integer.parseInt(bufferedReader.readLine()));
			//�ر��ļ������ȡ��
			bufferedReader.close();
			
		}catch (FileNotFoundException e) {
			score = null;
			System.out.println("δ�ҵ��ļ�");
		}catch (IOException e) {
			score = null;
			System.out.println("�ļ���ȡʧ��");
		}
		
	}
	
	
	public Score getScore(){
		return score;
		 
	}
}
