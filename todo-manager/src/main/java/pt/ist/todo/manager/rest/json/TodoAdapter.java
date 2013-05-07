package pt.ist.todo.manager.rest.json;

import org.joda.time.DateTime;

import pt.ist.bennu.core.annotation.DefaultJsonAdapter;
import pt.ist.bennu.json.JsonAdapter;
import pt.ist.bennu.json.JsonBuilder;
import pt.ist.todo.manager.domain.Todo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@DefaultJsonAdapter(Todo.class)
public class TodoAdapter implements JsonAdapter<Todo> {

    @Override
    public Todo create(JsonElement el, JsonBuilder ctx) {
        final JsonObject json = el.getAsJsonObject();
        final String text = json.get("text").getAsString();
        return new Todo(text);
    }

    @Override
    public Todo update(JsonElement arg0, Todo todo, JsonBuilder ctx) {
        todo.toggle();
        return todo;
    }

    @Override
    public JsonElement view(Todo todo, JsonBuilder ctx) {
        JsonObject view = new JsonObject();
        view.addProperty("id", todo.getExternalId());
        view.addProperty("text", todo.getText());
        final DateTime completed = todo.getCompleted();
        if (completed == null) {
            view.addProperty("done", false);
        } else {
            view.addProperty("done", completed.toString());
        }
        return view;
    }

}
