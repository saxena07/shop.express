package com.example.shop.express.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_details")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContactDetail extends AbstractEntity {

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String zipCode;

    @Column
    private Boolean isDefault;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
