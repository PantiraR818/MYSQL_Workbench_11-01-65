package nvc.bcit.soi5shopstart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Category {
    // กำหนดตัวแปร
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;  //เป็นการใส่เพื่อบอกว่า จะไปทางไหน ของList

    public int getUnitInStock() {
        return 0;
    }

    public Category getCategory() {
        return null;
    }
    
}
