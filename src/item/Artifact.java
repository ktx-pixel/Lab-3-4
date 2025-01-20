package item;

import group.character.Character;
import group.emotion.Emotion;

import java.util.Random;


public class Artifact extends Item{
    private String description;


    public Artifact(String name, String description, Damage damage) {
        super(name, damage);
        this.description = description;
    }


    @Override
    public String showDamage() {
        Random random = new Random();
        switch (getDamage()) {
            case DAMAGED:
                String[] damagedMessages = {
                        "Этот предмет абсолютно изношен. Каждое его движение разрушает его ещё больше, словно песок, унесённый ветром.",
                        "Предмет на грани разрушения. Он рассыпается в прах при малейшем воздействии.",
                        "Он настолько изношен, что стоит лишь прикоснуться, как он развалится на части."
                };
                return damagedMessages[random.nextInt(damagedMessages.length)];

            case WORN:
                String[] wornMessages = {
                        "Вполне неплохо сохранился до наших дней, но уже начинает проявляться износ в некоторых местах.",
                        "Состояние этого предмета нормальное для его возраста, хотя и с небольшими повреждениями.",
                        "Предмет держится, но видно, что он пережил не одну эпоху. Следы времени неоспоримы."
                };
                return wornMessages[random.nextInt(wornMessages.length)];

            case PRISTINE:
                String[] pristineMessages = {
                        "В идеальном состоянии! Этот предмет словно только что был изготовлен.",
                        "Он выглядит как новый, не поддается воздействию времени.",
                        "Как будто только что с конвейера! Никаких следов старости."
                };
                return pristineMessages[random.nextInt(pristineMessages.length)];

            default:
                return "Неизвестное состояние предмета.";
        }
    }


    public void setEmotion(Character character) {
        Random random = new Random();
        double emotionChance = random.nextDouble();

        if (character.getEmotion() != null) {
            if (emotionChance < 0.1) {
                character.setEmotion(Emotion.FEAR);
                System.out.println(character.getName() + " испытал ужас вглубине своего сердца. Начали трястись руки");
            }
            else if (emotionChance < 0.2) {
                character.setEmotion(Emotion.CURIOUS);
                System.out.println(character.getName() + " охватил безумный азарт, нами двигал неуемный огонек любопытства");
            }
            else if (emotionChance < 0.3) {
                character.setEmotion(Emotion.SAD);
                System.out.println(character.getName()  + " почувствовал чувство пустоты внутри. Оно пожирало его изнутри и не давало покоя. Лицо стало печальным и апатичным");
            }
            else if (emotionChance < 0.4) {
                character.setEmotion(Emotion.MAD);
                System.out.println(character.getName()  + " начал медленно сходить с ума...");
            }else {
                character.setEmotion(Emotion.NORMAL);
                System.out.println(character.getName() + " остался спокоен и невозмутим.");
            }
        }
    }

    public String getDescription() {
        return description;
    }
}

