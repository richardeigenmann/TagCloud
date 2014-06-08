TagCloud
========

Java Swing Component that shows words in different colors and font sizes based on weights.

To create the component, create a List of WeightedWord objects, create a TagCloud and associate the List<WeighetdWord> with the TagCloud and add the TagCloud to your Swing tree:

```Java
List<WeightedWord> weightedWordList = new ArrayList<>();
weightedWordList.add( new WeightedWord( "Word1", 10, 50 ) );
weightedWordList.add( new WeightedWord( "Word2", 60, 20 ) );
TagCloud tagCloud = new TagCloud();
tagCloud.setWordsList( weightedWordList );
```

See the Project [website](http://richardeigenmann.github.io/TagCloud) for full information 

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-47341387-2', 'richardeigenmann.github.io');
  ga('send', 'pageview');

</script>
