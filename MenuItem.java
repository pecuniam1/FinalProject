public class MenuItem {
    protected String name;
    protected float cost;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " $" + this.cost;
    }
}