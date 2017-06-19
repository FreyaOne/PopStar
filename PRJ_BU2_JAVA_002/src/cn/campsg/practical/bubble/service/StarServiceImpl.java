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
	 * 消除泡泡糖后，获取待移动泡泡糖列表(仅限水平列表的泡泡糖)<br>
	 * 该功能固定在垂直列表的泡泡糖之后运行
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * 
	 * @return 待移动泡泡糖列表
	 */
	public StarList getXMovedStars(StarList currentStarList) {
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
