package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book product1 = new Book(1, "name1", 100, "author1", 11, 2000);
    private Book product2 = new Book(2, "name2", 200, "author2", 22, 2002);


    @Test
    public void shouldSaveProducts() {
        repository.save(product1);
        repository.save(product2);

        Product[] expected = new Product[]{product1, product2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdProduct() {
        repository.save(product1);
        repository.save(product2);
        try {
            repository.removeById(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Product[] expected = new Product[]{product1};
        Product[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldRemoveByIdNotProduct() {
        repository.save(product1);
        repository.save(product2);
        try {
            repository.removeById(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Product[] expected = new Product[]{product1, product2};
        Product[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldRemoveByIdNotProduct2() {
        repository.save(product1);
        repository.save(product2);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-1);
        });

    }
}