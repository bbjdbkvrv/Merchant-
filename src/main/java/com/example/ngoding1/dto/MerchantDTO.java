package com.example.ngoding1.dto;

import java.util.List;

public record MerchantDTO (Long id, String name, List<StoreDTO> stores){
}
