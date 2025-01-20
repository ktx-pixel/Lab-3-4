package environment.services;

import group.Group;
import environment.Location;

public class SkillCheckService {

    public boolean canGroupExplore(Location location, Group group) {
        Class<?> requiredSkill = location.getSkill();

        if (requiredSkill == null) {
            System.out.println("** Локация " + location.getName() + " не трубует особых навыков для ее прохождения. Группа проходит. **");
            return true;
        }

        for (var character : group.getGroup()) {
            if (requiredSkill.isInstance(character)) {
                System.out.println("** " + character.getName() + " имеет необходимые навыки, чтобы попасть в "
                        + location.getName() + ". Благодаря чему группа может изучить это место. **");
                return true;
            }
        }

        System.out.println("** В группе нет персонажей с необходимыми навыками для исследования "
                + location.getName() + ". Группа оставила это место и пошла дальше. **");
        return false;
    }


}
