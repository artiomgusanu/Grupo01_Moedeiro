package moedeiro.exception;

public class MoedeiroException extends Exception {

    public MoedeiroException(String mensagem) {
        super(mensagem);
    }

    public MoedeiroException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
