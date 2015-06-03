
public class Car extends Thread{
	private int _carName;
	private int _raceTime;
	private SimRace _race;
	
	public Car(int carName, SimRace race){
		this._carName = carName;
		this._race = race;
	}
	
	public void startRace(int roundCount){
		int roundTime;
		for(int i = 0; i < roundCount;i++){
			roundTime = getRoundTime();
			_raceTime += getRoundTime();
			try {
				sleep(roundTime);
			} catch (InterruptedException e) {

			}
			System.err.println(_carName + " has finished round #"+i+" in "+roundTime+" ms.");
		}
		_race.registerFinishedCar(this,_raceTime);
	}	
	
	public void run() {
		startRace(_race.get_roundCount());
	}

	public int getRoundTime(){
		   return (int)(Math.random()*(100)+1);
	}
	
	public int getCarName() {
		return _carName;
	}
	public int getRaceTime() {
		return _raceTime;
	}
	public void setName(int name){
		_carName = name;
	}
	
}
