package com.toy.shop.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class CovertUtils {

    private static ModelMapper modelMapper;

    private CovertUtils(ModelMapper modelMapper) {
        CovertUtils.modelMapper = modelMapper;
    }

    public static <D> D convert(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static <D> Page<D> convertToPage(Page<?> source, Class<D> destinationType) {
        List<D> destination = new ArrayList<>();

        List<?> content = source.getContent();
        Pageable pageable = source.getPageable();
        long totalElements = source.getTotalElements();

        content.stream().forEach(item -> {
            destination.add(modelMapper.map(item, destinationType));
        });

        return new PageImpl<D>(destination, pageable, totalElements);
    }

    public static <D> List<D> convertToList(List<?> source, Class<D> destinationType) {
        List<D> destination = new ArrayList<>();

        source.stream().forEach(item -> {
            destination.add(modelMapper.map(item, destinationType));
        });

        return destination;
    }
}
