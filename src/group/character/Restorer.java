package group.character;

import group.skill.Skill;
import group.skill.repairArtifact;
import item.Artifact;
import item.Damage;

public class Restorer extends Character implements repairArtifact {

    public Restorer(String name) {
        super(name);
    }


    @Override
    public boolean isCompatibleWith(Skill otherSkill) {
        return otherSkill instanceof repairArtifact;
    }

    @Override
    public String describeArtifact(Artifact artifact) {
        artifact.setEmotion(this);
        String description;
        System.out.println("Имея навыки починки, " + getName() + " предпринял попытку починить предмет");
        System.out.println(repairArtifact(artifact));

        switch (this.getEmotion()) {
            case MAD:
                description = getName() + " обезумев взглянул на " + artifact.getName() + ", а позже произнес " +
                        "\"КтО ПоСчитАл, чтО ЭТА СтАрАя ХРЕНЬ ПриЧИна ЧТОБЫ мЫ шЛи в Эту ДЫРУ!\"";
                break;

            case FEAR:
                description = getName() + " ощутил холод на спине. Его охватил ужас и страх.";
                break;

            default:
                description = getName() + " не был мастером слова, а потому его описание сходило на речь обычного любетеля.\nЕдинственное, что он увенно сказал было то как ему можно мернуть прошлый облик."
                        + ". А так же, что " + artifact.showDamage();

                break;
        }

        return description;
    }

    @Override
        public String repairArtifact(Artifact artifact){
        Damage artifactDamage = artifact.getDamage();
        Double random = Math.random();

        switch (artifactDamage){
            case DAMAGED: {
                if (random > 0.8){
                    artifact.setDamage(Damage.PRISTINE);
                    return "Умелыми движениями рук " + getName() + " смог вернуть ему вид, словно этот предмет был создан совсем недавно";
                } else {
                    return getName() + " не обладал талантом, что и не позволило ему починить предмет.";
                }

            }
            case WORN: {
                if (random < 0.2){
                    artifact.setDamage(Damage.PRISTINE);
                    return "Умелыми движениями рук " + getName() + " смог вернуть ему вид, словно этот предмет был создан совсем недавно";
                } else {
                    return "У " + getName() + " не хватило мастерства чтобы починить артефакт";
                }


            }
            case PRISTINE: {
                return "Предмет не нуждается в ремонте, он в отличном состоянии";
            }
            default: return "";
        }
    }
}
