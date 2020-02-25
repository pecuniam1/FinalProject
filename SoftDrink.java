class SoftDrink extends Drink {
    private final float cost = 2.0f; //soft drinks are always the same price

    public float getCost() {
        return this.cost;
    }

    @Override
    public boolean isAlcohol() {
        // TODO Auto-generated method stub
        return false;
    }
}