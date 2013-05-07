define([
	'backbone',
	'models/Todo',
], function(Backbone, TodoModel) {
	return Backbone.Collection.extend({
		
		url: "../api/todo-manager/todos",
		
		model: TodoModel,
		
		parse: function(data) {
			return data.todos;
		}
	    
	});
});
