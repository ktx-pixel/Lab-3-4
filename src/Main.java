import group.Group;
import group.character.Archaeologist;
import environment.Environment;
import environment.Location;
import group.character.Restorer;
import group.skill.Mountaineering;
import item.Artifact;
import static item.Damage.*;


public class Main {
    public static void main(String[] arg) {


        Archaeologist archaeologist1 = new Archaeologist("Владимир");
        Archaeologist archaeologist2 = new Archaeologist("Дунфарт");
        Restorer restorer1 = new Restorer("Цезарь");


        Artifact artifact1 = new Artifact("Древний амулет", "Древний амулет, покрытый трещинами времени, излучает загадочное сияние, будто скрывая в себе силу, способную менять судьбы.",
                DAMAGED);
        Artifact artifact2 = new Artifact("Каменная табличка", "Каменная табличка, вырезанная древним мастерством, хранит на своих поверхностях забытые знания и секреты давно ушедших цивилизаций.",
                PRISTINE);
        Artifact artifact3 = new Artifact("Барельеф", "Несмотря на явную поспешность и даже небрежность зарисовок, манера эта ощущалась сразу и намного превосходила декадентский рисунок поздних барельефов. Здесь чувствовалась характерная техника рисунка Старцев в годы наивысшего расцвета их искусства.",
                WORN);


        Location location1 = new Location("Отвисные скалы", 1, "Острые, как иглы скалы и уклоны. Одно неверное движение и ты эта жизнь депортирует тебя на небеса", artifact1, artifact2);
        location1.setSkill(Mountaineering.class);
        Location location2 = new Location("Ледяной лабиринт", 1,"Все покрыто льдом. Глаза болят от бликов. Ничего не разобрать",artifact3);



        Environment environment = new Environment("горы \"Хребты безумия\"", location1, location2);
        environment.setDescription("Место, где мир и разум сливаются в бездонную пропасть.\n" +
                "Ослепительная белизна снежных вершин скрывает в себе ужасы, что не подвластны человеческому восприятию.\n");

        Group group = new Group("Cевер ждет, а мы на юге");


        group.addCharacter(archaeologist1);
        group.addCharacter(archaeologist2);
        group.addCharacter(restorer1);

        group.exploreEnvironment(environment);


        archaeologist1.getBook().printBook();
        archaeologist2.getBook().printBook();
        restorer1.getBook().printBook();
    }
}