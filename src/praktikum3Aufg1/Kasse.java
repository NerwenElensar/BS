package praktikum3Aufg1;

import java.util.concurrent.locks.ReentrantLock;

public class Kasse {
	private ReentrantLock _kasse = new ReentrantLock(true);
	private String _name;
	
	public Kasse(String name) {
		this._name = name;	
	}
	
	public void run() {
		
	}
	
	public int getSchlangenLength(){
		return _kasse.getQueueLength();
	}
	
	public String getName() {
		return _name;
	}
	
	public void bezahlen() {
		_kasse.lock();
	}
}
