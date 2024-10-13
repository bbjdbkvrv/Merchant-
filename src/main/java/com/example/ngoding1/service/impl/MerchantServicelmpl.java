package com.example.ngoding1.service.impl;

import com.example.ngoding1.dto.MerchantDTO;
import com.example.ngoding1.model.Merchant;
import com.example.ngoding1.repository.MerchantRepository;
import com.example.ngoding1.service.MerchantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantServicelmpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant) {
        final Merchant result = merchantRepository.save(merchant);
        return result;
    }

    @Override
    public Merchant update(Long id, Merchant merchant) {
        Merchant result = findById(id);
        if (result != null){
            result.setName(merchant.getName());
            return merchantRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Merchant result = findById(id);
        if (result != null){
            merchantRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public List<Merchant> findAll() {
        return merchantRepository.findAll();

    }

    @Override
    public Page<Merchant> findAll(Pageable pageable) {
        return merchantRepository.findAll(pageable);
    }

    @Override
    public Merchant findById(Long id) {
        return merchantRepository.findById(id).get();
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public MerchantDTO mapToDto(Merchant merchant) {
        return mapper.convertValue(merchant, MerchantDTO.class);
    }

    @Override
    public Merchant mapToEntity(MerchantDTO merchantDTO) {
        return mapper.convertValue(merchantDTO, Merchant.class);
    }

    @Override
    public Merchant findAll(Long id) {
        final Optional<Merchant> result = merchantRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }
}
