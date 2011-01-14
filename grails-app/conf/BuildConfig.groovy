grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.dependency.resolution = {
    inherits("global") {
    }
    log "warn"
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenCentral()
    }

    dependencies {
        compile ('com.google.javascript:closure-compiler:r606') { exclude "ant" }
    }

    plugins { runtime 'org.grails.plugins:resources:latest.integration' }
}
