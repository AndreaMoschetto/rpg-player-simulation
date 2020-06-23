public class FireBall implements Spell {
    private String name;
    private int amount;
    private boolean isUsable;

    public FireBall(){
        name = "Fire Ball";
        amount = 60;
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