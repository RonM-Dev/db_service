package com.rondev.db_service.repository;

import com.rondev.db_service.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote, Integer> {

    List<Quote> findByUserName(String userName);

}
