/**Manage the Spell Shop of the Game */
public class Shop {
    private static Shop instance = null;
    private Shop(){}

    public static Shop getInstance(){
        if(null == instance)
            instance = new Shop();
        return instance;
    }

    /**
     * Is a Factory Method that returns an instance of
     * Spell interface according to the value of shopKey
     * @param shopKey is an integer which decide what kind of Spell you whant take.
     * @return the chosen Spell Object
     */
    public Spell getSpell(int shopKey){
        switch(shopKey){
        case 1:
            return new FireBall();
        case 2:
            return new FireStorm();
        case 3:
            return new IceBlow();
        case 4:
            return new ResurrectionTalisman();
        default:
            return null;
        }
    }
    /**
     * Is prints a list of available
     * Spell in the shop
     */
    public void printSpells(){
        System.out.println( 
            "Le Spell disponibili in negozio sono:\n" +
            "[1] Fire Ball (DANNO: 60)\n"   +
            "[2] Fire Storm (DANNO: 100)\n"  +
            "[3] Ice Blow (DANNO: 90)\n"    +
            "[4] Resurrection Talisman (PASSIVA)"
        );
    }
}