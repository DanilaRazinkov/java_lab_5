package com.company;

import com.company.exampleModel.SomeBean;
import com.company.injector.Injector;

public class Main {

    public static void main(String[] args) { // в main реализован пример из задания
        SomeBean sb = (new Injector()).inject(new SomeBean());
        sb.foo();
    }
}
