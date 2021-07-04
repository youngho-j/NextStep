package ladder.creator;

import java.util.ArrayList;
import java.util.Random;

import core.NaturalNumber;
import ladder.LadderSize;
import ladder.Position;
import ladder.RandomNaturalNumber;
import ladder.Row;

public class RandomLadderCreator implements LadderCreator {

	private static final double DEFAULT_LINE_RATIO = 0.3;

	private LadderSize ladderSize;

	private ManualLadderCreator ladderCreator;

	// 조합을 통한 중복제거 - 내부에서 Manual.. 생성 후 Random에서 Manual의 기능을 사용할 수 있도록 위임
	// 해당 파라미터를 LadderCreator 인터페이스로 바꾸면 더 좋지만
	// getter 메서드가 노출이 되므로 별로 좋지 않을 듯..
	public RandomLadderCreator(ManualLadderCreator ladderCreator) {
		this.ladderCreator = ladderCreator;
		this.ladderSize = ladderCreator.getLadderSize();

		ArrayList<Position> startPositions = generateStartPositions();
		for (Position position : startPositions) {
			ladderCreator.drawLine(position.getHeight(), position.getNumOfPerson());
		}
	}

	@Override
	public Row[] getLadder() {
		return ladderCreator.getLadder();
	}

	@Override
	public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
		throw new UnsupportedOperationException("RandomLadderCreator에서는 drawLine 메서드 호출 불가");
	}

	ArrayList<Position> generateStartPositions() {
		ArrayList<RandomNaturalNumber> numbers = generateRandomPositions();
		return toPostions(numbers);
	}

	// 랜덤 위치 정보를 구하는 메서드
	ArrayList<RandomNaturalNumber> generateRandomPositions() {
		NaturalNumber totalPositions = ladderSize.getTotalPosition();
		int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
		// 랜덤위치 정보를 담아두는 배열
		ArrayList<RandomNaturalNumber> randomPositions = new ArrayList<RandomNaturalNumber>();
		
		do {
			RandomNaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
			
			if (ladderSize.isMultipleOfPerson(randomPosition)) {
				continue;
			}

			ArrayList<RandomNaturalNumber> checkedNaturalNumbers = randomPosition.checkedNaturalNumbers(ladderSize.getNumOfPerson());
			checkedNaturalNumbers.retainAll(randomPositions);
			
			if(checkedNaturalNumbers.isEmpty()) {
				randomPositions.add(randomPosition);
				System.out.println(String.format("random position : %s", randomPosition));
			}

		} while (randomPositions.size() < countOfLine);

		return randomPositions;
	}

	// 2차원 배열로 변경
	ArrayList<Position> toPostions(ArrayList<RandomNaturalNumber> randomNumbers) {
		ArrayList<Position> positions = new ArrayList<Position>(randomNumbers.size());
		for(RandomNaturalNumber randomNumber : randomNumbers) {
			positions.add(ladderSize.getPosition(randomNumber));
		}
		return positions;
	}

	// 랜덤 수 생성
	static RandomNaturalNumber randInt(int min, int max) {
		Random rand = new Random();
		return new RandomNaturalNumber(rand.nextInt((max - min) + 1) + min);
	}

	// 랜덤으로 생성된 지점이 배열에 해당 값과 같은 값이 존재하는지 안하는지 검사
	public static boolean isExisted(NaturalNumber[] startPositions, NaturalNumber randomPosition) {
		for (NaturalNumber each : startPositions) {
			if (randomPosition.equals(each)) {
				return true;
			}
		}
		return false;
	}
}
