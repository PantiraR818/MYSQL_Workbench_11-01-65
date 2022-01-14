package nvc.bcit.soi5shopstart.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//ใช้ตัวนี ้
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.soi5shopstart.model.Category;
import nvc.bcit.soi5shopstart.model.Product;
import nvc.bcit.soi5shopstart.repository.CategoryRepository;
import nvc.bcit.soi5shopstart.service.ProductService;
//ด้านล่างคือการเข้าไปที่ root / 
@Controller
public class MainController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String index () {
        return "index";
    }
    @Autowired
    CategoryRepository categoryRepository;

    
    @GetMapping("/product")
    public ModelAndView product () {
        List<Product> products = productService.findAll();
        return new ModelAndView("product","products",products);
        //                         html     attr       value
        //                   เวลาเรียกเรียกชื่อกลาง  Attr       ส่งไปหาProduct
        //                      1 รับ จาก 2 
    }

    @GetMapping("/product/new")
    public String newProduct () {
        return "newproduct";
    }

    @GetMapping("/product/edit")
    public String editProduct () {
        return "editproduct";
    }

    @GetMapping("/category/product")
    public ModelAndView category () {
        List<Category> categories = categoryRepository.findAll();
        return new ModelAndView("category","categories",categories);
        //                         html     attr       value
        //                   เวลาเรียกเรียกชื่อกลาง  Attr       ส่งไปหาList
        //                      1 รับ จาก 2 
    }
// ========================Class 2 14-01-65==========================
    //  Get Path name
    @GetMapping("/product/name/{name}")
    public ModelAndView findProductByName (@PathVariable("name") String name) {
        List<Product> products = productService.findByName(name);
        return new ModelAndView("product","products",products); 
    }

    //  Get Path Price
    @GetMapping("/product/price/{price}")
    public ModelAndView findProductByPrice (@PathVariable("price") double price) {
        List<Product> products = productService.findByPrice(price);
        return new ModelAndView("product","products",products);
    }

     //  Get Path Stock
     @GetMapping("/product/unitInStock/{unitInStock}")
     public ModelAndView findProductByunitInStock (@PathVariable("unitInStock") Integer unitInStock) {
         List<Product> products = productService.findByUnit(unitInStock);
         return new ModelAndView("product","products",products); 
     }

}
