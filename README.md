[![Java CI](https://github.com/AgentStart1/jlayer/actions/workflows/test.yml/badge.svg)](https://github.com/AgentStart1/jlayer/actions/workflows/test.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.storytellerf/jlayer)](https://central.sonatype.com/artifact/io.github.storytellerf/jlayer)

# JLayer

JLayer is a pure Java library for decoding, playing, and converting MPEG audio:

- MPEG 1, 2, and 2.5
- Layers I, II, and III (MP3)
- VBRI and Xing VBR headers
- ID3v2 frame access through the decoder API
- Local-file and URL streaming playback

JLayer uses the Java Sound API for playback and has no production dependencies.

## Requirements

- Java 17 or newer
- Java Sound support for playback

## Installation

JLayer is published to [Maven Central](https://central.sonatype.com/artifact/io.github.storytellerf/jlayer).

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

## Usage

### Play an MP3 from Java

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

The lower-level player API also accepts any `InputStream`, so it can be used with
network streams and other application-provided sources.

### Convert MP3 to WAV

The command-line converter is provided by `javazoom.jl.converter.jlc`:

```bash
java -cp jlayer.jar javazoom.jl.converter.jlc -p output.wav input.mp3
```

Add `-v` or `-v3` for conversion progress details.

The same operation is available from Java:

```java
import javazoom.jl.converter.Converter;

new Converter().convert("input.mp3", "output.wav");
```

### Play from the command line

The simple player supports local files and URLs:

```bash
java -cp jlayer.jar javazoom.jl.player.jlp input.mp3
java -cp jlayer.jar javazoom.jl.player.jlp -url https://example.com/audio.mp3
```

For threaded playback, use `javazoom.jl.player.advanced.jlap`:

```bash
java -cp jlayer.jar javazoom.jl.player.advanced.jlap input.mp3
```

## Build from source

```bash
./gradlew build
```

The project is built with Gradle and targets Java 17. The generated library JAR
is placed in `build/libs/`.

## License

JLayer is distributed under the [GNU Lesser General Public License v3.0](LICENSE.txt).

## History

JLayer originated as the JavaZOOM JavaLayer project (1999–2008). See
[CHANGES.txt](CHANGES.txt) for the historical changelog and the
[original project homepage](https://web.archive.org/web/20210108055829/http://www.javazoom.net/javalayer/javalayer.html)
for background information.
