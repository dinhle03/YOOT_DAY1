package com.example.yootday1.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        //Tao object va cau hinh. MODEL MAPPER nen de STRICT
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setCollectionsMergeEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setAmbiguityIgnored(false);
        return modelMapper;
    }
}
