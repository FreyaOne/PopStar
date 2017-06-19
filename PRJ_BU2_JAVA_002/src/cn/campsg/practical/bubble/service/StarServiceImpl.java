package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * ������ҵ���������࣬����Ϊ�����ṩ���·���<br>
 * 1. ������Ļ�������������<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	/**
	 * ������Ļ������������ǣ�10 * 10��
	 * 
	 * @return �������б�-��������ʾ
	 */
	@Override
	public StarList createStars() {
		StarList sList = new StarList();
		Star star1 = new Star();
		
		Star star2 = new Star();
		
		Star star3 = new Star();
		
		Star star4 = new Star();
		
		Star star5 = new Star();
		
		star1.setPosition(new Position(0,0));
    	star1.setType(StarType.BLUE);
    	star2.setPosition(new Position(1,1));
    	star2.setType(StarType.RED);
    	star3.setPosition(new Position(2,2));
    	star3.setType(StarType.YELLOW);
    	star4.setPosition(new Position(3,3));
    	star4.setType(StarType.GREEN);
    	star5.setPosition(new Position(4,4));
    	star5.setType(StarType.PUPPLE);
    	sList.add(star1);
		sList.add(star2);
		sList.add(star3);
		sList.add(star4);
		sList.add(star5);
    	
//		Star star1 = new Star();
//		Star star2;
//		
//		star1.setPosition(new Position(0,0));
//		star1.setType(StarType.BLUE);
//		star2 = new Star(new Position(1,1),StarType.GREEN);
//		System.out.println("" + "("+ star1.getPosition().getRow() +")," +"("+ star1.getPosition().getRow() +")" + " - " + star1.getType());
//		System.out.println("" + "("+ star2.getPosition().getRow() +")," +"("+ star2.getPosition().getRow() +")" + " - " + star2.getType());
//		System.out.println(StarType.BLUE.value());
//		System.out.println(StarType.valueOf(1));
//      return 0;
		return sList;
	}

	public StarList getYMovedStars(StarList clearStars,
			StarList currentStarList) {
		return null;
	}

	/**
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(����ˮƽ�б��������)<br>
	 * �ù��̶ܹ��ڴ�ֱ�б��������֮������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * 
	 * @return ���ƶ��������б�
	 */
	public StarList getXMovedStars(StarList currentStarList) {
		return null;
	}

	/**
	 * �ж��Ƿ񻹴���δ������������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return true:��Ȼ��δ������������,false:û��δ������������
	 * 
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		return false;
	}

	/**
	 * ��ȡ�޷������������б�
	 * 
	 * @param curretStars
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return �޷������������б�
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		return null;
	}

}
