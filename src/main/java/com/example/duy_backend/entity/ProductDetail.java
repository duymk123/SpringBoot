package com.example.duy_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitalizer","handle"})
public class ProductDetail implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "feature")
    private String feature;

    @Column(name = "power")
    private String power;

    @Column(name = "brand")
    private String brand;

    @Column(name = "image")
    private String image;

    @Column(name = "video")
    private String video;

    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    private List<ProductOfferingDetail> productOfferingDetails;

//    @OneToOne(mappedBy = "productDetail")
//    @OneToMany(mappedBy = "productDetail")
//    private List<ProductOfferings> productOfferings;
}
