package com.klu.demo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.klu.demo.config.AppConfig; 
import com.klu.demo.model.CourseRegistration;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CourseRegistration cr = context.getBean(CourseRegistration.class);
        cr.display();
    }
}
