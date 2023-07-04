class Item {
    private String nama;
    private int tambahHealth;

    public Item(String nama, int tambahHealth){
        this.nama = nama;
        this.tambahHealth = tambahHealth;
    }
    
    public String getName() {
        return nama;    
    }

    public int getTambahHealth() {
        return tambahHealth;
    }

}
