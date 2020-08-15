package csc.lzp.test.exception;

public class FastJsonUtilException extends Exception {
    private static final long serialVersionUID = -8846654841826352345L;

    public FastJsonUtilException(String msg) {
        super(msg);
    }

    public FastJsonUtilException() {
        super("FastJson解析出错");
    }
}