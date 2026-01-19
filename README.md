# TagCloud

[![Build Status](https://app.travis-ci.com/richardeigenmann/JPO.svg?branch=master)](https://app.travis-ci.com/richardeigenmann/JPO)

![Screenshot of TagCloud demo code](http://richardeigenmann.github.io/TagCloud/images/Screenshot1.png)

TagCloud is an Open Source library that creates a Java SWING Component that renders a 
list of words. Each word is given a font color and font size based on two weights.

See also the [Presentation](http://richardeigenmann.github.io/TagCloud/presentation.html) and the [Project Page](http://richardeigenmann.github.io/TagCloud)

## Try it out

Install Gradle 9.3 on your Computer
Install Java 25 on your Computer

```bash
git clone https://github.com/richardeigenmann/TagCloud.git
cd TagCloud
gradlew run  # on Windows: gradlew.bat run
```

## How to use it

See the Javadoc for the classes and methods: [Javadoc](http://richardeigenmann.github.io/TagCloud/javadoc)

To create the component, create a List of WeightedWord objects. Each WeightedWord has a String and two weights, one for the size and the other for the color. The weights can be the same if you want or one can be constant. Then create a TagCloud object and associate the List<WeighetdWord> with the TagCloud.
Then add the TagCloud to your Swing Container:

```java
List<WeightedWordInterface> weightedWordList = new ArrayList<>();
weightedWordList.add( new WeightedWord( "Word1", 10, 50 ) );
weightedWordList.add( new WeightedWord( "Word2", 60, 20 ) );
TagCloud tagCloud = new TagCloud();
tagCloud.setWordsList( weightedWordList );
```

To become more interactive you can add a TagClickListener to the TagCloud and will receive a WeighedWord in the tagClicked callback if the user clicks on a word:

```java
tagCloud.addTagClickListener( new TagClickListener() {

  @Override
  public void tagClicked( WeightedWordInterface weightedWord ) {
    doTagClicked( weightedWord );
  }
} );

public void doTagClicked( final WeightedWordInterface weightedWord ) {
  System.out.println( String.format( "The word: %s was clicked", weightedWord.getWord() ) );
}
```

See the included [sample program](https://github.com/richardeigenmann/TagCloud/blob/master/tagcloud.samplegui/src/main/java/my/samplegui/SampleTagCloud.java) for a worked example.

## Customisation

The library is designed so that you can customise the fonts and the colors. Here is an example of famous people and their BMI index:

![Screenshot of customised TagCloud showing famous people and their BMI](http://richardeigenmann.github.io/TagCloud/images/Screenshot2.png)

The data on the people came from some casual research on the Internet. See the source code [People.java](https://github.com/richardeigenmann/TagCloud/blob/master/tagcloud.samplegui/src/main/java/my/samplegui/FamousPeople.java)

To get the colors to change according to the BMI of the person you have to tell TagCloud to use a special [ColorProvider](https://github.com/richardeigenmann/TagCloud/blob/master/tagcloud.library/src/main/java/org/tagcloud/colorproviders/ColorProvider.java). Some sample ColorProviders are bundled in the code. See the [Javadoc](https://richardeigenmann.github.io/TagCloud/javadoc/org/TagCloud/ColorProviders/package-summary.html).

```Java
tagCloud.setColorProvider( new BMIColorProvider() );
```

If you dig into the code you will notice that some ColorProviders extend the [ColorInterpolator](https://github.com/richardeigenmann/TagCloud/blob/master/tagcloud.library/src/main/java/org/tagcloud/colorproviders/ColorInterpolator.java) which allows the extending class to supply an array of colors between which the ColorInterpolator will interpolate an appropriate hue:

```Java
public class SampleGradientColors extends ColorInterpolator {
    public final static Color[] SAMPLE_GRADIENT_COLORS = { 
        new Color( 0x099716 ), new Color( 0x18c928 ),
        new Color( 0x36e410 ), new Color( 0x64e410 ), 
        new Color( 0xa1e70c ), new Color( 0xc3d000 ), 
        new Color( 0xe8e410 ), new Color( 0xdcaf1e ),
        new Color( 0xe87514 ), new Color( 0xed723b ) };

    @Override
    public Color[] getColorPoints() {
        return SAMPLE_GRADIENT_COLORS;
    }
}
```

Similarly, to customise the fonts used to render the tags, supply a [FontProvider](https://github.com/richardeigenmann/TagCloud/blob/master/tagcloud.library/src/main/java/org/tagcloud/fontproviders/FontProvider.java) to the TagCloud:

```Java
tagCloud.setFontProvider( new SansSerifFontProvider() );
```

Some FontProviders are supplied with the library. See the [Javadoc](http://richardeigenmann.github.io/TagCloud/javadoc/org/TagCloud/FontProviders/package-summary.html)

## License

TagCloud is an Open Source project by Richard Eigenmann.
It is licensed under the <a href="https://github.com/richardeigenmann/TagCloud/blob/master/license.txt">LGPL v3</a> license.

## Feedback

Please feel free to contact the Author with comments, suggestions, improvements, pull requests or encouragement:
Richard Eigenmann

<mailto:richard.eigenmann@gmail.com>

## ToDo: Jlink Section

The project was one of my first to use Modularity. It probably needs a bit of cleaning up here.

```Bash
/usr/java/zulu17.32.13-ca-jdk17.0.2-linux_x64/bin/jlink \
--module-path tagcloud.samplegui/build/libs:tagcloud.library/build/libs \
--add-modules my.samplegui \
--output build/jlink/

build/jlink/bin/java --list-modules

build/jlink/bin/java --module my.samplegui

/usr/java/zulu17.32.13-ca-jdk17.0.2-linux_x64/bin/jlink \
--module-path tagcloud.samplegui/build/libs:tagcloud.library/build/libs \
--add-modules my.samplegui \
--output build/jlink/ \
--launcher run-samplegui=my.samplegui

/usr/java/zulu17.32.13-ca-jdk17.0.2-linux_x64/bin/jlink \
--module-path tagcloud.samplegui/build/libs:tagcloud.library/build/libs \
--add-modules my.samplegui \
--output build/jlink/ \
--launcher run-samplegui=my.samplegui

/usr/java/zulu17.32.13-ca-jdk17.0.2-linux_x64/bin/jlink --list-plugins

rm -rf build/jlink

/usr/java/zulu17.32.13-ca-jdk17.0.2-linux_x64/bin/jlink \
--module-path tagcloud.samplegui/build/libs:tagcloud.library/build/libs \
--add-modules my.samplegui \
--output build/jlink/ \
--launcher run-samplegui=my.samplegui \
--compress 2
```

```ps
"c:\Program Files (x86)\jdk-17.0.1\bin\jpackage" ^
--type exe ^
--input . ^
--name JPO ^
--description "Java Picture Organizer" ^
--vendor "Richard Eigenmann" ^
--app-version 0.17 ^
--main-jar Jpo-all.jar ^
--icon favicon.ico ^
--java-options '--enable-preview' ^
--win-shortcut ^
--win-menu ^
--verbose ^
--dest c:\Users\richa\Desktop
```

```bash
/usr/java/zulu17.32.13-ca-jdk17.0.2-linux_x64/bin/jpackage \
--module-path tagcloud.samplegui/build/libs:tagcloud.library/build/libs \
--module my.samplegui \
--type rpm \
--name TagCloud \
--description "Tag Cloud" \
--vendor "Richard Eigenmann" \
--app-version 0.0.6 \
--verbose \
--dest build/rpm/ \
--linux-menu-group "Richi's Apps" \
--linux-shortcut \
--install-dir /usr
```

## ToDo

- Package this as a proper library
- Change the first example to be population vs per capita income
- Improve documentation (forget applets, build instructions)
- Describe more clearly what numbers are being weighted in the GUI
- Improve color scheme (yellow on gray doesn't work well)
- Fix screenshots