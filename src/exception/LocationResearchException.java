package exception;

public class LocationResearchException extends Exception{
    public LocationResearchException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "Ошибка исследования локации: " + super.getMessage();
    }
}
