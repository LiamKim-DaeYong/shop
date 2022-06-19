package com.toy.shop.utils;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class ConvertUtils {

    private static ModelMapper modelMapper;

    private ConvertUtils(ModelMapper modelMapper) {
        ConvertUtils.modelMapper = modelMapper;
    }

    public static void addConverter(Converter converter) {
        modelMapper.addConverter(converter);
    }

    public static <D> D convert(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static <D> Page<D> convertToPage(Page<?> source, Class<D> destinationType) {
        List<?> content = source.getContent();
        Pageable pageable = source.getPageable();
        long totalElements = source.getTotalElements();

        return new PageImpl<>(content.stream()
                .map(obj -> modelMapper.map(obj, destinationType))
                .collect(Collectors.toList()), pageable, totalElements);
    }

    public static <D> List<D> convertToList(List<?> source, Class<D> destinationType) {
        return source.stream().map(obj -> modelMapper.map(obj, destinationType))
                .collect(Collectors.toList());
    }
}
