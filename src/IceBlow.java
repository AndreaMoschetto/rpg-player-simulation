public class IceBlow implements Spell{
    private String name;
    private int amount;
    private boolean isUsable;

    public IceBlow(){
        name = "Ice Blow";
        amount = 90;
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