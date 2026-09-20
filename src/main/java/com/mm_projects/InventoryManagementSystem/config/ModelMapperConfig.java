package com.mm_projects.InventoryManagementSystem.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    // we use model mapper to work with every entity, and it's dto
    // instead of write mapper for every entity to map between it, and it's dto
    // we create this model mapper
    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        // telling model mapper to pring it's configurations to edit it
        modelMapper.getConfiguration()
                //enable matching between same field names between two classes
                .setFieldMatchingEnabled(true)
                // allow modelMapper to access private fields in the classes he worked with
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                //specifying STANDARD level of matching between fields
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return modelMapper;
    }
}
