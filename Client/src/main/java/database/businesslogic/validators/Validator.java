package database.businesslogic.validators;

public interface Validator<T> {

    /*
     * Metoda ce va trebui implemetnata de clasele validare a anumitor campuri
     * In cazul in care campurile nu vor corsepunde sa va arunca o exceptie
     * @param t paramtru generic
     */
    public void validate(T t) throws Exception;
}
