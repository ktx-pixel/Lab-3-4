package item;


import java.util.Objects;

public abstract class Item {
    private String name;
    private Damage damage;


    public Item (String name, Damage damage){
        this.name = name;
        this.damage = damage;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    abstract String showDamage();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(damage, item.damage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, damage);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }

}
