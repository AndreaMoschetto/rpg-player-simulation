public class ScreenStateNotifier implements EventObserver{
    private static ScreenStateNotifier instance = null;
    private ScreenStateNotifier(){
    }

    public static ScreenStateNotifier getInstance(){
        if(null == instance)
            instance = new ScreenStateNotifier();
        return instance;
    }

    public void init(){
        Player.getInstance().attach(this);
    }

    @Override
    public void update() {
        String stateName = Player.getInstance().getStateName();
        System.out.println("[NOTIFICA] Valoroso ha appena raggiunto lo stato: " + stateName);
        System.out.println(Player.getInstance().getStateDescription());
    }
    
}