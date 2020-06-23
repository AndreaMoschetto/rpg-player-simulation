public class Normal implements PlayerManager{
    String stateName = "Normal";

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public void onEnterState(){
        float baseResistence = Player.getInstance().getBaseResistence();
        Player.getInstance().setCurrentResistence(baseResistence);
        Player.getInstance().setAttackMultiplyer(1);
        Player.getInstance().setResistenceMultiplyer(1);
    }

    @Override
    public void takeDamage(float amount) {
        float totalResistence = Player.getInstance().getCurrentResistence() *
            Player.getInstance().getResistenceMultiplyer();
        float reducedHealth = 
            Player.getInstance().getCurrentHealth() - 
            amount + totalResistence;
        System.out.println("A Valoroso vengono inflitti" + amount + "danni");
        System.out.println("Ne subisce " + (amount - totalResistence));
        if(reducedHealth <= 0){
            kill();
        }
        else if(reducedHealth < (Player.getInstance().getMaxHealth()/3)){
            Player.getInstance().setMode(new Berserker()); 
        }
        else{
            Player.getInstance().setCurrentHealth(reducedHealth);
        }
    }

    @Override
    public void heal(float amount) {
        System.out.println("Valoroso si cura di:" + amount + "punti");
        float increasedHealth = Player.getInstance().getCurrentHealth() + amount;
        float maxHealth = Player.getInstance().getMaxHealth();
        if(increasedHealth > maxHealth)
            Player.getInstance().setCurrentHealth(maxHealth);
        else
            Player.getInstance().setCurrentHealth(increasedHealth);
    }

    @Override
    public void attack() {
        System.out.println(
            "Valoroso attacca con: " + Player.getInstance().getSpellName()  +
            "\nInfligge: " + (Player.getInstance().getCurrentAttack() * Player.getInstance().getAttackMultiplyer()) + " danni."
            );
    }

    @Override
    public void kill() {
        Player.getInstance().setCurrentHealth(0);
        Player.getInstance().setMode(new Dead());
    }
    
}