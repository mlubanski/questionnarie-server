package smartsoftwaredevelopment.com.questionnaire;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import smartsoftwaredevelopment.com.question.Question;

@Entity
@EqualsAndHashCode(exclude="questions")
@ToString
@NoArgsConstructor
public class Questionnaire {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    private long id;
    
    @Getter
    @Setter
    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
//    @Column(insertable=false)
    @Getter
    @Setter
    private Date date;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn(name="QUESTIONNAIRE_ID", nullable=false, insertable=true)
    @Getter
    @Setter
    private Set<Question> questions = new HashSet<>();
    
    public Questionnaire(String name) {
        this.name = name;
        this.date = new Date();
    }
    
    public void addQuestion(Question question) {
      questions.add(question);
    }
}