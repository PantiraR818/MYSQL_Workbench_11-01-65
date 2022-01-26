package nvc.bcit.soi5shopstart.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import nvc.bcit.soi5shopstart.model.Category;
import nvc.bcit.soi5shopstart.model.Product;
import nvc.bcit.soi5shopstart.repository.CategoryRepository;
import nvc.bcit.soi5shopstart.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryRepository categoryRepository;

    private Category prd;
    @GetMapping("")
    public ModelAndView product () {
        List<Product> products = productService.findAll();
        return new ModelAndView("product","products",products);
        //                         html     attr       value
        //                   เวลาเรียกเรียกชื่อกลาง  Attr       ส่งไปหาProduct
        //                      1 รับ จาก 2 
    }

    @GetMapping("/new")
    public String newProduct (ModelMap modelMap) {
        Product product =new Product();
        modelMap.addAttribute("prd", product);
        return "newproduct";
    }

    @GetMapping("/edit")
    public String editProduct () {
        return "editproduct";
    }
    //  Get Path name
    @GetMapping("/name/{name}")
    public ModelAndView findProductByName (@PathVariable("name") String name) {
        List<Product> products = productService.findByName(name);
        return new ModelAndView("product","products",products); 
    }

    //  Get Path Price
    @GetMapping("/price/{price}")
    public ModelAndView findProductByPrice (@PathVariable("price") double price) {
        List<Product> products = productService.findByPrice(price);
        return new ModelAndView("product","products",products);
    }

     //  Get Path Stock
     @GetMapping("/unitInStock/{unitInStock}")
     public ModelAndView findProductByunitInStock (@PathVariable("unitInStock") Integer unitInStock) {
         List<Product> products = productService.findByUnit(unitInStock);
         return new ModelAndView("product","products",products); 
     }
    //  ===================Class3 21-1-65=================
    // ADD Attr Category ให้ทุกๆ req ในนี้ เรียกใช้ Attr นี้ได้
    //  DropDowm ตรงNew Add
    @ModelAttribute("categories")
    public List<Category> loadCategory(){   //ชื่อFacn
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @PostMapping("/add")
    public String saveProduct(Product product, BindingResult result){
        if(result.hasErrors()){
            return "newproduct";
        }else{
            productService.save(product);
        }
        return "redirect:/product";
    }
// 
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, ModelMap modelMap){
        Product product = productService.getById(id);
        modelMap.addAttribute("prd",product);
        return "editProduct";
    }
    
    @PostMapping("/update")
    public String updateProductByProduct(@ModelAttribute("product") Product prd, BindingResult result){
        if(result.hasErrors()){
            return "editproduct";
        }else{
            Product product = productService.getById(prd.getId());
            product.setName(prd.getName());
            product.setPrice(prd.getPrice());
            product.setUnitInStock(prd.getUnitInStock());
            product.setCategory(prd.getCategory());
            productService.save(product);
            return "redirect:/product";

        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id){
        Product product = productService.getById(id);
        productService.delete(product);
        return new ModelAndView("redirect:/product");

    }
    
    @PostMapping("/name")
    public ModelAndView searchProductByName(String name, ModelMap modelMap){
        List<Product> products = productService.findByName(name);
        modelMap.addAttribute("name", name);
        return new ModelAndView("product", "products", products);
    }
    

}
