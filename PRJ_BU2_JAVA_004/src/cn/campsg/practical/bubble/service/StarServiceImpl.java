package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * 泡泡糖业务计算服务类，用于为界面提供以下服务<br>
 * 1. 创建屏幕画布随机泡泡糖<br>
 * 2. 切关判定<br>
 * 3. 根据消除的泡泡计算得分<br>
 * 4. 计算剩余泡泡糖的得分奖励<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	/**
	 * 创建屏幕画布随机泡泡糖（10 * 10）
	 * 
	 * @return 泡泡糖列表-供画面显示
	 */
	@Override
	public StarList createStars() {

		StarList stars = new StarList();
		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {
			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {
				Star star = new Star();
				// 设置泡泡糖在画面上的位置
				star.setPosition(new Position(row, col));
				// 产生随机的泡泡糖
				if(row>=3&&row<=6 && col>=3&&col<=6){
					star.setType(StarType.RED);
				}else{
					star.setType(StarType.YELLOW);
				}
				// 加入列表
				stars.add(star);
			}
		}
		return stars;
	}
	
	/**
	 * 以给定泡泡糖（用户点击的）为基础，向左右、上下路径依次寻找相同类型的泡泡糖
	 * 
	 * @param base
	 *            基础泡泡糖（用户点击的）
	 * @param sList
	 *            原始泡泡糖列表（界面上排列的泡泡糖）
	 * @param clearStars
	 *            待清除的泡泡糖列表
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

		// 以上四个判断都不进，则表示四周都没用泡泡糖了，那么跳出递归方法。
	}

	/**
	 * 用户点击泡泡糖，获取满足消除条件的泡泡糖列表
	 * 
	 * @param base
	 *            被用户点击的泡泡糖
	 * @param sList
	 *            当前画面上泡泡的列表
	 * @return 需要清除的泡泡糖
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
	 * 消除泡泡糖后，获取待移动泡泡糖列表(仅限水平列表的泡泡糖)<br>
	 * 该功能固定在垂直列表的泡泡糖之后运行
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * 
	 * @return 待移动泡泡糖列表
	 */
	public StarList getHMovedStars(StarList currentStarList) {
		return null;
	}

	/**
	 * 判断是否还存在未消除的泡泡糖
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return true:任然有未消除的泡泡糖,false:没有未消除的泡泡糖
	 * 
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		return false;
	}

	/**
	 * 获取无法消除泡泡糖列表
	 * 
	 * @param curretStars
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 无法消除泡泡糖列表
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		return null;
	}
}
