public class ScreenStateNotifyer implements EventObserver{
    private static ScreenStateNotifyer instance = null;
    private ScreenStateNotifyer(){
    }

    public static ScreenStateNotifyer getInstance(){
        if(null == instance)
            instance = new ScreenStateNotifyer();
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