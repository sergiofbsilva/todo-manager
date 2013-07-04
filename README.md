#Bankai Repository


Bankai is a library to develop backbone + marionette.js applications respecting a particular structure.

    .
    |-- bankai <- main module
    |-- bankai-project <- parent project for client modules
    |-- bankai-project-archetype <- archetype to create initial structure of client module
    |-- pom.xml <- aggretator pom


##Bankai

Bankai is a lightweight framework that allows one to build
a require.js based application using Backbone and Marionette.

It allows the development of new applications just by specifying
the models, collections, views and i18n files.

###Main Features


Bankai will automatically include common javascript libraries. Full list available at `bankai/src/main/webapp/bankai/js/libs`.

It will also include require.js plugins `text` and `i18n`.

##Bankai Project Archetype

This is a maven archetype that scaffold a bankai project structure

    mvn archetype:generate -DarchetypeGroupId=pt.ist -DarchetypeArtifactId=bankai-project-archetype
    
###Bankai Module Structure

In this example the bankai client side application is called `bankai-example`

    |-- pom.xml
    `-- src
        `-- main
            |-- java
            |-- resources
            |   `-- bankai-example
            |       `-- apps.json (1)
            `-- webapp
                `-- bankai-example
                    |-- index.html (2)
                    |-- js
                    |   |-- nls
                    |   |   |-- messages.js
                    |   |   `-- pt-pt
                    |   |       `-- messages.js
                    |   |-- router.js (3)
                    |   `-- views
                    |       `-- HelloWorld.js
                    |-- less
                    |   `-- style.less
                    `-- templates
                        `-- HelloWorld.html



1.  apps.json is a json file that defines the entrypoints available in your application. It will be used to make these entries available when building the `bennu-portal` menu.
```
    {
        "apps": [
                    {
                        "title": {
                            "en-GB": "pt.ist.bankai-example",
                            "pt-PT": "pt.ist.bankai-example"
                        },
                        "description": {
                            "en-GB": "pt.ist.bankai-example",
                            "pt-PT": "pt.ist.bankai-example"
                        },
                        "accessExpression": "anyone",
                        "path": "bankai-example/",
                        "functionalities": []
                    }
                ]
    }
```

2. index.html - Here it is where the application will initialize. All your client side DOM elements will be included inside `<div id="bankai-container"></div>`. ```<script data-main="../bankai/js/config"...``` will initialize Bankai application and therefore your application will start at this point.
3. 


    

##Bankai Project

This project is used as parent pom for bankai projects.

###Description


When using this project as parent pom it will enable javascript minification for your application.
Please check bankai project for more information

###Usage


####Install this project

    mvn clean install 

####Use as parent pom (in a client side module)

    <parent>
        <groupId>pt.ist</groupId>
        <artifactId>bankai-project</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

To enabled javascript minification, add this to your pom

    <properties>
      <bankai.skip.js.optimization>false</bankai.skip.js.optimization>
	</properties>
