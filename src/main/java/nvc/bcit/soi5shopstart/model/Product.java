package nvc.bcit.soi5shopstart.model;

import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter  //ติดมากับโปรเจคเลย
@Setter 
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // คือAutoNumber กำหนด primary Key
    private int id;
    private String name;
    private double price;
    private int unitInStock;

    @Temporal(TemporalType.TIMESTAMP)  //เก็บtimestamp เวลาและวันที่  ปัจจุบัน
    @CreationTimestamp
    private Date createdAt;

}
