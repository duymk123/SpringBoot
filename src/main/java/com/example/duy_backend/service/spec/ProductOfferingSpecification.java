package com.example.duy_backend.service.spec;

import com.example.duy_backend.entity.ProductOfferings;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

public class ProductOfferingSpecification {
//    String name, Long minPrice, Long maxPrice, String color, String status

    public static Specification<ProductOfferings> likeName(String name) {
        return new Specification<ProductOfferings>() {
            @Override
            public @Nullable Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (name == null || name.isEmpty()) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(root.get("name"), "%" + name + "%");
            }
        };
    }
    public static Specification<ProductOfferings> minPrice(Long minPrice) {
        return new Specification<ProductOfferings>() {
            @Override
            public @Nullable Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (minPrice == null) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
        };
    }

    public static Specification<ProductOfferings> maxPrice(Long maxPrice) {
        return new Specification<ProductOfferings>() {
            @Override
            public @Nullable Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (maxPrice == null) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
        };
    }

    public static Specification<ProductOfferings> color(String color) {
        return new Specification<ProductOfferings>() {
            @Override
            public @Nullable Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (color == null) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.greaterThanOrEqualTo(root.get("color"), color);
            }
        };
    }

    public static Specification<ProductOfferings> status(String status) {
        return new Specification<ProductOfferings>() {
            @Override
            public @Nullable Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (status == null) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.greaterThanOrEqualTo(root.get("status"), status);
            }
        };
    }
}

