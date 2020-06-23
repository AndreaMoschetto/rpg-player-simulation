public class FireStorm implements Spell{
    private String name;
    private int amount;
    private boolean isUsable;

    public FireStorm(){
        name = "Fire Storm";
        amount = 100;
        isUsable = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public boolean isUsable() {
        return isUsable;
    }
}