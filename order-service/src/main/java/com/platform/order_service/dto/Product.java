package com.platform.order_service.dto;

public class Product {

        private Long id;
        private String name;
        private String description;
        private Double price;
        private Integer stock;

        public Double getPrice() {
            return price;
        }
}
