import java.util.Scanner;

public class TurnBasedGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan opsi pemilihan
        System.out.println("=== Rehan's Adventure Game ===");
        System.out.println("1. Start Game");
        System.out.println("2. Exit Game");
        System.out.print("Pilih aksi: ");

        int menuChoice = scanner.nextInt();
        System.out.println();

        if (menuChoice == 1) {
            startGame(scanner);
        } else if (menuChoice == 2) {
            System.out.println("Permainan berakhir!");
        } else {
            System.out.println("Aksi tidak valid.");
        }
    }

    public static void startGame(Scanner scanner) {

        // Membuat hero
        Player player = new Player("Hero", 100, 20, 5);

        // Membuat monster

        Monster monster1 = new Monster("Slime", 120, 15, 10);
        Monster monster2 = new Monster("Goblin", 50, 25, 5); 
        Monster monster3 = new Monster("Bos Rozak Cup", 1000, 1000, 1000);
        
        boolean gameOver = false;

        // Membuat item
        Item potion = new Item("Health Potion", 20);

        // Membuat bertemu monster secara acak
        Monster[] monsters = { monster1, monster2, monster3 };
        Monster randomMonster = monsters[(int) (Math.random() * monsters.length)];
        System.out.println(player.getName() + "Bertemu dengan " + randomMonster.getName() + "!");

        

        while (!gameOver) {
            // Menampilkan giliran pemain
            System.out.println("turn " + player.getName() );

            // Menampilkan opsi kepada pemain untuk melakukan serangan, defense, atau menggunakan item 
            System.out.println("1. Attack");
            System.out.println("2. Defense Up");
            System.out.println("3. Gunakan Item");
            System.out.print("Pilih aksi: ");

            int action = scanner.nextInt();
            System.out.println();

            if (action == 1) {
                player.attack(randomMonster);
            } else if (action == 2) {
                player.defenseUp(player);
                System.out.println(player.getName() + " menambah defense sebesar " + player.defense);
                System.out.println();
            } else if (action == 3) {
                int health = player.getHealth();
                int tambahHealth = potion.getTambahHealth();
                int maxHealt = 100;
                int restoredHealth = Math.min(maxHealt - health, tambahHealth);
                player.setHealth(health + restoredHealth);
                System.out.println("Menggunakan " + potion.getName());
                System.out.println("Health menjadi " + player.getHealth());
                System.out.println();
            } 
            
            else {
                System.out.println("Aksi invalid.");
                System.out.println();
                continue;
            }

            // Apakah monster kalah
            if (randomMonster.getHealth() <= 0) {
                System.out.println("Menang! " + randomMonster.getName() + " telah dikalahkan");
                gameOver = true;
                break;
            }

            // Turn monster
            System.out.println("Turn " + randomMonster.getName());
            randomMonster.attack(player);

            // Apakah player kalah
            if (player.getHealth() <= 0) {
                System.out.println(player.getName() + "kalah");
                gameOver = true;
            }

        
        }

        // Menampilkan hasil akhir permainan
        System.out.println("Game over!");
        scanner.close();
    }
}
