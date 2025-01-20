package item;

import exception.BookMakeNoteException;
import group.character.Character;
import environment.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Book {
    private List<Note> notes = new ArrayList<>();
    private Character diaryKeeper;

    public Book(Character diaryKeeper) {
        this.diaryKeeper = diaryKeeper;
    }

    public void discourse() {
        Random random = new Random();
        StringBuilder discourseText = new StringBuilder();

        switch (diaryKeeper.getEmotion()) {
            case MAD:
                String[] madTexts = {
                        diaryKeeper.getName() + ": Я ДуМаю Они Меня ХотЯт здеСь ОстаВИть... Я за Ними ЗЛЕЖУ Я НЕ ДАМСЯ ИМ ЖИВЫМ!\n",
                        diaryKeeper.getName() + ": Они слЕдЯт за МноЙ... Я ВИЖУ их Лица в КаждОй тЕне, И оНи хОтЯт мЕня уНиЧтОжИтЬ! Я Не ПОсЛоЖу ЭтОму!\n",
                        diaryKeeper.getName() + ": Я знАю, ЧТо оНи хОтЯт мЕня оСТаВиТь ЗдеСь! Они дУмАЮт, чТО я НЕ ЗАмеЧаю их СлЕдОв... Но Я ЗА НиМи сЛеЖу\n"
                };
                discourseText.append(madTexts[random.nextInt(madTexts.length)]);
                break;

            case FEAR:
                String[] fearTexts = {
                        "Мои руки замерли, а дыхание перехватило что-то невидимое, пока мир вокруг тускнеет и исчезает в мраке.\n",
                        "Никогда не испытывал такого страха. Я не могу двигаться, я не могу дышать... Все вокруг становится темным и чуждым.\n",
                        "Я замер, не в силах ни пошевелиться, ни вдохнуть, а окружающий мир расплывается и становится чуждым, как сон на грани пробуждения.\n"
                };
                discourseText.append(fearTexts[random.nextInt(fearTexts.length)]);
                break;

            case CURIOUS:
                String[] curiousTexts = {
                        diaryKeeper.getName() + ": Нас охватил тот безумный азарт, какой не покидает охотников, выслеживающих диких зверей где-нибудь в джунглях Африки и рискующих жизнью, только чтобы понаблюдать за ними и сфотографировать.\n" +
                                "Мы застыли на месте, страх парализовал нас, но где-то в глубине уже разгорался неуемный огонек любопытства, и он в конце концов одержал победу.\n",
                        diaryKeeper.getName() + ": Внутри меня горит огонь. Желание исследовать, узнать, понять — это то, что делает меня живым в этом кошмаре.\n" +
                                "Нас охватывает азарт, и даже страх не может остановить нас. Мы идем вперед, несмотря ни на что.\n",
                        diaryKeeper.getName() + ": С каждым шагом становится все интереснее. Мы не знаем, что нас ждет, но любопытство толкает нас вперед, даже когда все вокруг говорит нам остановиться.\n" +
                                "Страх, страх, но любопытство сильнее...\n"
                };
                discourseText.append(curiousTexts[random.nextInt(curiousTexts.length)]);
                break;

            case SAD:
                String[] sadTexts = {
                        diaryKeeper.getName() + ": Самые чудовищные наши опасения подтвердились, и те, кто читает сейчас мою исповедь, понимают, о чем я говорю.\n",
                        diaryKeeper.getName() + ": Мы потеряли так много... Никто не сможет понять ту боль, которая наполняет мое сердце. Моя душа разрывается от утрат.\n",
                        diaryKeeper.getName() + ": Нет слов, чтобы описать, что мы пережили. Трудности, потери — они убивают нас изнутри.\n"
                };
                discourseText.append(sadTexts[random.nextInt(sadTexts.length)]);
                break;

            default:
                String[] texts = {
                        diaryKeeper.getName() + ": А может, мы и правда сошли с ума - ведь назвал же я эти страшные горы \"Хребтами Безумия\"?",
                        diaryKeeper.getName() + ": Кто я вообще такой, чтобы стоять на краю бездны и думать о собственном разуме? Эти горы, наверное, сошли с ума раньше нас.",
                        diaryKeeper.getName() + ": Возможно, мы все давно потеряли разум, называя эти земли \"Хребтами Безумия\". Или это сами горы нас свели с ума?",
                        diaryKeeper.getName() + ": Может, все это иллюзия? Эти горы, этот мир — и наша потеря разума, несомненно, часть этого кошмара."
                };
                discourseText.append(texts[new Random().nextInt(texts.length)] + "\n");
                break;
        }


        Note note = new Note(diaryKeeper.getName() + " - комментарий", discourseText);
        notes.add(note);
    }

    public void makeNote(Artifact artifact, Location location) throws BookMakeNoteException {
        if (artifact == null) {
            throw new BookMakeNoteException("Передан пустой артефакт.");
        }
        if (location == null) {
            throw new BookMakeNoteException("Передана пустая локация.");
        }
        if (diaryKeeper == null) {
            throw new BookMakeNoteException("Нет человека ведущего дневник.");
        }

        try {
            Random random = new Random();
            StringBuilder noteContent = new StringBuilder();

            String artifactInfo = "Артефакт: " + artifact.getName() + "\n" + artifact.showDamage() + "\n";
            String locationInfo = "Локация: " + location.getName() + " " + location.getDescription() + "\n";

            switch (diaryKeeper.getEmotion()) {
                case MAD:
                    if (random.nextInt(10) > 5) {
                        noteContent.append(" оПасЕн. Я ему не верю\n")
                                .append("оНи все мнЕ ЛгАли ! Я НЕНАВИЖУ ВАаС ВсЕх\n")
                                .append("'Неразборчивые каракули и страшные рисунки напоминающие местность'\n");
                    } else {
                        noteContent.append("ArteфаКТв: ").append(artifact.getName()).append("\n")
                                .append("0рИSuNшE: ").append(diaryKeeper.getName()).append(" он ХоТеЛ мНе ЧТО то говорил.. Но я НЕ ЗАПОМНИЛ ЕГО БРЕД! Я ЕГО НЕНАВИЖУ\n")
                                .append("L0сфциа: ").append("вСе БЫло ТаК кРасИво КромЕ этих УРОДОВ.\n")
                                .append("----------------------------\n");
                    }
                    break;
                case NORMAL:
                    noteContent.append(diaryKeeper.getName()).append(" нашел следующее\n")
                            .append(artifactInfo)
                            .append("Дал ему следущее описание: ").append(diaryKeeper.describeArtifact(artifact)).append("\n")
                            .append(locationInfo)
                            .append("----------------------------\n");
                    break;
                default:
                    noteContent.append(diaryKeeper.getName()).append(" обнаружил следующий предмет.\n")
                            .append(artifactInfo)
                            .append("Описание: ").append(diaryKeeper.describeArtifact(artifact)).append("\n")
                            .append(locationInfo)
                            .append("----------------------------\n");
                    break;
            }

            Note note = new Note(diaryKeeper.getName() + " - заметка", noteContent);
            notes.add(note);

        } catch (Exception e) {
            throw new BookMakeNoteException("Не удалось создать запись: " + e.getMessage());
        }
    }



    public void printBook() {
        if (!notes.isEmpty()) {
            System.out.println("========Дневник " + diaryKeeper.getName() + "========");
            for (Note note : notes) {
                System.out.println(note.name());
                System.out.println(note.content());
                System.out.println("-------------------");
            }
            System.out.println("=========Конец дневника============\n");
        } else {
            System.out.println("Дневник " + diaryKeeper.getName() + " пуст.");
        }
    }

    public Character getDiaryKeeper() {
        return diaryKeeper;
    }

    public void setDiaryKeeper(Character diaryKeeper) {
        this.diaryKeeper = diaryKeeper;
    }

    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(notes, book.notes) && Objects.equals(diaryKeeper, book.diaryKeeper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes, diaryKeeper);
    }

    @Override
    public String toString() {
        return "Book{" +
                "diaryKeeper=" + diaryKeeper.getName() +
                ", notes=" + notes.size() + " notes" +
                '}';
    }
}
