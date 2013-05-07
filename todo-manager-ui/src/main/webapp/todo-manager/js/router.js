define([
    'jquery',
    'underscore',
    'mustache',
    'backbone',
    'marionette',
    'app',
    'client-factory'
], function($, _, Mustache, Backbone, Marionette, App, ClientFactory) {

    var Router = Backbone.Marionette.AppRouter.extend({

        initialize: function() {
           
        },
        
        appRoutes: {
    		"" : "showHome"
    	},
    	
    	controller: {

    		showHome : function() {
    			require(['views/Home'], function(HomeView) {
                    console.log(ClientFactory);
                    var todoCollection = ClientFactory.TodoCollection;
                    todoCollection.fetch({ success : function() {
                        App.page.show(new HomeView({ collection: todoCollection }));
                    }});
    			});
    		}
    	}
    });
    
    Bankai.setRouter(Router);
    
});
