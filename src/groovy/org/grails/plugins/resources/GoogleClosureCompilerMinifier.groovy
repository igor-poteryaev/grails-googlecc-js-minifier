package org.grails.plugins.resources

import com.google.javascript.jscomp.Compiler
import com.google.javascript.jscomp.CompilerOptions
import com.google.javascript.jscomp.JSSourceFile
import com.google.javascript.jscomp.Result


class GoogleClosureCompilerMinifier implements Minifier {

    void minify (File sourceFile, File targetFile) {

        Compiler compiler = new Compiler();
        Result result = compiler.compile(
                JSSourceFile.fromCode("externs.js", ""),
                JSSourceFile.fromFile(sourceFile), new CompilerOptions());
        if (result.success) {
            targetFile.text = compiler.toSource();
        } else {
            throw new Exception("${result.errors}")
        }
    }
}
