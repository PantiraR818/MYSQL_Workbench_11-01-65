package nvc.bcit.soi5shopstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.bcit.soi5shopstart.model.Product;
                                    //คำสั่งที่ repo ทำไว้ให้ การทำQueryพื้นฐาน
                                    //เพิ่ม extends JpaRepository<Product, Integer>
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Get Name
    public List<Product> findByNameContaining(String name);         
    //  ขึ้นต้นด้วยfindBy-->ที่เราต้องการหา-->ไม่สนใจคำหน้าหลัง (ค่าที่หา)

    // Get Price
    public List<Product> findByPriceLessThanEqual(double price);

 // Get Stock
    public List<Product> findByunitInStockGreaterThanEqual(Integer unitInStock);

   
    

}
