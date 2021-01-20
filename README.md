# bottom-kotlin

A Kotlin library for [bottom](https://github.com/kaylynn234/bottom), following the [bottom spec](https://github.com/kaylynn234/bottom-spec).

## Installing

You can install ``bottom-kotlin`` by adding it as a local dependency:
```kotlin
dependencies {
    implementation(files("libs/bottom-kotlin-1.0.0.jar"))
}
```

## Quick Example

```kotlin
import com.mayak.bottom.Bottom

fun main() {
    val string = "Hello world!"
    val bottom = Bottom.encodeString(string)
    val decoded = Bottom.decodeString(bottom)
    println(string)
    // Hello world!
    println(bottom)
    // 💖✨✨,,👉👈💖💖,👉👈💖💖🥺,,,👉👈💖💖🥺,,,👉👈💖💖✨,👉👈✨✨✨,,👉👈💖💖✨🥺,,,,👉👈💖💖✨,👉👈💖💖✨,,,,👉👈💖💖🥺,,,👉👈💖💖👉👈✨✨✨,,,👉👈
    println(decoded)
    // Hello world!
}
```

## More bottom

- [bottom](https://github.com/kaylynn234/bottom) (Rust/CLI)
- [bottom-py](https://github.com/uYert/bottom-py) (Python Rust bindings)
- [bottom-c](https://github.com/LyricLy/bottom-c) (C)
- [bottom-hs](https://github.com/LyricLy/bottom-hs) (Haskell)
- [bottom-web](https://github.com/kaylynn234/bottom-web/) (Website at https://kaylynn234.github.io/bottom-web/)
- [bottom-java](https://github.com/SebbyLaw/bottom-java/) (Java)

## Why?

Why not?
