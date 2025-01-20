package exception;

public class BookMakeNoteException extends RuntimeException {
    public BookMakeNoteException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "Ошибка при записи в книгу: " + super.getMessage();
    }
}
