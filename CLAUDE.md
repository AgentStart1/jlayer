# JLayer Project

## Project Overview

JLayer is a pure Java MP3 decoder library that decodes/plays/converts MPEG 1/2/2.5 Layer 1/2/3 (MP3) in real time.

## Fork Information

- **Fork origin:** [umjammer/jlayer](https://github.com/umjammer/jlayer)
- **Upstream:** storytellerF/jlayer
- **Primary remote:** AgentStart1/jlayer

## Build System

- **Build tool:** Gradle (Kotlin DSL)
- **Gradle version:** 9.1.0
- **Java version:** 17
- **Publishing:** Maven Central via Vanniktech Maven Publish plugin

## Maven Coordinates

```
groupId: io.github.storytellerf
artifactId: jlayer
```

## Dependencies

- **Production:** None (pure Java library)
- **Test:** JUnit 5 only (no external test dependencies)

## Development Notes

- CI/CD uses GitHub Actions for testing and Maven Central publishing
- To release: push a `v*` tag (e.g., `git tag v1.0.4 && git push origin v1.0.4`)
