package playground;

public class exercise {
    private static class Product {
        int price;

        public Product() {
            System.out.println(1);
        }

        public Product(int price) {
            this.price = price;
        }
    }

    private static class Tv extends Product{
        int newPrice;

        public Tv() {
            System.out.print(2);
        }
    }

    public static void main(String[] args) {
        Product tv = new Tv();
    }
}
