package org.grails.plugins.resources

import org.apache.commons.io.FilenameUtils;


abstract class AbstractMinifyResourceMapper {

    static defaultIncludes = [
        '/**/*.css',
        '/**/*.js'
    ]

    def priority = 200 // ???

    def map (resource, config) {
        if (isMinifiable(resource)) {
            resource.processedFile = minify(minifiers[extension], file)
        }
    }


    private boolean isMinifiable (resource) {
        if (resource.attributes.containsKey("minify")) {
            return resource.attributes["minify"]
        }
        def file = resource.processedFile
        def extension = FilenameUtils.getExtension(file.name)
        return minifiers.containsKey(extension) && !file.name.endsWith(".min." + extension)
    }


    private File minify (minifier, sourceFile) {
        def targetFile = createTargetFile(sourceFile)
        if (log.debugEnabled) {
            log.debug "minifying $sourceFile to $targetFile"
        }
        try {
            minifier.minify sourceFile, targetFile
        } catch (e) {
            log.error "problem minifying ${sourceFile.name}: $e.message"
        }
        return targetFile
    }


    private File createTargetFile (File sourceFile) {
        String extension = FilenameUtils.getExtension(sourceFile.name)
        return new File(sourceFile.parentFile, FilenameUtils.removeExtension(sourceFile.name) + '.min.' + extension)
    }
}
