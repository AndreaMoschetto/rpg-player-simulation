public class Player {
    private static Player instance = null;
    
    private float maxHealth;
    private float currentHealth;
    private float baseAttack;
    private float currentAttack;
    private float attackMultiplyer;
    private float baseResistence;
    private float currentResistence;
    private float resistenceMultiplyer;
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



    public float getCurrentAttack(){
        return currentAttack;
    }
    public void setCurrentAttack(float amount){
        currentAttack = amount;
    }
    public void setAttackMultiplyer(float mul){
        attackMultiplyer = mul;
    }
    public float getAttackMultiplyer(){
        return attackMultiplyer;
    }
    public float getCurrentResistence(){
        return currentResistence;
    }
    public void setCurrentResistence(float amount){
        currentResistence = amount;
    }
    public float getBaseResistence(){
        return baseResistence;
    }
    public void setBaseResistence(float amount){
        baseResistence = amount;
    }
    public void setResistenceMultiplyer(float amount){
        resistenceMultiplyer = amount;
    }
    public float getResistenceMultiplyer(){
        return resistenceMultiplyer;
    }
    public float getBaseAttack(){
        return baseAttack;
    }
    public float getCurrentHealth(){
        return currentHealth;
    }
    public void setCurrentHealth(float amount){
        currentHealth = amount;
    }
    public float getMaxHealth(){
        return maxHealth;
    }
    public String getSpellName(){
        return spellName;
    }
}