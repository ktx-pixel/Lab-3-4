package item;

import environment.Environment;
import environment.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plan {
    private List<Location> locations;
    private String text;

    public Plan () {
        this.locations = new ArrayList<>();
        this.text = "Нет плана прохождения. Добавьте локации.";
    }


    public void fillPlan(Environment environment) {
        locations = environment.getLocationList();
        if (!locations.isEmpty()) {
            StringBuilder plan = new StringBuilder("План прохождения в " + environment.getName() + ": ");
            for (int i = 0; i < locations.size(); i++) {
                plan.append(locations.get(i).getName());
                if (i < locations.size() - 1) {
                    plan.append(", ");
                }
            }
            text = plan.toString();
        } else {
            text = "Нет локаций, нет плана. Добавьте хотя бы одну локацию.";
        }
    }

    public List<Location> getLocations() {
        return locations;
    }

    public String  getPlan() {
        return "===" + text + "===";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(locations, plan.locations) &&
                Objects.equals(text, plan.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locations, text);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "locations=" + locations.size() + " locations, " +
                "text='" + text + '\'' +
                '}';
    }
}
