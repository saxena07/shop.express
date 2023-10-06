package com.example.shop.express.repository;

import com.example.shop.express.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailRepository extends JpaRepository<ContactDetail,Integer> {
}
