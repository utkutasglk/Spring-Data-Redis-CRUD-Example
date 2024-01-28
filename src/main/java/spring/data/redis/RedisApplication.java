package spring.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;
import spring.data.redis.entity.Product;
import spring.data.redis.repository.ProductDao;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class RedisApplication {

	@Autowired
	private ProductDao productDao;

	@PostMapping
	public Product save(@RequestBody Product product){
		return productDao.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts(){
		return productDao.findAll();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id){
		return productDao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id){
		return productDao.deleteProductById(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}
