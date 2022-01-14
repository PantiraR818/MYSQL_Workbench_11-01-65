package nvc.bcit.soi5shopstart.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nvc.bcit.soi5shopstart.model.Product;
import nvc.bcit.soi5shopstart.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //Get All Product ข้อมูลแบบชุด 
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    //Get product ny id
    public Product getById(int id){
        return productRepository.getById(id);
    }

//  Get Product by Name     คลาส2 14-01-65
    public List<Product> findByName(String name){
        return productRepository.findByNameContaining(name);
    }

//  Get Product by Price
    public List<Product> findByPrice(double price){
        return productRepository.findByPriceLessThanEqual(price);
    }

    //  Get Product by Price
    public List<Product> findByUnit(Integer unitInStock){
        return productRepository.findByunitInStockGreaterThanEqual(unitInStock);
      }
}
