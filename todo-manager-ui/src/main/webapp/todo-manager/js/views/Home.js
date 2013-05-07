define([
    'backbone',
    'marionette',
    'client-factory',
    'views/TodoItem',
    'text!templates/Home.html'
], function(Backbone, Marionette, ClientFactory, TodoItemView, tpl) {
	return Backbone.Marionette.CompositeView.extend({

		template: tpl,

		itemView: TodoItemView,

		itemViewContainer: "ul",

		events: {
			"keypress #todo-input-textbox" : "createTodo",
		},

		createTodo: function(e) {
	        if (e.keyCode != 13) return;
	        e.preventDefault();
			var text = $("#todo-input-textbox").val();
			$(e.currentTarget).val("");
			ClientFactory.TodoCollection.create({ text: text }, { wait: true });
		}
	});
});
