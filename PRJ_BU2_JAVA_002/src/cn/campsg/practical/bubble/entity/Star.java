package cn.campsg.practical.bubble.entity;

public class Star {
	Position position;
	StarType type = StarType.BLUE;
	public Star() {
		
	}
	public Star(Position position, StarType type){
		this.position = position;
		this.type = type;
	}
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public StarType getType() {
		return type;
	}

	public void setType(StarType type) {
		this.type = type;
	}

	public static enum StarType{
		BLUE(0),GREEN(1),YELLOW(2),RED(3),PUPPLE(4);
		private int value;
		public int value(){
			return value;
		}
		private StarType(){
			
		}
		private StarType(int value) {
			this.value = value;
		}
		public static StarType valueOf(int value){
			switch(value){
			case 0:
				return BLUE;
			case 1:
				return GREEN;
			case 2:
				return YELLOW;
			case 3:
				return RED;
			case 4:
				return PUPPLE;
			default:
				return null;
			}
		}
	}
}
