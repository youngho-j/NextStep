package ladder;

import core.NaturalNumber;
// height, numberOfPerson 정보를 쌍으로 갖는 역할
public class Position {
	
	private NaturalNumber height;
	private NaturalNumber numOfPerson;
	
	private Position(NaturalNumber height, NaturalNumber numOfPerson) {
		this.height = height;
		this.numOfPerson = numOfPerson;
	}
	
	public NaturalNumber getHeight() {
		return height;
	}

	public NaturalNumber getNumOfPerson() {
		return numOfPerson;
	}

	static Position create(int height, int numOfPerson) {
		return new Position(new NaturalNumber(height), new NaturalNumber(numOfPerson));
	}
	
	static Position create(NaturalNumber height, NaturalNumber numOfPerson) {
		return new Position(height, numOfPerson);
	}
	
	static Position createFromArrayIndex(int height, int numOfPerson) {
		return new Position(NaturalNumber.createFromArrayIndex(height), 
				NaturalNumber.createFromArrayIndex(numOfPerson));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((numOfPerson == null) ? 0 : numOfPerson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (numOfPerson == null) {
			if (other.numOfPerson != null)
				return false;
		} else if (!numOfPerson.equals(other.numOfPerson))
			return false;
		return true;
	}

	// 사용자 객체 출력을 보기 위해 오버라이딩
	@Override
	public String toString() {
		return "Position [height=" + height + ", numOfPerson=" + numOfPerson + "]";
	}
}
