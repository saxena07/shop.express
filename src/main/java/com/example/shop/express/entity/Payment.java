package com.example.shop.express.entity;

import com.example.shop.express.enums.PaymentMode;
import com.example.shop.express.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@Audited
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Payment extends AbstractEntity {

    @Column
    @GeneratedValue()
    private Long paymentDate;

    @Column
    private String TransactionId;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentMode mode;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private PaymentStatus status;

    @Column
    private Long amount;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
