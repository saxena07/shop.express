package com.example.shop.express.entity;

import com.example.shop.express.enums.UserType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Builder
@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User extends AbstractEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private UserType type;

    @Column
    private String password;
    // stores md5 encypted key

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "seller_detail_id", nullable = true)
    private SellerDetail sellerDetail;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> order;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ContactDetail> contactDetail;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Shipment> shipment;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Payment> payment;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SellerProduct> sellerProduct;

}
