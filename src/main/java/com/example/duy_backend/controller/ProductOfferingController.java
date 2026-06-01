package com.example.duy_backend.controller;

import com.example.duy_backend.dto.request.ProductOfferingCreateReq;
import com.example.duy_backend.dto.request.ProductOfferingFilter;
import com.example.duy_backend.dto.response.ProductOfferingRes;
import com.example.duy_backend.entity.ProductOfferings;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.duy_backend.service.ProductOfferingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductOfferingController {

    private final ProductOfferingService productOfferingService;

    private final ModelMapper modelMapper;

    // http://localhost:8080/products
    @GetMapping("filter")
    public ResponseEntity<List<ProductOfferingRes>> filter(ProductOfferingFilter productOfferingFilter) {
        List<ProductOfferings> productOfferingsList = productOfferingService.filter(productOfferingFilter);

        List<ProductOfferingRes> productOfferingResList = modelMapper.map(productOfferingsList, new TypeToken<List<ProductOfferingRes>>() {
        }.getType());
        return ResponseEntity.ok(productOfferingResList);

    }

    @GetMapping("/id")                // Lấy dữ liệu
    public ResponseEntity<ProductOfferingRes> getById(Long id) {
        id = 5L;
        ProductOfferings productOfferings = productOfferingService.getById(id);

        ProductOfferingRes productOfferingRes = modelMapper.map(productOfferings, ProductOfferingRes.class);

//        ProductOfferingRes productOfferingRes = new ProductOfferingRes();
//        productOfferingRes.setId(productOfferings.getId());
//        productOfferingRes.setName(productOfferings.getName());
//        productOfferingRes.setPrice(productOfferings.getPrice());
//        productOfferingRes.setColor(productOfferings.getColor());

//        System.out.println(productOfferings);
        return ResponseEntity.ok(productOfferingRes);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProductOfferingRes>> getAllProductOfferings(@RequestParam(name = "page_size") Integer pageSize,
                                                                           @RequestParam(name = "page_number") Integer pageNumber) {

        List<ProductOfferings> productOfferings = productOfferingService.getAll(pageSize, pageNumber).getContent();

        List<ProductOfferingRes> productOfferingResList = modelMapper.map(productOfferings, new TypeToken<List<ProductOfferingRes>>() {
        }.getType());

//        List<ProductOfferingRes> productOfferingResList = new ArrayList<>();
//        for (int i = 0; i < productOfferings.size(); i++) {
//            ProductOfferings productOffering = productOfferings.get(i);
//
//            ProductOfferingRes productOfferingRes = modelMapper.map(productOffering, new TypeToken<List<ProductOfferingRes>>() {
//            }.getType());
//
//            ProductOfferingRes productOfferingRes = new ProductOfferingRes();
//            productOfferingRes.setId(productOffering.getId());
//            productOfferingRes.setName(productOffering.getName());
//            productOfferingRes.setPrice(productOffering.getPrice());
//            productOfferingRes.setColor(productOffering.getColor());
//
//            System.out.println("helo");
//            productOfferingResList.add(productOfferingRes);
//        }

        return ResponseEntity.ok(productOfferingResList);
    }


    @GetMapping("/find-by-color")
    public ResponseEntity<List<ProductOfferingRes>> findByColor(String color) {
        color = "red_1";

        List<ProductOfferings> productOfferings = productOfferingService.findByColor(color);

        List<ProductOfferingRes> productOfferingResList = modelMapper.map(productOfferings, new TypeToken<List<ProductOfferingRes>>() {
        }.getType());

        return ResponseEntity.ok(productOfferingResList);
    }

    @GetMapping("/find-by-name-and-price")
    public ResponseEntity<List<ProductOfferingRes>> findByNameAndPrice(String name, Long price) {
        name = "product_5";
        price = 5000l;

        List<ProductOfferings> productOfferings = productOfferingService.findByNameAndPrice(name, price);

        List<ProductOfferingRes> productOfferingResList = modelMapper.map(productOfferings, new TypeToken<List<ProductOfferingRes>>() {
        }.getType());

        return ResponseEntity.ok(productOfferingResList);
    }

    @GetMapping("/find-by-color-and-price")
    public ResponseEntity<List<ProductOfferings>> findByColorAndPrice(String color, Long price) {
        color = "red_5";
        price = 5000l;
        return ResponseEntity.ok(productOfferingService.findByColorAndPrice(color, price));
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<List<ProductOfferings>> findByName(String name) {
        name = "product_5";
        return ResponseEntity.ok(productOfferingService.findByName(name));
    }


    @Transactional
    @PostMapping       // CREATE data
    public ResponseEntity<ProductOfferings> create(@RequestBody ProductOfferingCreateReq request) {
        ProductOfferings product = productOfferingService.createProduct(request);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}") //UPDATE data     //@PathVariable: truyền id vào PathVariable, không quan tâm đến body
    public ResponseEntity<ProductOfferings> update(@PathVariable Long id, @RequestBody ProductOfferings productOfferings) {
        ProductOfferings product = productOfferingService.updateProduct(id, productOfferings);
        return ResponseEntity.ok(product);
    }


}
