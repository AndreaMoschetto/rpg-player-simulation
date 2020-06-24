public class Dead implements PlayerManager{
    String stateName = "Dead";

    @Override
    public void equipSpell(int position){
        System.out.println("Anche se ci riuscissi... da morto... non so come potresti utilizzarle");
    }
    @Override
    public String getStateName() {
        return stateName;
    }
    @Override
    public void onEnterState(){
        return;
    }

    @Override
    public void takeDamage(float amount) {
        System.out.println("Sarebbe irrispettoso nei confronti del suo spirito");
        return;
    }

    @Override
    public void heal(float amount) {
        System.out.println("Troppo tardi per delle cure");
        return;
    }

    @Override
    public void attack() {
        System.out.println("I fantasmi non sono cattivi in questo gioco");
        return;
    }

    @Override
    public void kill() {
        System.out.println("\"Uccidetelo a morte!!\" dicevano");
        return;
    }
    
}