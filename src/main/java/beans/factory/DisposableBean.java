package beans.factory;

public interface DisposableBean {
    void destroy() throws Exception;
}
