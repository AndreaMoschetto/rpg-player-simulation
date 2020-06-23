import java.util.List;
import java.util.ArrayList;

public class EventSubject {
    private List<EventObserver> observers; 

    public EventSubject(){
        observers = new ArrayList<>();
    }
    public void attach(EventObserver observer){
        observers.add(observer);
    }
    public void detach(EventObserver observer){
        if(observers.contains(observer))
            observers.remove(observer);
    }
    protected void updateAll(){
        observers.stream()
            .forEach(EventObserver::update);
    }
}