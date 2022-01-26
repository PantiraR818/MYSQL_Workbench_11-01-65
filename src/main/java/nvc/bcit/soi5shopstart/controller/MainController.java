package nvc.bcit.soi5shopstart.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//ใช้ตัวนี ้
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import nvc.bcit.soi5shopstart.model.Category;
import nvc.bcit.soi5shopstart.repository.CategoryRepository;

//ด้านล่างคือการเข้าไปที่ root / 
@Controller
public class MainController {
    
    @GetMapping("/")
    public String index () {
        return "index";
    }
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/category/product")
    public ModelAndView category () {
        List<Category> categories = categoryRepository.findAll();
        return new ModelAndView("category","categories",categories);
        //                         html     attr       value
        //                   เวลาเรียกเรียกชื่อกลาง  Attr       ส่งไปหาList
        //                      1 รับ จาก 2 
    }
// ========================Class 2 14-01-65==========================
// ========================Class 3 21-01-65 ย้ายไปProductController==========================
    
}
