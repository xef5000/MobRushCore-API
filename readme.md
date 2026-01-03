# MobRushCore API

MobRushCore API provides a set of interfaces and classes to interact with the MobRushCore plugin. This allows plugin developers to extend, control, and query game features such as arenas, mobs, and plots in a clean and type-safe way.

## Installation

The API is available via JitPack:

Add the repository to your `build.gradle`:

- Replace `VERSION` with the Jitpack version

     [![](https://jitpack.io/v/xef5000/MobRushCore-API.svg)](https://jitpack.io/#xef5000/MobRushCore-API)

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.xef5000:MobRushCore-API:VERSION'
}
```

Add to plugin.yml:
```yaml
depend: [MobRushCore]
```

## Usage

To interact with MobRushCore, use the `MobRushCoreProvider` to get an instance of the API:

```java
MobRushCoreAPI api = MobRushCoreProvider.get();
```
