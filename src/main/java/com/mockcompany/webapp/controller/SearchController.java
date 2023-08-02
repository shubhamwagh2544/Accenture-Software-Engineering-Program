package com.mockcompany.webapp.controller;

import com.mockcompany.webapp.data.ProductItemRepository;
import com.mockcompany.webapp.model.ProductItem;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SearchController {

    private final ProductItemRepository productItemRepository;

    @GetMapping("/api/products/search")
    public Collection<ProductItem> search(@RequestParam("query") String query) {

        return this.productItemRepository
                //.findProductItemsCustomQuery(query.toLowerCase());
                .findAll()
                .stream()
                .filter(productItem -> productItem.getName().equalsIgnoreCase(query) ||
                        productItem.getName().toLowerCase().contains(query.toLowerCase())
                )
                .collect(Collectors.toList());

    }
}
