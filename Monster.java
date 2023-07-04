class Monster {
    private String nama;
    private int health;
    private int damage;
    public int defense;

    public Monster(String nama, int health, int damage, int defense) {
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

    public void attack(Player player) {
        System.out.println(nama + " attack " + player.getName() + "!");
        int damageDealt = Math.max (0, damage - player.defense); 
        player.setHealth(player.getHealth() - damageDealt);
        System.out.println(player.getName() + " menerima " + damageDealt + " damage.");
        System.out.println(player.getName() + " health: " + player.getHealth());
        System.out.println();
    }
}

