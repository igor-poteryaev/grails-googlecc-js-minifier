class GoogleccJsMinifierGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2 > *"
    // the other plugins this plugin depends on
    def dependsOn = [resources:"1.0-RC1b > *"]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/conf/hibernate",
            "grails-app/conf/spring",
            "grails-app/controllers/**",
            "grails-app/domain/**",
            "grails-app/services/**",
            "grails-app/taglib/**",
            "grails-app/views/**",
            "grails-app/i18n/**",
            "web-app/**"
    ]

    def author = "Igor E. Poteryaev"
    def authorEmail = "igor.poteryaev@gmail.com"
    def title = "Google Closure compiler Javascript resources minifier"
    def description = '''Grails plugin for javascript resources minification using Google Closure compiler.'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/googlecc-js-minifier"
}
