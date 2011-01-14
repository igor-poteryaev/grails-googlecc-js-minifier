package org.grails.plugins.resources

class MinifyResourceMapper extends AbstractMinifyResourceMapper {

    def minifiers = [
        'js': new GoogleClosureCompilerMinifier()()
    ]
}
