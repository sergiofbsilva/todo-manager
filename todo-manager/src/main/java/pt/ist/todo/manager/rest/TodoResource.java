package pt.ist.todo.manager.rest;

import java.util.Collection;

import javax.ws.rs.Path;

import pt.ist.bennu.core.domain.Bennu;
import pt.ist.bennu.core.rest.DomainObjectResource;
import pt.ist.todo.manager.domain.Todo;

@Path("/todos")
public class TodoResource extends DomainObjectResource<Todo> {

    @Override
    public Collection<Todo> all() {
        return Bennu.getInstance().getTodo();
    }

    @Override
    public String collectionKey() {
        return "todos";
    }

    @Override
    public boolean delete(Todo todo) {
        return todo.delete();
    }

    @Override
    public String getAccessExpression() {
        return "anyone";
    }

    @Override
    public Class<Todo> type() {
        return Todo.class;
    }

}
