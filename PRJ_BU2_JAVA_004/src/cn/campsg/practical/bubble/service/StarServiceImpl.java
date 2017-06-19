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

		StarList stars = new StarList();
		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {
			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {
				Star star = new Star();
				// �����������ڻ����ϵ�λ��
				star.setPosition(new Position(row, col));
				// ���������������
				if(row>=3&&row<=6 && col>=3&&col<=6){
					star.setType(StarType.RED);
				}else{
					star.setType(StarType.YELLOW);
				}
				// �����б�
				stars.add(star);
			}
		}
		return stars;
	}
	
	/**
	 * �Ը��������ǣ��û�����ģ�Ϊ�����������ҡ�����·������Ѱ����ͬ���͵�������
	 * 
	 * @param base
	 *            ���������ǣ��û�����ģ�
	 * @param sList
	 *            ԭʼ�������б������������е������ǣ�
	 * @param clearStars
	 *            ��������������б�
	 */
	private void lookupByPath(Star base, StarList sList, StarList clearStars) {
		/******************** PRJ-BU2-JAVA-004 Task2 ********************/
		int row = base.getPosition().getRow();
		int column = base.getPosition().getColumn();
		StarType  type = base.getType();
		Star lStar;
		if(column - 1 >= 0){
			lStar = sList.lookup(row, (column - 1));
			if(lStar != null){
				if(!clearStars.existed(lStar)){
					if(lStar.getType() == type){
						clearStars.add(lStar);
						lookupByPath(lStar, sList, clearStars);
					}
				}
			}
			
		}
		
			
		
		
		
		
		
		
		
		
		/**************************************************************/

		/******************** PRJ-BU2-JAVA-004 Task3 ********************/
		Star rStar;
		if(column + 1 < MAX_COLUMN_SIZE){
			rStar = sList.lookup(row, (column + 1));
			if(rStar != null){
				if(!clearStars.existed(rStar)){
					if(rStar.getType() == type){
						clearStars.add(rStar);
						lookupByPath(rStar, sList, clearStars);
					}
				}
			}
			
		}

		
		
		
		
		
		
		
		
		/**************************************************************/

		/******************** PRJ-BU2-JAVA-004 Task4 ********************/
		Star uStar;
		if(row - 1 >= 0){
			uStar = sList.lookup((row - 1), column);
			if(uStar != null){
				if(!clearStars.existed(uStar)){
					if(uStar.getType() == type){
						clearStars.add(uStar);
						lookupByPath(uStar, sList, clearStars);
					}
				}
			}
			
		}


		
		
		
		
		
		
		
		
		/**************************************************************/

		/******************** PRJ-BU2-JAVA-004 Task5 ********************/
		Star dStar;
		if(row + 1 >= 0){
			dStar = sList.lookup((row + 1), column);
			if(dStar != null){
				if(!clearStars.existed(dStar)){
					if(dStar.getType() == type){
						clearStars.add(dStar);
						lookupByPath(dStar, sList, clearStars);
					}
				}
			}
			
		}
		
		
		
		
		
		
		/**************************************************************/

		// �����ĸ��ж϶����������ʾ���ܶ�û���������ˣ���ô�����ݹ鷽����
	}

	/**
	 * �û���������ǣ���ȡ���������������������б�
	 * 
	 * @param base
	 *            ���û������������
	 * @param sList
	 *            ��ǰ���������ݵ��б�
	 * @return ��Ҫ�����������
	 */
	@Override
	public StarList tobeClearedStars(Star base, StarList mCurrent) {
		/******************** PRJ-BU2-JAVA-004 Task2 ********************/
		StarList clearStars1 = new StarList();
		clearStars1.add(base);
		lookupByPath(base,mCurrent,clearStars1);
		if(clearStars1.size() == 1){
			clearStars1.clear();
		}
		
		
		
		
		
		
		return clearStars1;
		/**************************************************************/
	}

	public StarList getVMovedStars(StarList clearStars,
			StarList currentStarList) {
		return null;
	}

	/**
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(����ˮƽ�б���������)<br>
	 * �ù��̶ܹ��ڴ�ֱ�б���������֮������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б����Ѿ�����������������null��ʾ��
	 * 
	 * @return ���ƶ��������б�
	 */
	public StarList getHMovedStars(StarList currentStarList) {
		return null;
	}

	/**
	 * �ж��Ƿ񻹴���δ������������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б����Ѿ�����������������null��ʾ��
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
	 *            ��ǰ�����Ľ����������б����Ѿ�����������������null��ʾ��
	 * @return �޷������������б�
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		return null;
	}
}