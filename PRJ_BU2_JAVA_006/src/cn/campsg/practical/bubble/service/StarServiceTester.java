package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;

public class StarServiceTester implements StarService{
	public static void main(String[] args){
		StarServiceTester starServiceTester = new StarServiceTester();
		System.out.println(starServiceTester.createStars());
	}
	
	public StarServiceTester() {
		
	}

	@Override
	public StarList createStars() {
		StarList starList = new StarList();
		Star star1 = new Star(new Position(0,0),StarType.BLUE);
		Star star2 = new Star(new Position(0,1),StarType.GREEN);
		Star star3 = new Star(new Position(1,0),StarType.PURPLE);
		Star star4 = new Star(new Position(1,1),StarType.YELLOW);
		Star star5 = new Star(new Position(0,2),StarType.RED);
		starList.add(star1);
		starList.add(star2);
		starList.add(star3);
		starList.add(star4);
		starList.add(star5);
		return starList;
	}

	@Override
	public StarList tobeClearedStars(Star base, StarList sList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StarList getYMovedStars(StarList clearStars, StarList currentStarList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StarList getXMovedStars(StarList currentStarList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StarList getAwardStarList(StarList currentStarList) {
		// TODO Auto-generated method stub
		return null;
	}

}
