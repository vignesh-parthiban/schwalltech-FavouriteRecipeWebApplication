package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.*;
 
@Repository
public interface MenuRepository
        extends JpaRepository<MenuEntity, Long> {
 
}
