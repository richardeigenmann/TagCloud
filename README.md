TagCloud
========

Java Swing Component that shows words in different colors and font sizes based on weights.

Quickstart
----------

[Download the jar file](http://richardeigenmann.github.io/TagCloud/TagCloud.jar) and run the sample program:

```Bash
java  -jar ./build/libs/TagCloud.jar
```

![Screenshot of TagCloud demo code](http://richardeigenmann.github.io/TagCloud/Screenshot1.png)


Usage
-----

To create the component, create a List of WeightedWord objects, create a TagCloud and associate the List<WeighetdWord> with the TagCloud and add the TagCloud to your Swing tree:

```Java
List<WeightedWord> weightedWordList = new ArrayList<>();
weightedWordList.add( new WeightedWord( "Word1", 10, 50 ) );
weightedWordList.add( new WeightedWord( "Word2", 60, 20 ) );
TagCloud tagCloud = new TagCloud();
tagCloud.setWordsList( weightedWordList );
```

To become more interactive you can add a TagClickListener to the TagCloud and will receive a WeighedWord if the user clicks on a word:

```Java
tagCloud.addTagClickListener( new TagClickListener() {

  @Override
  public void tagClicked( WeightedWord weightedWord ) {
    doTagClicked( weightedWord );
  }
} );

...

public void doTagClicked( WeightedWord weightedWord ) {
  System.out.println( String.format( "The word: %s was clicked", weightedWord.getWord() ) );
}
```


See the included [sample program](https://github.com/richardeigenmann/TagCloud/blob/master/src/main/java/org/TagCloud/Sample/SampleTagCloud.java) for a worked example.


Feedback
--------

Please feel free to contact the Author with comments, suggestions, improvements, pull requests or encouragement:
Richard Eigenmann
<mailto:richard.eigenmann@gmail.com>


<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-47341387-2', 'richardeigenmann.github.io');
  ga('send', 'pageview');

</script>
