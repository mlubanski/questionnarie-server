package smartsoftwaredevelopment.com.questionnaire;

import java.util.Date;
import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import smartsoftwaredevelopment.com.question.Question;


@Projection(name = "withQuestions", types = { Questionnaire.class }) 
public interface AllProjection {

  Long getId();
  String getName();
  Date getDate();
  Set<Question> getQuestions();
}
