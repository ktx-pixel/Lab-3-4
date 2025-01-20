package environment;

import item.Artifact;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Location {
    private final String name;
    private List<Artifact> artifactList = new ArrayList<>();
    public int level;
    private final String description;
    private Class<?> skill;

    public Location(String name,int level, String description,  Artifact... artifacts) {
        this.name = name;
        this.description = description;
        this.level = Math.min(10, Math.max(0, level));

        for (Artifact artifact: artifacts){
            artifactList.add(artifact);
        }
    }

    public List<Artifact> getArtifactList() {
        return artifactList;
    }

    public void addArtifact(Artifact artifact) {
        artifactList.add(artifact); }


    public String getName() {
        return name;
    }

    public Class<?> getSkill() {
        return skill;
    }

    public void setSkill(Class<?> skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return level == that.level &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(artifactList, that.artifactList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, description, artifactList);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", description='" + description + '\'' +
                ", artifactList=" + artifactList.size() + " artifacts" +
                '}';
    }

}
