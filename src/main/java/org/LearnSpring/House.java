package org.LearnSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class House {

    @Autowired
    Bricks brick;
 public void buildHouse(){

     brick.bricksFactory();
     System.out.println("घर बांधण्याचे काम सुरू झाले...");
 }


}
