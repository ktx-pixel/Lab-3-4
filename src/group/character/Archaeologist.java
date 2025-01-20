package group.character;


import group.emotion.Emotion;
import group.skill.Mountaineering;
import group.skill.Skill;
import group.skill.WorkWithPlan;
import environment.Location;
import group.skill.repairArtifact;
import item.Artifact;
import item.Damage;
import item.Plan;

import java.util.Random;


public class Archaeologist extends Character implements WorkWithPlan, Mountaineering {

    public Archaeologist(String name) {
        super(name);
    }

    @Override
    public boolean isCompatibleWith(Skill otherSkill) {
        return otherSkill instanceof Mountaineering || otherSkill instanceof WorkWithPlan;
    }

    @Override
    public String describePlan(Plan plan) {
        Random random = new Random();
        String describe;

        switch (getEmotion()) {
            case MAD:
                if (plan.getLocations().isEmpty()) {
                    String[] madTexts = {
                            "Кт0… кт0 вОбЩе мОг! М0г, м0г! Да п0ч3му нЕ сДел@лИ-т0, @?! кАк м0жн0 бЫл0 нЕ сДел@ть, кОгд@… кОгд@ вОТ — вОТ пЕрЕд н@ми всЁ!",
                            "Эт0 жЕ всЁ, эт0 всЁ д0лЖн0 бЫть… нО нЭт, нИчЕг0 нЭт, нИчЕг0! Мы кРуЖим, кРуЖим, в эТ0м… в эТ0м кАк бы… тУпИкЕ, и нИкТ0 нЕ пОнИм@ет, п0чЕму...",
                            "Почему не чертит, почему не пишет! Это же просто нужно… нужно взять и… и всё! Просто всё, ну! Но нет! Всё, всё разваливается, и… и зачем? Зачем это всё?!"
                    };
                    describe = madTexts[random.nextInt(madTexts.length)];
                    return describe;
                } else {
                    String[] madPlanTexts = {
                            "Пл@н эксп3дицИи п0с3тИтЬ… нУ, в ообЩе, тУд@, гд3… гд3 эТа шТуКа, да! АРт3ф@кТ… оН Же, ну… эЭ... эТ@т! оН, оН к@к Бы… свЕтИт, нО н3 свЕтИт.",
                            "И воОбЩе, кт0-то ск@з@л, чТо оН скрИпИт, хОтя Я нЕ пОнИм@Ю, кАк, п0т0му чТо кАк м0жНо скрИпЕтЬ, ЕСлИ нИчЕгО нЕ тР0г@еШЬ?!"
                    };
                    describe = madPlanTexts[random.nextInt(madPlanTexts.length)];
                    return describe;
                }
            case SAD:
                if (plan.getLocations().isEmpty()) {
                    String[] sadTexts = {
                            "Кто-нибудь же мог, повторяю, начертить какой-никакой план! Почему этого не сделано..",
                            "Никто не смог подготовить план, и теперь мы просто блуждаем в темноте, не зная, куда идти."
                    };
                    describe = sadTexts[random.nextInt(sadTexts.length)];
                    return describe;
                } else {
                    String[] sadPlanTexts = {
                            "Эхххх. План экспедиции посетить:" + plan.getPlan(),
                            "План прост, но все равно он не дает мне покоя. Я все равно не уверен, что это поможет."
                    };
                    describe = sadPlanTexts[random.nextInt(sadPlanTexts.length)];
                    return describe;
                }
            case CURIOUS:
                if (plan.getLocations().isEmpty()) {
                    String[] curiousTexts = {
                            "Плана нет? Ну и ладно, мы и так все сделаем! Давайте уже идем! Мне не терпится начать!",
                            "Нет плана? Это не беда! Мы справимся! Время идти и делать все по ходу."
                    };
                    describe = curiousTexts[random.nextInt(curiousTexts.length)];
                    return describe;
                } else {
                    String[] curiousPlanTexts = {
                            "Наш план на сегодня" + plan.getPlan(),
                            "План готов, и это просто интересно! Как бы это не сложилось, но я готов к любому результату!"
                    };
                    describe = curiousPlanTexts[random.nextInt(curiousPlanTexts.length)];
                    return describe;
                }
            default:
                if (plan.getLocations().isEmpty()) {
                    String[] defaultTexts = {
                            "Кто-нибудь же мог, повторяю, начертить какой-никакой план! Почему этого не сделано..",
                            "Никаких планов нет, и это раздражает. Почему ничего не готово?"
                    };
                    describe = defaultTexts[random.nextInt(defaultTexts.length)];
                    return describe;
                } else {
                    String[] defaultPlanTexts = {
                            "План экспедиции посетить:" + plan.getPlan(),
                            "План составлен, теперь просто следуем ему!"
                    };
                    describe = defaultPlanTexts[random.nextInt(defaultPlanTexts.length)];
                    return describe;
                }
        }
    }


    @Override
    public String climbing(Location location){
        if(getEmotion() == Emotion.MAD) {
            return getName() + " Без снаряжения и без ботинок, взбирается словно паук, которого хотят придавить тапком.";
        } else {
            return getName() + " отчаянно взбирается неумелыми рученками на нужную ему высоту.";
        }
    }


    @Override
    public String describeArtifact(Artifact artifact) {
        artifact.setEmotion(this);
        String description;

        switch (this.getEmotion()) {
            case MAD:
                description = getName() + " безумными глазами взглянул на " + artifact.getName() + ", а затем сказал " +
                        "\"КтО ПоСчитАл, чтО ЭТА СтАрАя ХРЕНЬ ПриЧИна ЧТОБЫ мЫ шЛи в Эту ДЫРУ!\"";
                break;

            case FEAR:
                description = getName() + " застыл на месте, его парализовал страх";
                break;

            default:
                description = getName() + " посмотрев на " + artifact.getName() + " высказал свое экспертное мнение о нем. А именно " +
                        artifact.getDescription() + ". А так же, что " + artifact.showDamage();

                break;
        }

        return description;
    }


}
