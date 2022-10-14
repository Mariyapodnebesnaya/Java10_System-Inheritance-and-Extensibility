import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domane.Book;
import ru.netology.domane.Product;
import ru.netology.domane.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    @Test
    public void oneSearchResultsByName(){
        Book book1 = new Book(1,"Война и мир",200,"Лев Толстой");
        Book book2 = new Book(22,"Отцы и дети",500,"Иван Тургенев");
        Book book3 = new Book(33,"Темные начала",350,"Филип Пулман");
        Smartphone smartphone1 = new Smartphone(12,"CX1", 10000, "Хайоми");
        Smartphone smartphone2 = new Smartphone(23,"Galaxy S8+", 25000,"Samsung");

        ProductRepository repo =new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Отцы");
        Product[] expected = {book2};
        Assertions.assertArrayEquals(expected,actual);

    }
    @Test
    public void twoSearchResultsByName(){
        Book book1 = new Book(1,"Война и мир",200,"Лев Толстой");
        Book book2 = new Book(22,"Отцы и дети",500,"Иван Тургенев");
        Book book3 = new Book(33,"Отцы и дочери",350,"Патриция райс");
        Smartphone smartphone1 = new Smartphone(12,"CX1", 10000, "Хайоми");
        Smartphone smartphone2 = new Smartphone(23,"Galaxy S8+", 25000,"Samsung");

        ProductRepository repo =new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Отцы");
        Product[] expected = {book2,book3};
        Assertions.assertArrayEquals(expected,actual);

    }
    @Test
    public void SearchByNonExistentName(){
        Book book1 = new Book(1,"Война и мир",200,"Лев Толстой");
        Book book2 = new Book(22,"Отцы и дети",500,"Иван Тургенев");
        Book book3 = new Book(33,"Темные начала",350,"Филип Пулман");
        Smartphone smartphone1 = new Smartphone(12,"CX1", 10000, "Хайоми");
        Smartphone smartphone2 = new Smartphone(23,"Galaxy S8+", 25000,"Samsung");

        ProductRepository repo =new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Крыша");
        int expected = 0 ;
        Assertions.assertEquals(expected, actual.length);
    }
    @Test
    public void emptyNameSearch(){
        Book book1 = new Book(1,"Война и мир",200,"Лев Толстой");
        Book book2 = new Book(22,"Отцы и дети",500,"Иван Тургенев");
        Book book3 = new Book(33,"Темные начала",350,"Филип Пулман");
        Smartphone smartphone1 = new Smartphone(12,"CX1", 10000, "Хайоми");
        Smartphone smartphone2 = new Smartphone(23,"Galaxy S8+", 25000,"Samsung");

        ProductRepository repo =new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("");
        Product[] expected = {book1,book2,book3,smartphone1,smartphone2};
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void noSearchResults(){
        Book book1 = new Book(1,"Война и мир",200,"Лев Толстой");
        Book book2 = new Book(22,"Отцы и дети",500,"Иван Тургенев");
        Book book3 = new Book(33,"Темные начала",350,"Филип Пулман");
        Smartphone smartphone1 = new Smartphone(12,"CX1", 10000, "Хайоми");
        Smartphone smartphone2 = new Smartphone(23,"Galaxy S8+", 25000,"Samsung");

        ProductRepository repo =new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product[] actual = manager.searchBy("Отцы");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected,actual);
    }
}
