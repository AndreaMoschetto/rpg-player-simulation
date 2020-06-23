public class ResurrectionTalisman implements Spell, EventObserver{
    private String name;
    private boolean isUsable;
    private boolean isBroken;

    public ResurrectionTalisman(){
        name = "Resurrection Talisman";
        isUsable = true;
        isBroken = false;
        Player.getInstance().attach(this);
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

    @Override
    public void update() {
        if(Player.getInstance().getStateName().equals("Dead") && !isBroken){
            Player.getInstance().punisherOn();
            isBroken = true;
        }
    }
}