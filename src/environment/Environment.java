package environment;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Environment {
    private final String name;
    private String description;
    private List<Location> locationList = new ArrayList<>();

    public Environment(String name, Location... locations) {
        this.name = name;

        for (Location location: locations){
            locationList.add(location);
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locations) {
        this.locationList = locations;
    }

    public void addLocation(Location location) {
        locationList.add(location);
    }

    public void removeLocation(Location location) {
        locationList.remove(location);
    }

    public void printLocationList() {
        System.out.println("=== Локации в окружении \"" + this.getName() + "\" ===");
        for (Location location : locationList) {
            System.out.println("- " + location.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Environment that = (Environment) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(locationList, that.locationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, locationList);
    }

    @Override
    public String toString() {
        return "Environment{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", locationList=" + locationList.size() + " locations" +
                '}';
    }
}
