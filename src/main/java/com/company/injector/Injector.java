package com.company.injector;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    /**
     * Производит внедрение необходимых классов, в поля помеченных аннотацией AutoInjectable и не заполненые
     * @param obj объект для внедрение
     * @param <T> тип объекта
     * @return возвращает объект с которым производилось внедрение
     */
    public <T> T inject(T obj) {
        Class<?> classToInject = obj.getClass();
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/injector.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Field field : classToInject.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.getAnnotation(AutoInjectable.class) != null && field.get(obj) == null) {
                    field.set(obj, Class
                            .forName("com.company." + properties.getProperty(field.getType().getName().replaceAll("com.company.", "")))
                            .getDeclaredConstructor()
                            .newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
