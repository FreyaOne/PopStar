package cn.campsg.practical.bubble.util;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.entity.Star.StarType;

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
	//�������
	public static void main(String[] args){
		StarList starList = new StarList();
		Star star1 = new Star(new Position(2,3),StarType.BLUE);
		Star star2 = new Star(new Position(1,5),StarType.GREEN);
		Star star3 = new Star(new Position(0,9),StarType.PURPLE);
		Star star4 = new Star(new Position(0,3),StarType.RED);
		Star star5 = new Star(new Position(0,8),StarType.YELLOW);
		starList.add(star1);
		starList.add(star2);
		starList.add(star3);
		starList.add(star4);
		starList.add(star5);
		Map map = group(starList);
		System.out.println("�����:" + map);
		
		//System.out.println("����ǰ��starList��\n" + starList);
		//sort(starList);
		//System.out.println("�����starList��\n" + starList);
		
	}
	/**
	 * ����ָ���б��е�������<br>
	 * ������򣺰������������������ͬ������������<br>
	 * �����㷨��ð������
	 * 
	 * @param starList
	 *            ��������������б�
	 */
	public static void sort(StarList starList) {
		/*****PRJ-BU2-JAVA-012 Task1 ��1/3 Start��*******/
		for (int i = 0; i < starList.size() - 1; i++) {
			for (int j = 0; j < starList.size() - i - 1; j++) {
				// ��ȡ��N��������
				Star preStar = starList.get(j);
				// ��ȡ��N�������ǵĺ�һ�������ǣ�N+1��
				Star nextStar = starList.get(j + 1);

				if (preStar.getPosition().getColumn()> nextStar.getPosition().getColumn()) {
					swap(preStar, nextStar);
					continue;
				}
				else if(preStar.getPosition().getColumn() == nextStar.getPosition().getColumn()){
					if(preStar.getPosition().getRow()> nextStar.getPosition().getRow()){
						swap(preStar, nextStar);
					}
				}
			}
		}
		/*****PRJ-BU2-JAVA-012 Task1 ��1/3 End��********/
	}


	/**
	 * ��������򽻻��������������б��е�ֻ
	 * 
	 * @param preStar
	 *            ��N��������
	 * @param nextStar
	 *            ��N+1��������
	 */
	private static void swap(Star preStar, Star nextStar) {
		// ������ʱ���������Ƕ���
		Star tempStar = new Star();

		// ����N�������ǵ����ݱ�������ʱ���������Ƕ���
		tempStar.getPosition().setRow(preStar.getPosition().getRow());
		tempStar.getPosition().setColumn(preStar.getPosition().getColumn());
		tempStar.setType(preStar.getType());

		// ����N+1�������ǵ����ݱ������N��������
		preStar.getPosition().setRow(nextStar.getPosition().getRow());
		preStar.getPosition().setColumn(nextStar.getPosition().getColumn());
		preStar.setType(nextStar.getType());

		// ����ʱ���������Ƕ�������ݱ������N+1��������
		nextStar.getPosition().setRow(tempStar.getPosition().getRow());
		nextStar.getPosition().setColumn(tempStar.getPosition().getColumn());
		nextStar.setType(tempStar.getType());
	}

	/**
	 * ���кŶ������Ǽ����������ǽ��з��飨��ͬ�кŵ������Ƿ���һ������У�<br>
	 * ����ǰӦ���ȶ������Ǽ��Ͻ�������
	 * 
	 * @see sort
	 * 
	 * @param mStarList
	 *            ��������������б�
	 * @return 
	 *         ��������Map�е�key���кţ�value����ͬ�е������Ǽ��ϣ����磺1-{(1,2);(1,3);(1,4)}��2-{(2,2)
	 *         ;(2,3);(2,4)}
	 */
	/*****PRJ-BU2-JAVA-012 Task2 ��2/3 Start��*******/
	public static Map<Integer, StarList> group(StarList clearStars){
		Map<Integer, StarList> map = new HashMap<Integer, StarList>();
		sort(clearStars);
		Star star = null;
		StarList starList = null;
		for(int i =0;i< clearStars.size();i++){
			star = clearStars.get(i);
			if( (starList = map.get(star.getPosition().getColumn())) != null){
				starList.add(star);
			}else{
				starList = new StarList();
				starList.add(star);
				map.put(star.getPosition().getColumn(), starList);
			}
		}
		return map;
	}

	
	
		
	
	
	/*****PRJ-BU2-JAVA-012 Task2 ��2/3 End��*********/

	/**
	 * ��¡һ���µ������ǡ�
	 * 
	 * @param star
	 *            ����¡��������
	 * @return �µ������ǣ������ڴ��ַ�������ǣ���
	 */
	public static Star clone(Star star) {

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
