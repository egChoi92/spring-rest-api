package com.helloworld.rest_api.repository;

import com.helloworld.rest_api.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// !!Repository 하나당 Entity 하나 (ItemRepository - ItemEntity)
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
}
