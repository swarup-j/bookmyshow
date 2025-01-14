package com.application.nextshow.cofigs;

import com.application.nextshow.dtos.ActivityDTO;
import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Activity;
import com.application.nextshow.entities.Show;
import com.application.nextshow.repositories.ActivityRepository;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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


}