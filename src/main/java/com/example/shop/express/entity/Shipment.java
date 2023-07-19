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
@Table(name = "shipments")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Shipment extends AbstractEntity {

    @Column
    private String dateTime;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "contact_detail_id", nullable = false)
    private ContactDetail contactDetail;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
