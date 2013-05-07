define([
    'backbone',
    'marionette',
    'client-factory',
    'text!templates/ItemView.html'
], function(Backbone, Marionette, ClientFactory, tpl) {
	return Backbone.Marionette.ItemView.extend({

		template: tpl,

		modelEvents: {
			"change": "render"
		},

		events: {
			"click .todo" : "toggleTodo",
			"click .delete-todo" : "deleteTodo",
		},

		toggleTodo : function(e) {
			e.preventDefault();
			this.model.save({ done: true }, { wait: true });
		},

		deleteTodo: function(e) {
			e.preventDefault();
			this.model.destroy({ wait: true });
		}

	});
});
