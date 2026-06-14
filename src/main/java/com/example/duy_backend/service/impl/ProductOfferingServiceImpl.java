package com.example.duy_backend.service.impl;

import com.example.duy_backend.common.StatusEnum;
import com.example.duy_backend.dto.request.ProductOfferingCreateReq;
import com.example.duy_backend.dto.request.ProductOfferingFilter;
import com.example.duy_backend.entity.ProductOfferings;
import com.example.duy_backend.service.spec.ProductOfferingSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.duy_backend.repository.ProductOfferingRepo;
import com.example.duy_backend.service.ProductOfferingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductOfferingServiceImpl implements ProductOfferingService {

    private final ProductOfferingRepo productOfferingRepo;
    private final EntityManager entityManager;

    @Override
    public ProductOfferings getById(Long id) {
        Optional<ProductOfferings> product = productOfferingRepo.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Khong tim thay product");
        } else {
            return product.get();
        }

    }


    @Override
    public Page<ProductOfferings> getAll(Integer pageSize, Integer pageNumber) {
//        List<ProductOfferings>  productOfferings = productOfferingRepo.getAllByPage(pageSize, pageSize * (pageNumber -1));
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("price").descending());
        Page<ProductOfferings> productOfferings = productOfferingRepo.findAll(pageable);
        if (productOfferings.getSize() >= 100) {
            log.info("Page empty because of size 0");
            return Page.empty();
        }
            log.info("Get products successfully");
        return productOfferings;
    }

    @Override
    public List<ProductOfferings> findByColor(String color) {
        return productOfferingRepo.findByColor(color);
    }

    @Override
    public List<ProductOfferings> findByNameAndPrice(String name, Long price) {
        return productOfferingRepo.findByNameAndPrice(name, price);
    }

    @Override
    public List<ProductOfferings> findByColorAndPrice(String color, Long price) {
        return productOfferingRepo.findByColorAndPrice(color, price);
    }

    @Override
    public List<ProductOfferings> findByName(String name) {
        return productOfferingRepo.findByName(name);
    }

    @Transactional
    @Override
    public ProductOfferings createProduct(ProductOfferingCreateReq request) {
        if (request.getName() == null || request.getPrice() == null || request.getColor() == null) {
            throw new RuntimeException("Chua dien day du thong tin");
        }
        ProductOfferings productOfferings = new ProductOfferings();
        productOfferings.setName(request.getName());
        productOfferings.setPrice(request.getPrice());
        productOfferings.setColor(request.getColor());
        productOfferings.setStatus(StatusEnum.ACTIVE);
        log.info("Create new product offering");
//        ProductOfferings saveProduct = productOfferingRepo.save(productOfferings);
        return productOfferingRepo.save(productOfferings);
    }

    @Transactional
    @Override
    public ProductOfferings updateProduct(Long id, ProductOfferings productOfferings) {
        getById(id); // Lấy ra id và xử lí validate
        productOfferings.setId(id); //Thiết lập luôn id của thằng PathVariable
        ProductOfferings saveProduct = productOfferingRepo.save(productOfferings);
//        if (true) {
//            log.error("test Rollback");
//            throw new RuntimeException("Test xem @Transactional");
//        }
        return saveProduct;
    }

    @Override
    public List<ProductOfferings> filter(ProductOfferingFilter productOfferingFilter) {
//        Specification<ProductOfferings> specification = Specification.where(null);
        Specification<ProductOfferings> specification = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if (productOfferingFilter.getName() != null && !productOfferingFilter.getName().isEmpty()) {
            specification = specification.and(ProductOfferingSpecification.likeName(productOfferingFilter.getName()));
        }

        if (productOfferingFilter.getMinPrice() != null) {
            specification = specification.and(ProductOfferingSpecification.minPrice(productOfferingFilter.getMinPrice()));
        }

        if (productOfferingFilter.getMaxPrice() != null) {
            specification = specification.and(ProductOfferingSpecification.maxPrice(productOfferingFilter.getMaxPrice()));
        }

        if (productOfferingFilter.getColor() != null && !productOfferingFilter.getColor().isEmpty()) {
            specification = specification.and(ProductOfferingSpecification.color(productOfferingFilter.getColor()));
        }

        if (productOfferingFilter.getStatus() != null) {
            specification = specification.and(ProductOfferingSpecification.status(productOfferingFilter.getStatus()));
        }
        return productOfferingRepo.findAll(specification);
    }


    //    @Override
//    @Transactional
//    public List<ProductOfferings> filter(String name, Long minPrice, Long maxPrice, String color, String status) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ProductOfferings> query = criteriaBuilder.createQuery(ProductOfferings.class);
//
//        Root<ProductOfferings> root = query.from(ProductOfferings.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        if( name != null && !name.isEmpty()) {
//            Predicate predicate  = criteriaBuilder.like(root.get("name"),"%" + name + "%");
//            predicates.add(predicate);
//        }
//
//        if(minPrice != null){
//            Predicate predicate  = criteriaBuilder.greaterThanOrEqualTo(root.get("price"),minPrice);
//            predicates.add(predicate);
//        }
//
//        if(maxPrice != null){
//            Predicate predicate  = criteriaBuilder.lessThanOrEqualTo(root.get("price"),maxPrice);
//            predicates.add(predicate);
//        }
//
//        if(color != null && !color.isEmpty()) {
//            Predicate predicate = criteriaBuilder.like(root.get("color"), "%" + color + "%");
//            predicates.add(predicate);
//        }
//
//        if(status != null && !status.isEmpty()) {
//            Predicate predicate = criteriaBuilder.equal(root.get("status"), status);
//            predicates.add(predicate);
//        }
//
//        query.where(predicates.toArray(new Predicate[0]));
//        List<ProductOfferings> productOfferings = entityManager.createQuery(query).getResultList();
//        return productOfferings;
//    }

}
