package cn.campsg.practical.bubble.util;

//import com.sun.corba.se.spi.orb.StringPair;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * ������/���ƶ�������ʵ���๤���࣬�ṩ���¹��ܣ�<br>
 * <ul>
 * <li>1. ����ָ���б��е�������-����������������ͬ������������ð�������㷨����</li>
 * <li>2. ��ָ���б��е������ǰ��з��顣</li>
 * <li>3. ��¡һ�������Ƕ���</li>
 * </ul>
 * 
 * @see cn.campsg.practical.bubble.entity.Star
 * @see cn.campsg.practical.bubble.entity.MovedStar
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 *
 */
public class StarsUtil {
	
	/**
	 * ����ָ���б��е�������<br>
	 * ������򣺰������������������ͬ������������<br>
	 * �����㷨��ð������
	 * 
	 * @param starList
	 *            ��������������б�
	 */
	/************ PRJ-BU2-JAVA-010 Task2 ��2/3 start��***************/
	 public static void sort(StarList starList){
		for(int i = 0;i<starList.size() - 1;i++){
			for(int j = 0;j<starList.size() -i-1 ;j++){
				Star star1 = starList.get(j);
				Star star2 = starList.get(j+1);
				if(star1.getPosition().getRow() >star2.getPosition().getRow()){
					swap(star1, star2);
				}
			}
		}
	}
	
	
	
	
	
	
	
	/************ PRJ-BU2-JAVA-010 Task2 ��2/3 end��*****************/
	
	/**
	 * �����������������б��е�λ��
	 * 
	 * @param preStar
	 *            ��N��������
	 * @param nextStar
	 *            ��N+1��������
	 */
	/************ PRJ-BU2-JAVA-010 Task1 ��1/3 start��***************/
	private static void swap(Star star1,Star star2){
		Star star = new Star();
		//int x1, y1,x2,y2;
		//x1 = star1.getPosition().getRow();
		//y1 = star1.getPosition().getColumn();
		//x2 = star2.getPosition().getRow();
		//y2 = star2.getPosition().getColumn();
		
		//Star star = star =  new Star(new Position(x1,y1),star1.getType());
		star.setPosition(star1.getPosition());
		star.setType(star1.getType());
		star1.setPosition(star2.getPosition());
		star1.setType(star2.getType());
		star2.setPosition(star.getPosition());
		star2.setType(star.getType());
		
		
		//System.out.println(star);
		//star1 = new Star(new Position(x2,y2),star2.getType());
		//System.out.println(star1);
		//star2 = star;
		//System.out.println(star2);
		
	} 

	
	
	
	
	
	
	
	/************ PRJ-BU2-JAVA-010 Task1 ��1/3 end��*****************/
	public static void main(String[] args){
		StarList starList = new StarList();
		Star star1 = new Star(new Position(2,0),StarType.BLUE);
		Star star2 = new Star(new Position(5,0),StarType.GREEN);
		Star star3 = new Star(new Position(9,0),StarType.PURPLE);
		Star star4 = new Star(new Position(3,0),StarType.RED);
		Star star5 = new Star(new Position(8,0),StarType.YELLOW);
		starList.add(star1);
		starList.add(star2);
		starList.add(star3);
		starList.add(star4);
		starList.add(star5);
		System.out.println("����ǰ��starList��\n" + starList );
		sort(starList);
		System.out.println("�����starList��\n" + starList);

		
		/*Star star1 = new Star(new Position(0,0),StarType.BLUE);
		Star star2 = new Star(new Position(1,1),StarType.GREEN);
		//System.out.println("����ǰ: preStar:" + star1 + "nextStar:" + star2  );
		
		swap(star1,star2);
		//System.out.println(star2);
		System.out.println("������: preStar:" + star1 + "nextStar:" + star2);*/
	}
	/**
	 * ��¡һ���µ������ǡ�
	 * 
	 * @param star
	 *            ����¡��������
	 * @return �µ������ǣ������ڴ��ַ�������ǣ���
	 */
	public static Star copy(Star star) {

		Star ret = new Star();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}

	public static MovedStar toMovedStar(Star star) {

		MovedStar ret = new MovedStar();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}
}

