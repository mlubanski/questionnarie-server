package smartsoftwaredevelopment.com.answer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor()
@Accessors
public class Answer {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Getter
  private long id;
  
  @Getter
  @Setter
  private String text;
  
  @Getter
  @Setter
  private Integer sequence;
  
  public Answer(String text, Integer sequence) {
    this.text = text;
    this.sequence = sequence;
  }
}
