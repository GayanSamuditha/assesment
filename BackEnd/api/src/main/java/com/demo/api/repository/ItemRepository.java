package com.demo.api.repository;

import com.demo.api.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gayan Samuditha
 */

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {





}
