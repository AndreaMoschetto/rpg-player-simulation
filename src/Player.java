public class Player extends EventSubject{
    private static Player instance = null;
    
    private Inventory inventory;
    private Shop shop;

    private float maxHealth = 500;
    private float currentHealth;
    private float baseAttack = 10;
    private float currentAttack;
    private float attackMultiplyer = 1;
    private float baseResistence = 10;
    private float currentResistence;
    private float resistenceMultiplyer = 1;
    private String equippedSpellName = "niente";

    private PlayerManager currentState;

    private Player(){
        super();
        currentHealth = maxHealth;
        currentAttack = baseAttack;
        currentResistence = baseResistence;
        inventory = Inventory.getInstance();
        shop = Shop.getInstance();
    }

    public static Player getInstance(){
        if(null == instance){
            instance = new Player();
            instance.setMode(new Normal());
        }
        return instance;
    }

    public void setMode(PlayerManager newState){   
        currentState = newState;
        updateAll();
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
    public void equipSpellInInventory(int position){
        inventory.equipSpell(position);
    }
    public void equipSpell(int position){
        currentState.equipSpell(position);
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

    public void updateAttackAmount(){
        currentAttack = baseAttack + inventory.getEquippedAmount();
    }
    public void updateEquippedSpellName(){
        equippedSpellName = inventory.getEquippedSpellName();
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
            "\nAttacco di base:\t" + baseAttack +
            "\nAttacco attuale:\t" + currentAttack +
            "\nResistenza di base:\t" + baseResistence +
            "\nResistenza attuale:\t" + currentResistence +
            "\nSpell equipaggiata:\t" + inventory.getEquippedSpellName() + " (DANNO: " + inventory.getEquippedAmount() + ")" +
            "\nStato:\t\t\t" + currentState.getStateName().toUpperCase()
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
    public String getEquippedSpellName(){
        return equippedSpellName;
    }
}