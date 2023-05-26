package com.shortlymsg.mailauthentication;

import com.shortlymsg.mailauthentication.service.EmailSenderService;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class MailAuthenticationApplication {

    private final EmailSenderService senderService;
    public MailAuthenticationApplication(EmailSenderService senderService) {
        this.senderService = senderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MailAuthenticationApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String description,
                                 @Value("${application-version}") String version){
        return new OpenAPI()
                .info(new Info()
                .title("Msg OpenAPI Test")
                .version(version)
                .description(description)
                .license(new License().name("Msg OpenAPI Test Licence")));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        senderService.sendEmail("42msg42@gmail.com"
                ,"Bot test"
                ,"One time password: {token} you can use it.");
    }
}
