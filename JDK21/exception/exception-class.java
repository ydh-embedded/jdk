import java.util.Arrays;
import java.util.List;

public class CustomException extends Throwable {
    private static final long serialVersionUID = 1L;

    protected String message = "Unknown exception";   // exception message
    private List<StackTraceElement> trace;           // backtrace
    private Throwable previous;                      // previous exception if nested exception

    public CustomException(String message, int code, Throwable previous) {
        super(message, previous);
        this.message = message == null || message.isEmpty() ? "Unknown exception" : message;
        this.code = code;
        this.previous = previous;
        this.trace = Arrays.stream(super.getStackTrace()).toList();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public StackTraceElement[] getTrace() {
        return trace.toArray(new StackTraceElement[0]);
    }

    public Throwable getPrevious() {
        return previous;
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getMessage());
        sb.append(" (").append(getCode()).append(")").append(System.lineSeparator());
        for (StackTraceElement element : trace) {
            sb.append("\t").append(element.toString()).append(System.lineSeparator());
        }
        if (previous != null) {
            sb.append("Caused by: ");
            sb.append(previous.toString());
        }
        return sb.toString();
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

}