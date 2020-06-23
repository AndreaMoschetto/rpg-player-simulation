public interface PlayerManager {
    public String getStateName();
    public void onEnterState();
    public void takeDamage(int amount);
    public void heal(int amount);
    public void attack();
    public void kill();
}