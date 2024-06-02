package moedeiro.exception;

public class ExcessoMoedasException extends MoedeiroException {
    public ExcessoMoedasException(String message, int excesso) {
        super(message + " Excesso: " + excesso);
    }
}
