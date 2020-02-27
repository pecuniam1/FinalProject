class Drink extends MenuItem {
    private boolean isAlcohol;

    public Drink(String name, float cost, boolean isAlcohol) {
        super.setName(name);
        super.setCost(cost);
        setIsAlcohol(isAlcohol);            
    }

    private void setIsAlcohol(boolean isAlcohol) {
        this.isAlcohol = isAlcohol;
    }

    public boolean isAlcohol() {
        return this.isAlcohol;
    }
}