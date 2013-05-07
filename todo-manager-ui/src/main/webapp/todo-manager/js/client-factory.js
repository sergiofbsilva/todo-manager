define([
    'collections/Todo'
], function(TodoCollection) {
	
	var TodoManager = TodoManager || {};

	TodoManager.TodoCollection = new TodoCollection || {};

	return TodoManager;
});