package com.meefee.main;

import com.meefee.main.controller.ArtistPersonalDataControllerTest;
import com.meefee.main.controller.RegistrationControllerTest;
import com.meefee.main.security.LoginTest;
import org.junit.jupiter.api.ClassDescriptor;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.ClassOrdererContext;

import java.util.Comparator;

public class SpringBootTestClassOrderer implements ClassOrderer {

    @Override
    public void orderClasses(ClassOrdererContext context) {
        context.getClassDescriptors().sort(Comparator.comparingInt(SpringBootTestClassOrderer::getOrder));
    }

    private static int getOrder(ClassDescriptor classDescriptor) {
        if(classDescriptor.getTestClass() == RegistrationControllerTest.class) {
            return 1;
        } else if(classDescriptor.getTestClass() == LoginTest.class) {
            return 2;
        } else if(classDescriptor.getTestClass() == ArtistPersonalDataControllerTest.class) {
            return 3;
        } else {
            return 4;
        }
    }

}
