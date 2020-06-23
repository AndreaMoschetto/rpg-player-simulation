import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Player player;
    //private static ScreenStateNotifyer notifyer;

    public static void main(String[] args) {
        player = Player.getInstance();
        //notifyer = ScreenStateNotifyer.getInstance();
        //printTitle();
        //printShopMenu();
        //printPlayerMenu();
    }

    private static void printTitle() {
        System.out.println("BENVENUTO!!\n" + "Stai per vivere le avventure del guerriero Valoroso...\n"
                + "(Valoroso è proprio il nome del guerriero)");
    }

    private static void printShopOption() {
        player.printShopSpells();
    }

    private static void printInventoryOptions() {
        player.printStoredSpells();
    }

    private static void printPlayerOptions() {
        System.out.println(
                "AZIONI DISPONIBILI" +
                "\n[1] Equipaggia una spell Attiva" +
                "\n[2] Attacca" + 
                "\n[3] Subisci 100 danni" +
                "\n[4] Curati (30% della salute massima)" +
                "\n[5] Mostra Statistiche Eroe" +
                "\n[6] Esci"    
            );
    }

    private static void printShopMenu() {
        System.out.println("Devi prima scegliere tre Spell dal nostro Shop");
        System.out.println("(Un per volta)");

        for (int i = 0; i < 3; i++) {
            int selection = -1;
            printShopOption();
            System.out.println("(Scegline una digitando il numero corrispondente e premi [invio])\n: ");
            selection = userInput();
            player.buySpell(selection);
        }
    }

    private static void printPlayerMenu(){
        System.out.println("Adesso scegli una tra le opzioni disponibili:");
        printPlayerOptions();
        boolean wantsToPlay = true; 
        
        while(wantsToPlay){
            int selection = userInput();
            switch(selection){
            case 1:
                System.out.println("Scegli quale spell equipaggiare: ");
                printInventoryOptions();
                int position = userInput();
                player.equipSpell(position);
                break;
            case 2:
                player.attack();
                break;
            case 3:
                player.takeDamage(100);
                break;
            case 4:
                player.heal(player.getMaxHealth()*(30/100f));
                break;
            case 5:
                player.printStats();
                break;
            case 6:
                System.exit(0);
            }
        } 
    }

    private static int userInput() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        String text = null;
        try {
            text = tastiera.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Tasto non riconosciuto");
        }

        int num = Integer.parseInt(text);
        return num;
    }
}