public interface PlayerManager {
    public void equipSpell(int position);
    public String getStateName();
    public void onEnterState();
    public void takeDamage(float amount);
    public void heal(float amount);
    public void attack();
    public void kill();
}