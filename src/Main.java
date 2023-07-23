import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int iv;
    static int cv;

    static{
        System.out.println("Static");

    }
    {
        System.out.println("instance");
        iv = 100;
    }

    public Main(){
        System.out.printf("%d, ,%d\n", iv, cv);
        this.iv = 300;
    }

    public static void main(String[] args) {
        Main x = new Main();
        System.out.printf("%d, ,%d\n", x.iv, cv);
        Main y = new Main();
        System.out.printf("%d, ,%d\n", y.iv, cv);
    }
}