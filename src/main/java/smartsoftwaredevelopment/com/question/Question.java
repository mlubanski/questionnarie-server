package smartsoftwaredevelopment.com.question;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import smartsoftwaredevelopment.com.answer.Answer;

@Entity
@EqualsAndHashCode(exclude="answers")
@ToString
@NoArgsConstructor
@Accessors
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private long id;

	@Getter
	@Setter
	private String text;

	@Getter
	@Setter
	private Integer sequence;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_ID", nullable = false, insertable = true)
	@Getter
	@Setter
	private Set<Answer> answers = new HashSet<>();

	public Question(String text, Integer sequence) {
		this.text = text;
		this.sequence = sequence;
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}
}
