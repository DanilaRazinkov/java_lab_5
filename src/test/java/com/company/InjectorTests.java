package com.company;

import com.company.injector.Injector;
import com.company.testModel.ObjectForTest;
import com.company.testModel.ObjectForTest2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InjectorTests {

    @Test
    void firstTest() {
        try {
            assertEquals("field1: forTest.TestObject; field2: forTest.TestChild",
                    (new Injector()).inject(new ObjectForTest()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void secondTest() {
        try {
            assertEquals("field1: forTest.Test2Child; field2: forTest.Test2Object",
                    (new Injector()).inject(new ObjectForTest2()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
