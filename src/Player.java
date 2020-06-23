public class Player {
    private static Player instance = null;
    
    private int maxHealth;
    private int currentHealth;
    private int baseAttack;
    private int currentAttack;
    private int baseResistence;
    private int currentResistence;
    private String spellName;

    private PlayerManager currentState;

    //TODO: PlayerManager Dependence


    private Player(){
        setMode(new Normal());
    }

    public static Player getInstance(){
        if(null == instance)
            instance = new Player();
        return instance;
    }

    public void setMode(PlayerManager newState){
        currentState = newState;
        currentState.onEnterState();
    }



    public int getCurrentAttack(){
        return currentAttack;
    }
    public void setCurrentAttack(int amount){
        currentAttack = amount;
    }
    public int getBaseAttack(){
        return baseAttack;
    }
    public int getCurrentHealth(){
        return currentHealth;
    }
    public void setCurrentHealth(int amount){
        currentHealth = amount;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public String getSpellName(){
        return spellName;
    }
}