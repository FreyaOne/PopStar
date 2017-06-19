package cn.campsg.practical.bubble.entity;

//import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.Position;

public class MovedStar extends Star{
	public static void main(String[] args){
		
		 
		Position testPosition = new Position(0,0);
		Position test1Position = new Position(1,1);
		MovedStar moveStar = new MovedStar(testPosition,StarType.RED,test1Position); 
		System.out.println(moveStar.toString());
		
		
		
		/*StarType testType =StarType.RED;
		System.out.println("泡泡糖原位置：" + "(" + testPosition.getRow() + "," + testPosition.getColumn() + ")");
		System.out.println("泡泡糖移动的目标位置位置：" + "(" + test1Position.getRow() + "," + test1Position.getColumn() + ")");
		System.out.println("泡泡糖的颜色为：" + testType);*/
	}
	private Position movedPosition = new Position();
	
	 
	public MovedStar() {
			
		}
		public MovedStar(Position position, StarType type, Position movedPosition){
			super(new Position(position.getRow(),position.getColumn()), type);
			//this.position = position;
			//this.type1 = type1;
			this.movedPosition = movedPosition;
						
		}
		public Position getMovedPosition() {
			return movedPosition;
		}
		public void setMovedPosition(Position movedPosition) {
			this.movedPosition = movedPosition;
		}
		@Override
		public String toString() {
			String str3 = super.toString() + "\nnew position : (" +  movedPosition.getRow() + "," + movedPosition.getColumn() + ")";
			return str3;
		}
		
		

}
	

