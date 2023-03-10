package by.gsu.pms;

import java.io.Serializable;

public class Manager implements Serializable {
    public Manager() {
        this("Unnamed", -1, false);
    }
    
    public Manager(String surname, int age, boolean isCompetent) {
        _surname = surname;
        _age = age;
        _isCompetent = isCompetent;
    }
    
    private final String _surname;
    private final int _age;
    private final boolean _isCompetent;
    
    public String getSurname() {
        return _surname;
    }
    
    public int getAge() {
        return _age;
    }
    
    public boolean isCompetent() {
        return _isCompetent;
    }
}
