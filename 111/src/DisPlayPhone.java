import java.io.IOException;

public interface DisPlayPhone {
    void addInfos() throws IOException, ClassNotFoundException;
    void show() throws IOException, ClassNotFoundException;
    void search();
    void edit();
    void delete();
}
