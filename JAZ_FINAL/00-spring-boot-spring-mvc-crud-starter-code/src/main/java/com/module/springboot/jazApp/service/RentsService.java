package com.module.springboot.jazApp.service;


import com.module.springboot.jazApp.entity.Rents;

import java.util.List;

public interface RentsService {

    List<Rents> findAll();

    Rents findById(int theId);

    Rents save(Rents theBook);

    void deleteById(int theId);

}
