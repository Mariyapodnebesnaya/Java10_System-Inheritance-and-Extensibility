import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domane.Product;
import ru.netology.domane.Smartphone;
import ru.netology.domane.Book;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {
    Book book1 = new Book(1,"Война и мир",200,"Лев Толстой");
    Book book2 = new Book(22,"Отцы и дети",500,"Иван Тургенев");
    Book book3 = new Book(33,"Темные начала",350,"Филип Пулман");
    Smartphone smartphone1 = new Smartphone(12,"CX1", 10000, "Хайоми");
    Smartphone smartphone2 = new Smartphone(23,"Galaxy S8+", 25000,"Samsung");
    Smartphone smartphone3 = new Smartphone(14,"CX3", 10000, "Хайоми");

    ProductRepository repo = new ProductRepository();

    @Test
    public void saveProduct() {
        repo.save(book1);
        repo.save(book2);
        Product[] expected = {book1,book2,book3};
        Product[] actual = repo.save(book3);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(smartphone1.getId());

        Product[] expected = {book1,book2,book3,smartphone2,smartphone3};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }
}
