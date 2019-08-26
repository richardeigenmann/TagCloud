# TagCloud

Java Swing Component that shows words in different colors and font sizes based on weights.

[Presentation](http://richardeigenmann.github.io/TagCloud/presentation.html)

[Project Page](http://richardeigenmann.github.io/TagCloud)

## Quickstart

Run the Sample on [Java Web Start](http://richardeigenmann.github.io/TagCloud/TagCloud.jnlp)

[Download the jar file](http://richardeigenmann.github.io/TagCloud/TagCloud.jar) and run the sample program:

```Bash
java  -jar ./TagCloud.jar
```

![Screenshot of TagCloud demo code](http://richardeigenmann.github.io/TagCloud/images/Screenshot1.png)


## Usage

[Javadoc](http://richardeigenmann.github.io/TagCloud/javadoc)

To create the component, create a List of WeightedWord objects. Then create a TagCloud and associate the List<WeighetdWord> with the TagCloud.
Then add the TagCloud to your Swing Container:

```Java
List<WeightedWordInterface> weightedWordList = new ArrayList<>();
weightedWordList.add( new WeightedWord( "Word1", 10, 50 ) );
weightedWordList.add( new WeightedWord( "Word2", 60, 20 ) );
TagCloud tagCloud = new TagCloud();
tagCloud.setWordsList( weightedWordList );
```

To become more interactive you can add a TagClickListener to the TagCloud and will receive a WeighedWord if the user clicks on a word:

```Java
tagCloud.addTagClickListener( new TagClickListener() {

  @Override
  public void tagClicked( WeightedWordInterface weightedWord ) {
    doTagClicked( weightedWord );
  }
} );

...

public void doTagClicked( WeightedWordInterface weightedWord ) {
  System.out.println( String.format( "The word: %s was clicked", weightedWord.getWord() ) );
}
```


See the included [sample program](https://github.com/richardeigenmann/TagCloud/blob/master/src/main/java/org/TagCloud/Sample/SampleTagCloud.java) for a worked example.


## Customisation

The library is designed so that you can customise the fonts and the colors. Here is an example of famous people and their BMI index:

![Screenshot of customised TagCloud showing famous people and their BMI](http://richardeigenmann.github.io/TagCloud/images/Screenshot2.png)

The data on the people came from some casual research on the Internet. See the source code [People.java](https://github.com/richardeigenmann/TagCloud/blob/master/src/main/java/org/TagCloud/Sample/People.java)

To get the colors to change according to the BMI of the person you have to tell TagCloud to use a special [ColorProvider](http://richardeigenmann.github.io/TagCloud/javadoc/org/TagCloud/ColorProvider.html). Some sample ColorProviders are bundled in the code. See the [Javadoc](http://richardeigenmann.github.io/TagCloud/javadoc/org/TagCloud/ColorProviders/package-summary.html).

```Java
tagCloud.setColorProvider( new BMIColorProvider() );
```
If you dig into the code you will notice that some ColorProviders extend the [ColorInterpolator](http://richardeigenmann.github.io/TagCloud/javadoc/org/TagCloud/ColorInterpolator.html) which allows the extending class to supply an array of colors between which the ColorInterpolator will interpolate an appropriate hue:

```Java
public class SampleGradientColors extends ColorInterpolator {
    public final static Color[] SAMPLE_GRADIENT_COLORS = { new Color( 0x099716 ), new Color( 0x18c928 ),
        new Color( 0x36e410 ), new Color( 0x64e410 ), new Color( 0xa1e70c ),
        new Color( 0xc3d000 ), new Color( 0xe8e410 ), new Color( 0xdcaf1e ),
        new Color( 0xe87514 ), new Color( 0xed723b ) };

    @Override
    public Color[] getColorPoints() {
        return SAMPLE_GRADIENT_COLORS;
    }
}
```

Similarly, to customise the fonts used to render the tags, supply a [FontProvider](http://richardeigenmann.github.io/TagCloud/javadoc/org/TagCloud/FontProvider.html) to the TagCloud:

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
