package com.example.shop.express.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderItem extends AbstractEntity {

    @Column
    private Integer quantity;

    @Column
    private Double price;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "seller_product_id", nullable = false)
    private SellerProduct sellerProduct;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
