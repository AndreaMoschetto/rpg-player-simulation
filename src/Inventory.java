import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance = null;
    private List<Spell> spells;
    private int equippedSpellIndex;
    private int maxSize;

    private Inventory(){
        spells = new ArrayList<>();
        equippedSpellIndex = -1;
        maxSize = 3;
    }
    public static Inventory getInstance(){
        if(null == instance)
            instance = new Inventory();
        return instance;
    }

    public void equipSpell(int position){
        if(position <= maxSize){
            if(spells.get(position-1).isUsable()){
                equippedSpellIndex = position-1;
                System.out.println("Valoroso equipaggia: " + getEquippedSpellName());
            }
            else{
                System.out.println("Spell passiva, NON EQIPAGGIABILE");
            }
        }
    }

    public void storeSpell(Spell spell){
        if(isNotFull()){
            spells.add(spell);
            System.out.println("Valoroso conserva: " + spell.getName() + " nell'Inventario");
        }
        else
            System.out.println("INVENTARIO PIENO, Valoroso lascia perdere la spell");
    }

    public int getEquippedAmount(){
        if(equippedSpellIndex > -1)
            return spells.get(equippedSpellIndex).getAmount();
            return 0;
    }

    public String getEquippedSpellName(){
        if(equippedSpellIndex > -1)
            return spells.get(equippedSpellIndex).getName();
        return "niente";
    }

    private boolean isNotFull(){
        return spells.size() < maxSize;
    }

    public void printSpells(){
        System.out.println("Spell in Inventario:\n");

        for(int i=0;i<maxSize;i++){
            System.out.print("[" + (i+1) + "]");
            System.out.println(spells.get(i).getName() + " (DANNO: " + spells.get(i).getAmount() + ")");
        }
    }
}