class SpecialDish extends Dish {
    private String chefNote;

    public SpecialDish(String name, double price, String type, boolean hasSauce, String chefNote) {
        super(name, price, type, hasSauce);
        this.chefNote = chefNote;
    }

    @Override
    public void displayDish(int index) {
        super.displayDish(index);
        System.out.println("   >> Chef's Note: " + chefNote);
    }
}