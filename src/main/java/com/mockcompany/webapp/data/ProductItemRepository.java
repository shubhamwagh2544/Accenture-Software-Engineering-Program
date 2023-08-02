package com.mockcompany.webapp.data;

import com.mockcompany.webapp.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    @Query(
            "select p from ProductItem p where lower(p.name) like concat('%', :query, '%') or lower(p.description) like concat('%', :query, '%')"
    )
    List<ProductItem> findProductItemsCustomQuery(String query);

}
