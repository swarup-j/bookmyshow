package com.application.nextshow.cofigs;

import com.application.nextshow.dtos.ActivityDTO;
import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Activity;
import com.application.nextshow.entities.Show;
import com.application.nextshow.repositories.ActivityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class AppConfigs {


    @Bean
    public ActivityDTO activityDTO() {
        return new ActivityDTO(); // Initialize it with necessary properties if required
    }

    @Bean
    public Activity activity() {
        return new Activity(); // Initialize it with necessary properties if required
    }
    @Bean
    public ShowDTO showDTO(){
        return new ShowDTO();
    }
    @Bean
    public Show show(){
        return new Show();
    }
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }




}