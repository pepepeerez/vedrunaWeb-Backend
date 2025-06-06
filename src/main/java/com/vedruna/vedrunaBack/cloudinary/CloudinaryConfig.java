package com.vedruna.vedrunaBack.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dnlggc5sw",
                "api_key", "832297154688527",
                "api_secret", "X35sx0_YflZhdjnCH99eXiCO6WY"
        ));
    }
}
