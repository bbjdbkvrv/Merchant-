package com.example.ngoding1.service;

import com.example.ngoding1.dto.StoreDTO;
import com.example.ngoding1.model.Store;

public interface StoreService {

    Store addStore(Long merchantId, Store store);

    Store mapToEntity(StoreDTO storeDTO);
    StoreDTO mapToDto(Store store);
}
