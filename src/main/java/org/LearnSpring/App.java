package org.LearnSpring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        House HouseBean = context.getBean(House.class);

            HouseBean.buildHouse();

    }
}