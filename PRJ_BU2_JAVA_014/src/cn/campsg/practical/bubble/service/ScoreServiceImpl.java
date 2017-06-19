package cn.campsg.practical.bubble.service;


import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import cn.campsg.practical.bubble.entity.Score;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * ��������������Ϊ�����ṩ���¹���<br>
 * 1. ����ؿ�ͨ�ط���<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 1.1
 *
 */
public class ScoreServiceImpl implements ScoreService {

	/*******PRJ-BU2-JAVA-014 Test1 ��1/3 Start��************/
	/**
	 * ��õ�ǰ�ص�ͨ�ط���
	 * 
	 * @return ������ĵ÷�
	 * 
	 */
	Configuration configuration = null;
	
	public ScoreServiceImpl(){
		configuration = new Configuration();
	}
	@Override
	
	public int getCurrentLevelScore() {

		return configuration.getScore().getLevelScore();
	}
	/*******PRJ-BU2-JAVA-014 Test1 ��1/3 End��**************/
	
	/**
	 * ����Ҫ�л��Ĺؿ��ȼ���ȡĿ�����
	 * 	
	 * @param ��һ�عؿ�
	 * @return ������ĵ÷�
	 * 
	 */
	/*******PRJ-BU2-JAVA-014 Test2 ��2/3 Start��************/
	@Override
	public int nextScoreByLevel(int nextLevel) {
			int x = (nextLevel - 1)/4 * 1000;
			int nextLevelScore = configuration.getScore().getLevelScore() + 2000 + x;
			configuration.getScore().setLevelScore(nextLevelScore);
		
		return nextLevelScore;
	}
	/*******PRJ-BU2-JAVA-014 Test2 ��2/3 End��**************/

	/**
	 * ���ݱ��ؿ���������صĹؿ��÷�
	 * 
	 * @param level
	 *            ��һ�عؿ�
	 * @return ���صĹؿ��÷�
	 */
	
	@Override
	public boolean isChangeLevel(int score) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public int getScoreByStars(StarList stars) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScoreByStars(int stars) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAwardScore(int awardStarNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNoticePassLevel(int currentLevel, int score) {
		// TODO Auto-generated method stub
		return false;
	}

}
