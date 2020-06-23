public class Player extends EventSubject{
    private static Player instance = null;
    
    private Inventory inventory;
    private Shop shop;

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

    private Player(){
        super();
        inventory = Inventory.getInstance();
        shop = Shop.getInstance();
        setMode(new Normal());
    }

    public static Player getInstance(){
        if(null == instance)
            instance = new Player();
        return instance;
    }

    public void setMode(PlayerManager newState){
        updateAll();
        currentState = newState;
        currentState.onEnterState();
    }

    public String getStateName(){
        return currentState.getStateName();
    }
    public void punisherOn(){
        setMode(new Punisher());
    }

    public void buySpell(int spellKey){
        inventory.storeSpell(shop.getSpell(spellKey));
    }
    public void equipSpell(int position){
        inventory.equipSpell(position);
        updateAttackAmount();
    }
    public void attack(){
        currentState.attack();
    }
    public void takeDamage(int amount){
        currentState.takeDamage(amount);
    }

    public void heal(float amount){
        currentState.heal(amount);
    }

    private void updateAttackAmount(){
        currentAttack = baseAttack + inventory.getEquippedAmount();
    }

    public void printShopSpells(){
        shop.printSpells();
    }

    public void printStoredSpells(){
        inventory.printSpells();
    }

    public void printStats(){
        System.out.println(
            "STATISTICHE DI VALOROSO: \n" + 
            "Salute massima:\t\t" + maxHealth +
            "\nSalute attuale:\t\t" + currentHealth +
            "\nAttacco di base:\t\t" + baseAttack +
            "\nAttacco attuale:\t\t" + currentAttack +
            "\nResistenza di base:\t\t" + baseResistence +
            "\nResistenza attuale:\t\t" + currentResistence +
            "\nSpell equipaggiata:\t\t" + inventory.getEquippedSpellName() +
            "\nStato: \t\t" + currentState.getStateName()
        );
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