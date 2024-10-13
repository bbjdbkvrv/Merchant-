package com.example.ngoding1.repository;

import com.example.ngoding1.model.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    Page<Merchant> findAll(Pageable pageable);
}
