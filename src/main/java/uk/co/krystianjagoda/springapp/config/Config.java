package uk.co.krystianjagoda.springapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import uk.co.krystianjagoda.springapp.app.service.PlayerService;
import uk.co.krystianjagoda.springapp.app.web.PlayerController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = PlayerController.class)
@ComponentScan(basePackageClasses = PlayerService.class)
public class Config {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
