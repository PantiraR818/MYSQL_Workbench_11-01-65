package nvc.bcit.soi5shopstart.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//ใช้ตัวนี ้
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.soi5shopstart.model.Product;
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
    
    @GetMapping("/product")
    public ModelAndView product () {
        List<Product> products = productService.findAll();
        return new ModelAndView("product","products",products);
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
}
