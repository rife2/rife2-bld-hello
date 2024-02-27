[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/java-17%2B-blue)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![bld](https://img.shields.io/badge/1.9.0-FA9052?label=bld&labelColor=2392FF)](https://rife2.com/bld)
[![GitHub CI](https://github.com/rife2/rife2-bld-hello/actions/workflows/bld.yml/badge.svg)](https://github.com/rife2/rife2-bld-hello/actions/workflows/bld.yml)

# RIFE2 bootstrap project structure

This project helps you to get started with a RIFE2 web application and [`bld`](https://rife2.com/bld).

You'll find all the pieces that are explained in the first sections of
[the documentation](https://github.com/rife2/rife2/wiki) neatly contained
in this one project.

It's ready to run, package and deploy ... and for you to have fun developing
in a very iterative, intuitive and rewarding way.

For all things RIFE2, head on to the project website:
[https://rife2.com](https://rife2.com)

For more details on the `bld` build system, head on to that section:
[https://rife2.com/bld](https://rife2.com/bld)

## Run the tests

```bash
./bld clean compile test
```

## Run the server

```bash
./bld clean compile run
```

Go to:

[http://localhost:8080/](http://localhost:8080/)

## Deploy the app

```bash
./bld clean war
```

The resulting archive will be in:
`build/dist`

If you use any of the byte-code instrumented features , like continuations,
metadata merging or lazy-loaded database entities, you'll need to launch your
servlet container with the `-javaagent:[path-to]/rife2-[version]-agent.jar`
argument. Exactly how is dependent on each servlet container.

For example, for Apache Tomcat this is typically done by customizing the
`CATALINA_OPTS` environment variable, for instance:

```shell
CATALINA_OPTS="-javaagent:[path-to]/rife2-[version]-agent.jar" ./bin/catalina.sh run
```

For Jetty, it could just be an argument of the `java` call:

```shell
java -javaagent:[path-to]/rife2-[version]-agent.jar -jar $JETTY_HOME/start.jar
```

## Make an UberJar

```bash
./bld clean uberjar
```

Then run it with:

```bash
java -jar build/dist/hello-0.1.0-uber.jar
```

If you use any of the byte-code instrumented features, you'll need to also tell
`java` to use the RIFE2 agent.

For example:

```bash
java -javaagent:[path-to]/rife2-[version]-agent.jar -jar build/dist/hello-0.1.0-uber.jar
```

## Get in touch

Thanks for using RIFE2!

If you have any questions, suggestions, ideas or just want to chat, feel free
to post on the [forums](https://forum.uwyn.com), to join
me on [Discord](https://discord.gg/DZRYPtkb6J) or to connect with me on
[Mastodon](https://uwyn.net/@gbevin).


**Read more in the [full documentation](https://github.com/rife2/rife2/wiki)
and  [RIFE2 Javadocs](https://rife2.github.io/rife2/).**
