public class Normal implements PlayerManager{

    @Override
    public String getStateName() {
        return null;
    }

    @Override
    public void onEnterState(){
        
    }

    @Override
    public void takeDamage(int amount) {
        int reducedHealth = Player.getInstance().getCurrentHealth()-amount;

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
    public void heal(int amount) {
        int increasedHealth = Player.getInstance().getCurrentHealth() + amount;
        int maxHealth = Player.getInstance().getMaxHealth();
        if(increasedHealth > maxHealth)
            Player.getInstance().setCurrentHealth(maxHealth);
        else
            Player.getInstance().setCurrentHealth(increasedHealth);
    }

    @Override
    public void attack() {
        System.out.println(
            "Valoroso attacca con: " + Player.getInstance().getSpellName()  +
            "\nInfligge: " + Player.getInstance().getCurrentAttack() + " danni."
            );
    }

    @Override
    public void kill() {
        Player.getInstance().setCurrentHealth(0);
        Player.getInstance().setMode(new Dead());
    }
    
}