package hello;

import rife.bld.WebProject;

import java.util.List;

import static rife.bld.dependencies.Repository.*;
import static rife.bld.dependencies.Scope.*;
import static rife.bld.operations.TemplateType.*;

public class AppBuild extends WebProject {
    public AppBuild() {
        pkg = "hello";
        name = "App";
        mainClass = "hello.AppSite";
        uberJarMainClass = "hello.AppSiteUber";
        version = version(0,1,0);
        archiveBaseName = "hello";

        downloadSources = true;
        autoDownloadPurge = true;

        repositories = List.of(MAVEN_CENTRAL, RIFE2_RELEASES);
        scope(compile)
            .include(dependency("com.uwyn.rife2", "rife2", version(1,7,2)));
        scope(test)
            .include(dependency("org.jsoup", "jsoup", version(1,16,1)))
            .include(dependency("org.junit.jupiter", "junit-jupiter", version(5,9,3)))
            .include(dependency("org.junit.platform", "junit-platform-console-standalone", version(1,9,3)));
        scope(standalone)
            .include(dependency("org.eclipse.jetty", "jetty-server", version(11,0,15)))
            .include(dependency("org.eclipse.jetty", "jetty-servlet", version(11,0,15)))
            .include(dependency("org.slf4j", "slf4j-simple", version(2,0,7)));

        precompileOperation()
            .templateTypes(HTML);
    }

    public static void main(String[] args) {
        new AppBuild().start(args);
    }
}