package group;

import environment.services.SkillCheckService;
import environment.Environment;
import environment.Location;
import exception.LocationResearchException;
import group.character.Character;
import item.Artifact;
import item.Plan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class Group {
    private String name;
    private Plan plan = new Plan();
    private int startCountOfCharacters;
    private int countOfExploringLocations = 0;
    private ArrayList<Character> characters = new ArrayList<>();
    private SkillCheckService skillCheckService = new SkillCheckService();

    public Group(String name){
        this.name = name;
    }

    public void exploreEnvironment(Environment environment) {
        System.out.println("Группа " + getName() + " приехала к " + environment.getName() + " и начала его исследовать");
        List<Location> locations = environment.getLocationList();
        plan.fillPlan(environment);
        System.out.println(plan.getPlan());

        if (!locations.isEmpty()) {

            for (Location location : locations) {
                System.out.println("Наша группа остановилась у " + location.getName());
                ArrayList<Character> copyCharacter = new ArrayList<>();

                for (Character character: getGroup()){
                    Random random = new Random();
                    if (random.nextInt(10) + 1 > location.level){
                        copyCharacter.add(character);
                    } else {
                        System.out.println(character.getName() + " погиб при исследовании " + location.getName());
                    }
                }
                setGroup(copyCharacter);

                try {
                    if (!characters.isEmpty()) {
                        exploreLocation(location);
                        countOfExploringLocations += 1;
                    } else {
                        System.out.println("В группе не осталось людей чтобы исследовать локации");
                        break;
                    }
                } catch (LocationResearchException e) {
                    System.out.println("Нет человека, который бы смог пройти локацию");
                }
            }


            System.out.println("Группа завершила исследование локаций " + environment.getName() +
                    "\nУДАЛОСЬ ИССЛЕДОВАТЬ: " + countOfExploringLocations + "/" + locations.size() +
                    "\nВЫЖИЛО: " + getGroup().size() + "/" + getStartCountOfCharacters());
        } else {
            System.out.println("К сожалению, в " + environment.getName() + " нет локаций, которые можно было бы исследовать. Придется поехать домой..");
        }
    }

    public void exploreLocation(Location location) throws LocationResearchException {
        if (skillCheckService.canGroupExplore(location, this)) {
            System.out.println("Группа начинает изучение локации: " + location.getName());

            for (Character character : this.getGroup()) {
                System.out.println(character.getName() + " исследует артефакты в локации " + location.getName());

                for (Artifact artifact : location.getArtifactList()) {
                    System.out.println(character.getName() + " изучает артефакт: " + artifact.getName());
                    if (!(character.getBook().getNotes() == null)){
                        System.out.println(character.getName() + " Делает записи в книгу");
                        character.getBook().makeNote(artifact, location);
                        character.getBook().discourse();
                    }

                }

                System.out.println(character.getName() + " закончил исследовать артефакты в локации " + location.getName());
                break;
            }

        } else {
            throw new LocationResearchException("Исследование локации " + location.getName() + " невозможно для данной группы.");
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Character> getGroup() {
        return characters;
    }

    public void setGroup(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public void addCharacter(Character character){
        characters.add(character);
        startCountOfCharacters += 1;
    }

    public boolean removeCharacter(Character character) {
        return characters.remove(character);
    }

    public int getStartCountOfCharacters() {
        return startCountOfCharacters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group1 = (Group) o;
        return Objects.equals(name, group1.name) &&
                Objects.equals(plan, group1.plan) &&
                Objects.equals(characters, group1.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, plan, characters);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", plan=" + plan +
                ", group=" + characters +
                '}';
    }

}
