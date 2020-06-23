public class ScreenStateNotifyer implements EventObserver{
    private static ScreenStateNotifyer instance;
    private ScreenStateNotifyer(){
        Player.getInstance().attach(this);
    }

    public static ScreenStateNotifyer ScreenStateNotifyer(){
        if(null == instance)
            instance = new ScreenStateNotifyer();
        return instance;
    }
    @Override
    public void update() {
        String stateName = Player.getInstance().getStateName();
        System.out.println("[NOTIFICA] Valoroso ha appena raggiunto lo stato: " + stateName);
    }
    
}