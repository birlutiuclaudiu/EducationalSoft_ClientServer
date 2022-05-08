package dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QuestionDTO {

    private int id;
    private String romanianBody;
    private String englishBody;
    private String germanBody;
    private String romanianAnswerA;
    private String romanianAnswerB;
    private String romanianAnswerC;
    private String romanianAnswerD;
    private String englishAnswerA;
    private String englishAnswerB;
    private String englishAnswerC;
    private String englishAnswerD;
    private String germanAnswerA;
    private String germanAnswerB;
    private String germanAnswerC;
    private String germanAnswerD;
    private Character correctAnswer;
    private String figureURL;
}
