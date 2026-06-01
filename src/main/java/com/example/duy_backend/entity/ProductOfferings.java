package com.example.duy_backend.entity;

import com.example.duy_backend.common.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "product_offerings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class    ProductOfferings implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "color")
    private String color;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

//    @OneToOne(fetch = FetchType.LAZY)  //EAGER: show full LAZY: gọi mới show
//    @ManyToOne
//    @JoinColumn(name = "detail_id", referencedColumnName = "id")  (FOREIGN KEY)
//    @JsonIgnore  // CHE DẤU DỮ LIỆU
//    private ProductDetail productDetail;

    @OneToMany(mappedBy = "productOfferings")   // 1 productoffering thì sẽ có N productofferingdetail
    private List<ProductOfferingDetail> productOfferingDetails;

    @Override
    public String toString() {
        return "ProductOfferings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }


}


