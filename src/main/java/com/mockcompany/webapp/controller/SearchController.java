package com.mockcompany.webapp.controller;

import com.mockcompany.webapp.model.ProductItem;
import com.mockcompany.webapp.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class SearchController {

    private final SearchService service;

    @GetMapping("/api/products/search")
    public Collection<ProductItem> search(@RequestParam("query") String query) {
        return this.service.search(query);
    }
}
