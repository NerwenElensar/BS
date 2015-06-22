package SimRace;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class SimRace extends Thread {
	
	private int _carCount;
	private int _roundCount;
	private Map<Car, Integer> _carTable;
	private	List<Car> _finishedCars = new ArrayList<>();
	
	public SimRace(int carCount, int roundCount){
		this._carCount = carCount;
		this._roundCount = roundCount;
	}
	
	public void run() {
		for(int i = 0; i < _carCount; i++){
			Car raceCar = new Car(i, this);
			_finishedCars.add(raceCar);
			raceCar.start();	
		}
		for (Car car : _finishedCars) {
				try {
					car.join();
				} catch (InterruptedException e) {
			}
		}
		
		generateList(_finishedCars);
	}

	public void registerFinishedCar(Car car, int raceTime) {
		_carTable = new HashMap<>(_carCount);
		_carTable.put(car, raceTime);		
	}
	
	public void generateList(List<Car> finishedCars){
		finishedCars.sort(new carSort());
		int i = 1;
		for(Car c: finishedCars){
			System.out.println(i +". Platz: Wagen " + c.getCarName() + " Zeit: " + c.getRaceTime());
			i++;
		}
	}
	
	public int get_carCount() {
		return _carCount;
	}

	public int get_roundCount() {
		return _roundCount;
	}
	
	private class carSort implements Comparator<Car>{
		@Override
		public int compare(Car car1, Car car2) {
			return (int)(car1.getRaceTime() - car2.getRaceTime());
		}	
	}
}
