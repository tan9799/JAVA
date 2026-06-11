import java.util.HashSet;
import java.util.Scanner;

class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}

public class tu_shu_guan_li_xi_tong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashSet<Book> books = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "ADD":
                    String isbn = parts[1];
                    String title = parts[2];
                    String author = parts[3];
                    Book tempBook = new Book(isbn, "", "");
                    if (books.contains(tempBook)) {
                        System.out.println("Already exists");
                    } else {
                        books.add(new Book(isbn, title, author));
                        System.out.println("Added");
                    }
                    break;
                case "DELETE":
                    String delIsbn = parts[1];
                    Book delBook = new Book(delIsbn, "", "");
                    if (books.remove(delBook)) {
                        System.out.println("Deleted");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case "CONTAINS":
                    String conIsbn = parts[1];
                    Book conBook = new Book(conIsbn, "", "");
                    if (books.contains(conBook)) {
                        System.out.println("Exists");
                    } else {
                        System.out.println("Not exist");
                    }
                    break;
                case "COUNT":
                    System.out.println(books.size());
                    break;
                default:
                    // 无效命令，忽略
                    break;
            }
        }
        scanner.close();
    }
}