package com.nix.alenevskyi.rentauto.utils;

import com.nix.alenevskyi.rentauto.entity.Image;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {

    public static String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    public static Map<String, String> getErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(fieldError -> fieldError.getField() + "Error",
                        FieldError::getDefaultMessage));
    }

    public static Image toImageEntity(MultipartFile file){
        Image image = null;
        try {
            image = Image.builder()
                    .name(file.getName())
                    .fileName(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .size(file.getSize())
                    .bytes(file.getBytes())
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
