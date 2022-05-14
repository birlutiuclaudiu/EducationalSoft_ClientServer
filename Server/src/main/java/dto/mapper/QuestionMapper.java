package dto.mapper;


import dto.QuestionDTO;
import persistence.entities.Question;

public final class QuestionMapper {

    public static QuestionDTO toDTO(Question question) {
        return QuestionDTO.builder()
                .id(question.getId())
                .romanianBody(question.getRomanianBody())
                .romanianAnswerA(question.getRomanianAnswerA())
                .romanianAnswerB(question.getEnglishAnswerB())
                .romanianAnswerC(question.getRomanianAnswerC())
                .romanianAnswerD(question.getRomanianAnswerD())
                .englishBody(question.getEnglishBody())
                .englishAnswerA(question.getEnglishAnswerA())
                .englishAnswerB(question.getEnglishAnswerB())
                .englishAnswerC(question.getGermanAnswerC())
                .englishAnswerD(question.getEnglishAnswerD())
                .germanBody(question.getGermanBody())
                .germanAnswerA(question.getGermanAnswerA())
                .germanAnswerB(question.getGermanAnswerB())
                .germanAnswerC(question.getGermanAnswerC())
                .germanAnswerD(question.getGermanAnswerD())
                .correctAnswer(question.getCorrectAnswer())
                .figureURL(question.getFigureURL())
                .build();
    }
}
