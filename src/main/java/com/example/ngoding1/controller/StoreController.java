package com.example.ngoding1.controller;

import com.example.ngoding1.dto.StoreDTO;
import com.example.ngoding1.model.Store;
import com.example.ngoding1.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/store"})
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/add/{merchantId}")
    public StoreDTO addStoreToMerchant(@PathVariable Long merchantId, @RequestBody StoreDTO request) {
        final Store store = storeService.mapToEntity(request);
        final Store result = storeService.addStore(merchantId,store);
        return storeService.mapToDto(result);
    }
}
