package mvc.util;

public interface Subject {
	
	void attach(Observer o);
	
	void detach(Observer o);
	
	void notifyObservers();

}
