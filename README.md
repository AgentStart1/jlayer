[![Java CI](https://github.com/AgentStart1/jlayer/actions/workflows/test.yml/badge.svg)](https://github.com/AgentStart1/jlayer/actions/workflows/test.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.storytellerf/jlayer)](https://central.sonatype.com/artifact/io.github.storytellerf/jlayer)

# JLayer

JLayer 是用于解码、播放和转换 MPEG 音频的纯 Java 库：

- MPEG 1、2 和 2.5
- Layer I、II 和 III（MP3）
- VBRI 和 Xing VBR 头
- 通过解码器 API 访问 ID3v2 帧
- 本地文件与 URL 流式播放

JLayer 使用 Java Sound API 播放音频，没有生产依赖。

## 环境要求

- Java 17 或更新版本
- 播放功能需要 Java Sound 支持

## 安装

JLayer 已发布到 [Maven Central](https://central.sonatype.com/artifact/io.github.storytellerf/jlayer)。

### Maven

```xml
<dependency>
    <groupId>io.github.storytellerf</groupId>
    <artifactId>jlayer</artifactId>
    <version>${jlayer.version}</version>
</dependency>
```

### Gradle

```kotlin
implementation("io.github.storytellerf:jlayer:${jlayerVersion}")
```

## 使用

### 从 Java 播放 MP3

```java
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public final class PlayMp3 {
    private PlayMp3() {
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: PlayMp3 <file.mp3>");
        }

        try (InputStream input = Files.newInputStream(Path.of(args[0]))) {
            Player player = new Player(input);
            player.play();
        } catch (JavaLayerException exception) {
            throw new RuntimeException("Unable to play MP3", exception);
        }
    }
}
```

底层播放器 API 也接受任意 `InputStream`，因此可使用网络流或应用提供的其他数据源。

### 将 MP3 转换为 WAV

命令行转换器由 `javazoom.jl.converter.jlc` 提供：

```bash
java -cp jlayer.jar javazoom.jl.converter.jlc -p output.wav input.mp3
```

添加 `-v` 或 `-v3` 可查看转换进度详情。

Java 中也能执行相同操作：

```java
import javazoom.jl.converter.Converter;

new Converter().convert("input.mp3", "output.wav");
```

### 从命令行播放

简单播放器支持本地文件和 URL：

```bash
java -cp jlayer.jar javazoom.jl.player.jlp input.mp3
java -cp jlayer.jar javazoom.jl.player.jlp -url https://example.com/audio.mp3
```

需要在线程中播放时，使用 `javazoom.jl.player.advanced.jlap`：

```bash
java -cp jlayer.jar javazoom.jl.player.advanced.jlap input.mp3
```

## 从源码构建

```bash
./gradlew build
```

项目使用 Gradle 构建，目标版本为 Java 17。生成的库 JAR 位于 `build/libs/`。

## 许可证

JLayer 按 [GNU Lesser General Public License v3.0](LICENSE.txt) 分发。

## 历史

JLayer 源于 JavaZOOM 的 JavaLayer 项目（1999–2008）。历史变更记录见 [CHANGES.txt](CHANGES.txt)，背景信息见[原项目主页](https://web.archive.org/web/20210108055829/http://www.javazoom.net/javalayer/javalayer.html)。
