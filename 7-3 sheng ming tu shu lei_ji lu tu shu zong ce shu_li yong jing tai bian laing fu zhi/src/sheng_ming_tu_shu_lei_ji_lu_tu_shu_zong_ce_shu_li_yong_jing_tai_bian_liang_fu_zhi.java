class Book {
    private String title;
    private int id;
    private double price;
    private static int nextId = 1;
    private static int totalBooks = 0;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.id = nextId++;
        totalBooks++;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
}

public class sheng_ming_tu_shu_lei_ji_lu_tu_shu_zong_ce_shu_li_yong_jing_tai_bian_liang_fu_zhi {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Java程序设计", 34.5),
                new Book("数据结构", 44.8),
                new Book("C++程序设计", 35.0)
        };

        for (Book b : books) {
            System.out.printf("书名：%s, 书号：%d, 书价：%.1f\n",
                    b.getTitle(), b.getId(), b.getPrice());
        }

        System.out.println("图书总册数为：" + Book.getTotalBooks());
    }
}
