package ru.learnUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@Slf4j
public class Main implements ApplicationContextAware {

    private static ApplicationContext context;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        Locale locale = Locale.US;
        Integer secretNam = (int) (Math.random() * 1000);
        System.out.println(secretNam);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            //System.out.println(context.getMessage("hi", null, locale.ENGLISH));
            log.info(context.getMessage("hi", null, locale));
            int read = Integer.parseInt(reader.readLine());

            while (read != secretNam) {
                if (read < secretNam) {
                    //System.out.println(context.getMessage("bigger", null, locale));
                    log.info(context.getMessage("bigger", null, locale));
                }
                if (read > secretNam){
                    //System.out.println(context.getMessage("less", null, locale));
                    log.info(context.getMessage("less", null, locale));
                }
                //System.out.println(context.getMessage("try", null, locale));
                log.info(context.getMessage("try", null, locale));
                read = Integer.parseInt(reader.readLine());
            }
            //System.out.println(context.getMessage("guessed", new Object[]{"" + secretNam}, locale) + secretNam);
            log.info(context.getMessage("guessed", new Object[]{secretNam.toString()}, locale));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
