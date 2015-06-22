package SimRace;

public class StartRace {

	public static void main(String[] args) {
		int carCount = Integer.parseInt(args[0]);
		int roundCount = Integer.parseInt(args[1]);
		SimRace race = new SimRace(carCount, roundCount);
		race.start();
	}

}
