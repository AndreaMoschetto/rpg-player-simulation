import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Player player = Player.getInstance();
    private static ScreenStateNotifyer notifyer = ScreenStateNotifyer.getInstance();

    public static void main(String[] args) {
        printTitle();
        printShopMenu();
        printPlayerMenu();
    }

    private static void printTitle() {
        System.out.println("BENVENUTO!!\n" + "Stai per vivere le avventure del guerriero Valoroso...\n"
                + "(la \"V\" e' maiuscola perche' \"Valoroso\" e' il suo nome)");
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
            System.out.print("(Scegline una digitando il numero corrispondente e premi [invio])\n: ");
            selection = userInput();
            if(selection < 1 || selection > 4){
                System.out.println("ERRORE: Opzione inesistente");
                i--;
                continue;
            }
            player.buySpell(selection);
        }
    }

    private static void printPlayerMenu(){
        System.out.println("Adesso scegli una tra le opzioni disponibili:");
        
        boolean wantsToPlay = true; 
        
        while(wantsToPlay){
            printPlayerOptions();
            System.out.print(": ");
            int selection = userInput();
            if(selection < 1 || selection > 6){
                System.out.println("ERRORE: Opzione inesistente");
                continue;
            }
            switch(selection){
            case 1:
                System.out.println("Scegli quale spell equipaggiare: ");
                printInventoryOptions();
                System.out.print(": ");
                int position = userInput();
                if(position < 1 || position > 3){
                    System.out.println("ERRORE: Opzione inesistente");
                    break;
                }
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
        int num = -1;
        try {
            text = tastiera.readLine();
            num = Integer.parseInt(text);
        } catch (IOException e) {
            System.out.println("ERRORE: errore di input");
            return -1;
        } catch (NumberFormatException e1){
            System.out.println("ERRORE: sono ammessi solo numeri");
            return -2;
        }

        return num;
    }
}