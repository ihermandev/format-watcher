# FormatWatcher
![version](https://img.shields.io/badge/format--watcher-v1.0.1-blue)

The FormatWatcher library provides a simple and easy-to-use way to apply predefined formatting to user 
input for Android EditText. The formatter is separator sensitive, meaning if a separator is entered 
manually, the format will not be applied again.
## Installation
To install the library use Gradle:

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.ihermandev:format-watcher:1.0.1'
}
```
## Usage
Simply create a new instance of the `FormatWatcher` and set it as the `TextWatcher` interface for 
the `EditText`.
```kotlin
val formatter = FormatWatcher("###-##-####", '#')
editText.addTextChangedListener(formatter)
```
The first argument passed to the `FormatWatcher` constructor is the format string to be applied to the 
text, the second argument is the character to be used as a placeholder in the format string.

In order to obtain the formatted or raw input you can call `currentInput` and `rawInput` accordingly
via `FormatWatcher` instance.
```kotlin
formatter.currentInput
formatter.rawInput
```
## Customization
You can customize the behavior of the FormatWatcher class by changing the format string, and the 
placeholder character to match your specific requirements.
## Contribute
If you find any bugs or have any suggestions for improvements, please open an issue or create a pull
request on the [GitHub repository](https://github.com/ihermandev/format-watcher)
### Demo

https://user-images.githubusercontent.com/25265967/215283143-7a502053-6922-4120-84e9-4390b2157c03.mp4

## License
This library is released under the Apache 2.0 license. See the [LICENSE](https://github.com/ihermandev/FormatWatcher/blob/master/LICENSE.md) file for more information.
