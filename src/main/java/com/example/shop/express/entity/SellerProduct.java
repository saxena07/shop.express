package com.example.shop.express.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.Table;

@Data
@Builder
@Entity
@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller_product")
public class SellerProduct extends AbstractEntity {

    @Column
    private Integer quantity;

    @Column
    private Double price;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User user;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
