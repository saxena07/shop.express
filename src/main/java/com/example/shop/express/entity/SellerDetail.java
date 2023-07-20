package com.example.shop.express.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@Audited
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller_details")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SellerDetail extends AbstractEntity{

    @Column
    private String GSTIN;

    @Column
    private String organisation;

}
