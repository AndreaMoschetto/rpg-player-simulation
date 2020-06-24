public class Berserker implements PlayerManager{
    private String stateName = "Berserker";
    private String description = 
        "Adesso sei un distruttore. DEVASTA OGNI COSA!!" +
        " Attacco e Resistenza raddoppiati";

    @Override
    public void equipSpell(int position){
        Player.getInstance().equipSpellInInventory(position);
        Player.getInstance().updateAttackAmount();
        Player.getInstance().updateEquippedSpellName();
    }

    @Override
    public String getStateName() {
        return stateName;
    }
    
    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public void onEnterState(){
        Player.getInstance().setResistenceMultiplyer(2);
        Player.getInstance().setAttackMultiplyer(2);
        return;
    }

    @Override
    public void takeDamage(float amount) {
        float totalResistence = Player.getInstance().getCurrentResistence() *
            Player.getInstance().getResistenceMultiplyer();
        float reducedHealth = 
            Player.getInstance().getCurrentHealth() - 
            amount + totalResistence;
        System.out.println("A Valoroso vengono inflitti " + amount + " danni");
        System.out.println("Ne subisce " + (amount - totalResistence));

        if(reducedHealth <= 0){
            kill();
        }
        else{
            Player.getInstance().setCurrentHealth(reducedHealth);
        }
        return;
    }

    @Override
    public void heal(float amount) {
        System.out.println("Valoroso si cura di: " + amount + " punti");
        float increasedHealth = Player.getInstance().getCurrentHealth() + amount;
        float maxHealth = Player.getInstance().getMaxHealth();
        if(increasedHealth > maxHealth){
            Player.getInstance().setCurrentHealth(maxHealth);
        }
        else{
            Player.getInstance().setCurrentHealth(increasedHealth);
        }
        if(increasedHealth >= maxHealth/3)
            Player.getInstance().setMode(new Normal());
            
        return;
    }

    @Override
    public void attack() {
        System.out.println(
            "Valoroso devasta con: " + Player.getInstance().getEquippedSpellName()  +
            "\nInfligge: " + (Player.getInstance().getCurrentAttack() * Player.getInstance().getAttackMultiplyer()) + " danni."
            );
        return;
    }

    @Override
    public void kill() {
        Player.getInstance().setCurrentHealth(0);
        Player.getInstance().setMode(new Dead());
        return;
    }
    
}