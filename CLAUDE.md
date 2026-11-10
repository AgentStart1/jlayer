# JLayer 项目

## 项目概览

JLayer 是纯 Java MP3 解码库，可实时解码、播放和转换 MPEG 1/2/2.5 Layer 1/2/3（MP3）。

## Fork 信息

- **Fork 来源：** [umjammer/jlayer](https://github.com/umjammer/jlayer)
- **上游：** storytellerF/jlayer
- **主要远端：** AgentStart1/jlayer

## 构建系统

- **构建工具：** Gradle（Kotlin DSL）
- **Gradle 版本：** 9.1.0
- **Java 版本：** 17
- **发布：** 通过 Vanniktech Maven Publish 插件发布至 Maven Central

## Maven 坐标

```
groupId: io.github.storytellerf
artifactId: jlayer
```

## 依赖

- **生产：** 无（纯 Java 库）
- **测试：** 仅 JUnit 5（没有外部测试依赖）

## 开发说明

- CI/CD 使用 GitHub Actions 执行测试并发布至 Maven Central。
- 发布时推送 `v*` 标签，例如 `git tag v1.0.4 && git push origin v1.0.4`。
