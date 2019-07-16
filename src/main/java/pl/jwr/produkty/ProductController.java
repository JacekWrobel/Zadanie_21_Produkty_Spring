package pl.jwr.produkty;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ResponseBody
    @GetMapping("/list")
    public String showProducts(@RequestParam(required = false) String category) {

        List<Product> temp = productRepository.getAll();
        String result = "";
        double sum = 0;
        if (StringUtils.isEmpty(category)) {
            for (Product product : temp) {
                result += product.toString() + "<br/>";
                sum += product.getPrice();
            }
        } else {
            for (Product product : temp) {
                if (category.equals(product.getCategory())) {
                    result += product.toString() + "<br/>";
                    sum += product.getPrice();
                }
            }
        }
        return result + "<br/>" + "Suma wszytkich produktów z kategorii to..." + sum;
    }

    @RequestMapping("/add")
    public String addNewProduct(@RequestParam String name,
                                @RequestParam double price,
                                @RequestParam String category) {
        Product product = new Product(name, price, category);
        productRepository.add(product);

        return "redirect:/dodano.html";
    }
}
