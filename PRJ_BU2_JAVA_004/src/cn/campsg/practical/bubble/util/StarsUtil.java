package cn.campsg.practical.bubble.util;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
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
	/**
	 * ��¡һ���µ������ǡ�
	 * 
	 * @param star
	 *            ����¡��������
	 * @return �µ������ǣ������ڴ��ַ�������ǣ���
	 */
	/******************** PRJ-BU2-JAVA-004 Task1 ********************/
	 public static void main(String[] args){
		 Star star = new Star(new Position(5,5),StarType.RED);
		 Star star1 = clone(star);
		// System.out.println(star);
		// System.out.println(star1);
		 
		 System.out.println("ԭ�����Ƕ���Ϊ��" + "(" + star.getPosition().getRow() + "," +star.getPosition().getColumn() + "-" + star.getType() + ")");
		 System.out.println("��¡�����Ƕ���Ϊ��" + "(" + star1.getPosition().getRow() + "," +star1.getPosition().getColumn() + "-" + star1.getType() + ")");
		 System.out.println("�������Ƿ�һ�£�" + star.equals(star1) );
		 System.out.println("���������������Ƿ�һ�£�" + star.equals(star1) );
	 }
		public static Star clone(Star star){
			Star star1;
			int row = star.getPosition().getRow();
			int column = star.getPosition().getColumn();
		    star1 = new Star(new Position(row,column),star.getType());
		    return star1;
		} 
		
	
	
	
	
	
	
	
	
	
	/**************************************************************/
}
