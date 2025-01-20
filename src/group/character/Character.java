package group.character;

import group.emotion.Emotion;
import group.skill.Skill;
import item.Artifact;
import item.Book;

import java.util.HashSet;
import java.util.Objects;

public abstract class Character {
    private String name;
    private Emotion emotion;
    private Book book = new Book(this);

    public Character(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }


    public Emotion getEmotion() {
        return (emotion != null) ? emotion : Emotion.NORMAL;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public String getName() {
        return name;
    }

    public abstract String describeArtifact(Artifact artifact);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) &&
                Objects.equals(emotion, character.emotion) &&
                Objects.equals(book, character.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emotion, book);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", emotion=" + getEmotion() +
                ", book=" + book +
                '}';
    }
}


