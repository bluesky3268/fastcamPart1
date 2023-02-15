package org.example.ch6;

import org.example.ch6.annotation.Controller;
import org.example.ch6.annotation.Service;
import org.example.ch6.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class ReflectionTest {

    private Logger log = LoggerFactory.getLogger(ReflectionTest.class);
    /**
     * 내가 만든 @Controller, @Service가 붙어있는 모든 클래스를 찾아서 출력해보자
     */
    @Test
    void annotationScan() {
        Set<Class<?>> beans = getTypesAnnotationWith(List.of(Controller.class, Service.class));
        log.info("beans : [{}]", beans);
    }

    @Test
    void showClasses() {
        Class<User> clazz = User.class;
        log.info("===== {} =====", clazz.getName());
        log.info("All Constructors of User : {}", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        log.info("All fields of User : {}", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        log.info("All methods of User : {}", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    /**
     * 힙에 로드되어 있는 클래스 정보 가져오는 방법들
     */
    @Test
    void load() throws ClassNotFoundException {
        Class<User> clazz1 = User.class;

        User user = new User("hello", "world");
        Class<? extends User> clazz2 = user.getClass();

        Class<?> clazz3 = Class.forName("org.example.ch6.model.User");

        log.info("clazz1 : {}", clazz1);
        log.info("clazz2 : {}", clazz2);
        log.info("clazz3 : {}", clazz3);

        assertThat(clazz1 == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
        assertThat(clazz1 == clazz3).isTrue();
    }

    private static Set<Class<?>> getTypesAnnotationWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();

        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }


}
