package ru.ivanov.sensor2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args ) {
   
       SensorsController.start(new AnnotationConfigApplicationContext (ApplicationConfig.class));
    }
}
