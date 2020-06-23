public class ResurrectionTalisman implements Spell{
    //TODO: implements EventObserver
    private String name;
    private boolean isUsable;

    public ResurrectionTalisman(){
        name = "Resurrection Talisman";
        isUsable = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAmount() {
        return 0; //0 = nothing
    }

    @Override
    public boolean isUsable() {
        return isUsable;
    }
}