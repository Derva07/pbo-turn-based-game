class Player {
    private String nama;
    private int health;
    private int damage;
    public int defense;

    public Player(String nama, int health, int damage, int defense) {
        this.nama = nama;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
    }

    public String getName() {
        return nama;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(Monster monster) {
        System.out.println(nama + " attack " + monster.getName() + "!");
        int damageDealt = Math.max (0, damage - monster.defense); 
        monster.setHealth(monster.getHealth() - (damageDealt));
        System.out.println(monster.getName() + " menerima " + damageDealt + " damage.");
        System.out.println(monster.getName() + " health: " + monster.getHealth());
        System.out.println();
    }

    public void defenseUp(Player player) {
        System.out.println(nama + "Melakukan Defense up");
        defense = 10;

    }
}
