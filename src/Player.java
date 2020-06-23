public class Player {
    private static Player instance = null;
    
    private int maxHealth;
    private int currentHealth;
    private int baseAttack;
    private int currentAttack;
    private int baseResistence;
    private int currentResistence;

    //TODO: PlayerManager Dependence


    private Player(){}
    public static Player getInstance(){
        if(null == instance)
            instance = new Player();
        return instance;
    }
}