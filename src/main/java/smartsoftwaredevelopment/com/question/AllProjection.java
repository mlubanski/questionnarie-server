package smartsoftwaredevelopment.com.question;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "withAnswers", types = { Question.class }) 
public interface AllProjection {

  Long getId();
  String getText();
  Integer getSequence();
  Set<Question> getAnswers();
}
