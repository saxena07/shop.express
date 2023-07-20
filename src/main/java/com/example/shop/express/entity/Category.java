package com.example.shop.express.entity;

import com.example.shop.express.enums.ProductCategory;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Builder
@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Category extends AbstractEntity {


    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private ProductCategory name;

    @Column
    private String description;

}
