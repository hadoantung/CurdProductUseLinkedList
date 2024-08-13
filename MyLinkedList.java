package CollectionFramework;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyLinkedList {
    static List<Product> list = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);
    int id = 0;

    public static void main(String[] args) {
        MyLinkedList linkeslist = new MyLinkedList();
        while (true) {
            System.out.println("---crud product---");
            System.out.println("1. add product");
            System.out.println("2. edit product");
            System.out.println("3. remote product");
            System.out.println("4. seach product by name");
            System.out.println("5. sort ascending");
            System.out.println("6. sort descending");
            System.out.println("0. exit");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    linkeslist.add();
                    linkeslist.display();
                    break;
                case "2":
                    System.out.println("enter the index to be edited");
                    int id = scanner.nextInt();

                    if (id > list.size()) {
                        break;

                    }
                    linkeslist.edit(id);
                    linkeslist.display();
                    break;
                case "3":
                    System.out.println("enter the index to be remote");
                    int id1 = scanner.nextInt();
                    scanner.nextLine();
                    if (id1 > list.size()) {
                        break;

                    }
                    linkeslist.remote(id1);
                    linkeslist.display();
                    break;
                case "4":
                    System.out.println("enter the name to be seach");
                    String name = scanner.nextLine();
                    if (list.isEmpty()) {
                        break;

                    }
                    linkeslist.seach(name);
                    break;
                case "5":
                    linkeslist.sortasending();
                    linkeslist.display();
                    break;
                case "6":
                    linkeslist.sortdescending();
                    linkeslist.display();
                    break;
                case "0":
                    break;
            }
        }

    }

    private void sortdescending() {
        Collections.sort(list, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }

        });
    }

    private void sortasending() {
        Collections.sort(list, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }

        });
    }

    private void seach(String name) {
        for (Product product : list) {
            if (product.getName().equals(name)) {
                System.out.println(product);
            }
        }
    }

    public void add() {
        Product product = new Product();
        System.out.println("enter product name");
        String name = scanner.nextLine();
        System.out.println("enter product price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        id++;
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        list.add(product);
    }

    public void edit(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                System.out.println("edit product name");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("edit product price");
                double price = scanner.nextDouble();
                scanner.nextLine();
                product.setName(name);
                product.setPrice(price);
            }
        }
    }

    private void remote(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                list.remove(product);
            }
        }
    }

    private void display() {
        for (Product product : list) {
            System.out.println(product);
        }
    }

}

class Product {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
