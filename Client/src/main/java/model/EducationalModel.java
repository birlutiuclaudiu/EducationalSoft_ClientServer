package model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationalModel extends Subject {

    private Drawing drawing;
    private Language language;
    private String state;
    public EducationalModel(Drawing drawing) {
        this.drawing = drawing;
        this.language = new Language("romanian");
    }

    public EducationalModel() {
        this.drawing = new Drawing();
        this.language = new Language("romanian");
    }

    @Override
    public void notifyObserver(String operation) {
        for (Observer observer : super.getObserverList()) {
            observer.update(operation);
        }
    }
}
