package pl.jwr.produkty;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> products;


    //repozytrium na start
    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("pierwszy", 20, "agd"));
        products.add(new Product("drugi", 40, "agd"));
        products.add(new Product("trzeci", 30, "spozywcze"));
        products.add(new Product("czwarty", 10, "inne"));
        products.add(new Product("piąty", 25, "inne"));

    }

    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }


}
