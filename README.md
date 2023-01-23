# FormatWatcher
The FormatWatcher library provides a simple and easy-to-use way to apply predefined formatting to user 
input for Android EditText. The formatter is separator sensitive which means that if a separator is 
entered manually, format will not be applied again.
## Installation
To install the library use Gradle:

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.ihermandev:format-watcher:1.0.0'
}
```
## Usage
Simply create a new instance of the FormatWatcher and set it as the TextWatcher for the EditText.
```kotlin
val formatter = FormatWatcher("###-##-####", '#')
editText.addTextChangedListener(formatter)
```
The first argument passed to the FormatWatcher constructor is the format string to be applied to the 
text, the second argument is the character to be used as a placeholder in the format string.
## Customization
You can customize the behavior of the FormatWatcher class by changing the format string, and the 
placeholder character to match your specific requirements.
## Contribute
If you find any bugs or have any suggestions for improvements, please open an issue or create a pull
request on the [GitHub repository](https://github.com/ihermandev)

### Demo

https://user-images.githubusercontent.com/25265967/214165330-c5ab8f27-1c84-43b4-9680-3cc81393da14.mp4

## License
This library is released under the Apache 2.0 license. See the [LICENSE](https://github.com/ihermandev/FormatWatcher/blob/master/LICENSE.md) file for more information.
