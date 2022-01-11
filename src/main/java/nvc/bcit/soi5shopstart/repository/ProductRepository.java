package nvc.bcit.soi5shopstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.bcit.soi5shopstart.model.Product;
                                    //คำสั่งที่ repo ทำไว้ให้ การทำQueryพื้นฐาน
                                    //เพิ่ม extends JpaRepository<Product, Integer>
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
