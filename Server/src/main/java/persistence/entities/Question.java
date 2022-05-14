package persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
@Builder
public class Question {
    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "romanian_body")
    private String romanianBody;
    @Column(name = "english_body")
    private String englishBody;
    @Column(name = "german_body")
    private String germanBody;

    //romanian answers
    @Column(name = "romanian_answer_a")
    private String romanianAnswerA;

    @Column(name = "romanian_answer_b")
    private String romanianAnswerB;

    @Column(name = "romanian_answer_c")
    private String romanianAnswerC;

    @Column(name = "romanian_answer_d")
    private String romanianAnswerD;

    //english answers
    @Column(name = "english_answer_a")
    private String englishAnswerA;

    @Column(name = "english_answer_b")
    private String englishAnswerB;

    @Column(name = "english_answer_c")
    private String englishAnswerC;

    @Column(name = "english_answer_d")
    private String englishAnswerD;

    //german answers
    @Column(name = "german_answer_a")
    private String germanAnswerA;

    @Column(name = "german_answer_b")
    private String germanAnswerB;

    @Column(name = "german_answer_c")
    private String germanAnswerC;

    @Column(name = "german_answer_d")
    private String germanAnswerD;

    //correct answer : a, b , c or d
    @Column(name = "correct_answer")
    private Character correctAnswer;

    @OneToMany(mappedBy = "question")
    private List<QuizQuestion> quizQuestionList;

    @Column(name = "figure_url")
    private String figureURL;

}
