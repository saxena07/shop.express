package com.example.shop.express.entity;

import com.example.shop.express.enums.OrderStatus;
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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@Entity
@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Order extends AbstractEntity {

    @Column(name = "ordered_at")
    private Long orderedAt;

    @Column
    private Double totalAmount;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> orderItem;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Payment> payment;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
