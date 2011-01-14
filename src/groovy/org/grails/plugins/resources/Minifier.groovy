package org.grails.plugins.resources

interface Minifier {

    void minify (File sourceFile, File targetFile)
}
