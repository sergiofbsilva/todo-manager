package pt.ist.todo.manager.domain;

import org.joda.time.DateTime;

import pt.ist.bennu.core.domain.Bennu;
import pt.ist.bennu.service.Service;

public class Todo extends Todo_Base {

    public Todo(String text) {
        setText(text);
        setCompleted(null);
        setBennu(Bennu.getInstance());
    }

    @Service
    public Boolean delete() {
        removeBennu();
        deleteDomainObject();
        return true;
    }

    public void toggle() {
        if (getCompleted() != null) {
            setCompleted(null);
        } else {
            setCompleted(new DateTime());
        }
    }

}
