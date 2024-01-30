package com.module.springboot.jazApp.repository;


import com.module.springboot.jazApp.entity.Rents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentsRepository extends JpaRepository<Rents, Integer> {}
