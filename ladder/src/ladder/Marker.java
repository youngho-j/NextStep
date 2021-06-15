package ladder;

// 방향을 결정해주는 클래스(상속을 받아 자연수 속성을 가지면서 방향 결정)
// 객체 비교시 부모 클래스에 오버라이딩된 hashCode, equals 메서드를 불러옴
class Marker extends NaturalNumber{
	
	Marker(int number) {
		//상속을 받았기때문에 부모클래스에 넘겨줌
		super(number);
	}

	Marker moveRight() {
		return new Marker(getNumber() + 1);
	}
	Marker moveLeft() {
		return new Marker(getNumber() - 1);
	}
}
