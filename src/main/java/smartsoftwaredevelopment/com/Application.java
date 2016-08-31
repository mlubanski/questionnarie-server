package smartsoftwaredevelopment.com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import smartsoftwaredevelopment.com.answer.Answer;
import smartsoftwaredevelopment.com.question.Question;
import smartsoftwaredevelopment.com.questionnaire.Questionnaire;
import smartsoftwaredevelopment.com.questionnaire.QuestionnaireRepository;

@SpringBootApplication
public class Application {
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
  @Bean
  public CommandLineRunner demo(QuestionnaireRepository repository) {
      return (args) -> {
//          Questionnaire questionnaire = new Questionnaire("JUG: Bielsko-Biała 2016");
//          
//          Question question1 = new Question("Jak podoba Ci się JUG?", 1);
//          question1.addAnswer(new Answer("Jest extra", 1));
//          question1.addAnswer(new Answer("Super", 2));
//          question1.addAnswer(new Answer("Od dziś będę używał liquibase :)", 3));
//
//          questionnaire.addQuestion(question1);
//          
//          repository.save(questionnaire);
      };
  }
  
  /**
   * http://stackoverflow.com/a/31748398/122441 until https://jira.spring.io/browse/DATAREST-573
   * @return
   */
  @Bean
  public FilterRegistrationBean corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOrigin("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("OPTIONS");
      config.addAllowedMethod("HEAD");
      config.addAllowedMethod("GET");
      config.addAllowedMethod("PUT");
      config.addAllowedMethod("POST");
      config.addAllowedMethod("DELETE");
      config.addAllowedMethod("PATCH");
      source.registerCorsConfiguration("/**", config);
      // return new CorsFilter(source);
      final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
      bean.setOrder(0);
      return bean;
  }
}
