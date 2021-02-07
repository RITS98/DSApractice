import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Optional;
public class StreamOp 
{
    public static void main(String args[])
    {
        List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        Stream<String> stream = stringList.stream();

        long count = stream
            .map((value) -> { return value.toLowerCase(); })
            .count();

        System.out.println("count = " + count);

        stream = stringList.stream();
        stream = stream
                    .map((value) -> { return value.toLowerCase(); })
                    .map((value) -> { return value.toUpperCase(); })
                    .map((value) -> { return value.substring(0,3); });
                    

        //filter
        /**The Java Stream filter() can be used to filter out elements from a Java Stream. 
         * The filter method takes a Predicate which is called for each element in the stream. 
         * If the element is to be included in the resulting Stream, 
         * the Predicate should return true. If the element should not be included, 
         * the Predicate should return false.
         * Here is an example of calling the Java Stream filter() method: */
        
        stream = stringList.stream();
        Stream<String> longStringsStream = stream.filter((value) -> {
                        return value.length() >= 3;
                    });

        //map
        /**The Java Stream map() method converts (maps) an element to another object. 
         * For instance, if you had a list of strings it could convert each string to lowercase, 
         * uppercase, or to a substring of the original string, or something completely else. 
         * Here is a Java Stream map() example: */
        List<String> list = new ArrayList<String>();
        stream = list.stream();
        Stream<String> streamMapped = stream.map((value) -> value.toUpperCase());
        
        //flatMap
        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        })
        .forEach((value) -> System.out.println(value));


        //distinct
        stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        stream = stringList.stream();

        List<String> distinctStrings = stream
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctStrings);

        //limit
        /**The Java Stream limit() method can limit the number of elements 
         * in a stream to a number given to the limit() method as parameter. 
         * The limit() method returns a new Stream which will at most contain 
         * the given number of elements. Here is a Java Stream limit() example: */
        stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        stream = stringList.stream();
        stream.limit(2)
            .forEach( element -> { System.out.println(element); });   

        //peek
        /**The Java Stream peek() method is a non-terminal operation that takes a 
         * Consumer (java.util.function.Consumer) as parameter. 
         * The Consumer will get called for each element in the stream. 
         * The peek() method returns a new Stream which contains all the elements 
         * in the original stream.
         * 
         * The purpose of the peek() method is, as the method says, 
         * to peek at the elements in the stream, not to transform them. 
         * Keep in mind that the peek method does not start the internal 
         * iteration of the elements in the stream. 
         * You need to call a terminal operation for that. 
         * Here is a Java Stream peek() example: */
        stringList = new ArrayList<String>();

        stringList.add("abc");
        stringList.add("def");
        
        stream = stringList.stream();
        
        Stream<String> streamPeeked = stream.peek((value) -> {
            System.out.println("value");
        });
        

        stream = stringList.stream();
        count = stream.map((value) -> { return value.toLowerCase(); })
        .map((value) -> { return value.toUpperCase(); })
        .map((value) -> { return value.substring(0,3); })
        .count();

        System.out.println(count);

        //anyMatch
        /*
        The Java Stream anyMatch() method is a terminal operation that 
        takes a single Predicate as parameter, starts the internal iteration
        of the Stream, and applies the Predicate parameter to each element. 
        If the Predicate returns true for any of the elements, the anyMatch() 
        method returns true. If no elements match the Predicate, anyMatch() 
        will return false. Here is a Java Stream anyMatch() example: 
        */
        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stream = stringList.stream();

        boolean anyMatch = stream.anyMatch((value) -> { return value.startsWith("One"); });
        System.out.println(anyMatch);


        //allMatch
        /**The Java Stream allMatch() method is a terminal 
         * operation that takes a single Predicate as parameter, 
         * starts the internal iteration of elements in the Stream, 
         * and applies the Predicate parameter to each element. 
         * If the Predicate returns true for all elements in the Stream, 
         * the allMatch() will return true. If not all elements match the Predicate, 
         * the allMatch() method returns false. Here is a Java Stream allMatch() example: */
        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stream = stringList.stream();

        boolean allMatch = stream.allMatch((value) -> { return value.startsWith("One"); });
        System.out.println(allMatch);


        //noneMatch
        /**The Java Stream noneMatch() method is a terminal 
         * operation that will iterate the elements in the stream and 
         * return true or false, depending on whether no elements in the stream matches 
         * the Predicate passed to noneMatch() as parameter. 
         * The noneMatch() method will return true if no elements 
         * are matched by the Predicate, and false if one or more elements are matched. 
         * Here is a Java Stream noneMatch() example: */

        
        stringList = new ArrayList<String>();

        stringList.add("abc");
        stringList.add("def");

        stream = stringList.stream();

        boolean noneMatch = stream.noneMatch((element) -> {
            return "xyz".equals(element);
        });

        System.out.println("noneMatch = " + noneMatch);

        //collect
        /**The Java Stream collect() method is a terminal operation that 
         * starts the internal iteration of elements, and collects the elements 
         * in the stream in a collection or object of some kind. 
         * Here is a simple Java Stream collect() method example: */
        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stream = stringList.stream();

        count = stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        })
        .count();

        System.out.println("count = " + count);


        //findAny
        /**The Java Stream findAny() method can find a single element from the Stream. 
         * The element found can be from anywhere in the Stream. 
         * There is no guarantee about from where in the stream the element is taken. 
         * Here is a Java Stream findAny() example: */
        stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        stream = stringList.stream();

        System.out.println(stream.findAny().get());

        /**findFirst()
        The Java Stream findFirst() method finds the first element in 
        the Stream, if any elements are present in the Stream. 
        The findFirst() method returns an Optional from which you can obtain the element, 
        if present. 
        Here is a Java Stream findFirst() example: */
        stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        stream = stringList.stream();
        System.out.println(stream.findFirst().get());

        //forEach()
        /*The Java Stream forEach() method is a terminal operation 
        which starts the internal iteration of the elements in the Stream, 
        and applies a Consumer (java.util.function.Consumer) to each element 
        in the Stream. The forEach() method returns void. 
        Here is a Java Stream forEach() example:*/

        stringList = new ArrayList<String>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        stream = stringList.stream();

        stream.forEach( element -> { System.out.println(element); });
        
        //min()
        
        /*The Java Stream min() method is a terminal operation that 
        returns the smallest element in the Stream. 
        Which element is the smallest is determined by the Comparator 
        implementation you pass to the min() method. 
        I have explained how the Comparator interface works in my 
        tutorial about sorting Java collections. Here is a Java Stream min() example:
        */
        stringList = new ArrayList<String>();

        stringList.add("abc");
        stringList.add("def");

        stream = stringList.stream();

        Optional<String> min = stream.min((val1, val2) -> {
            return val1.compareTo(val2);
        });

        String minString = min.get();

        System.out.println(minString);
        
        //Notice how the min() method returns an Optional which may or may not contain a result. If the Stream is empty, the Optional get() method will throw a NoSuchElementException.

        //max()
        /*The Java Stream max() method is a terminal operation that returns the 
        largest element in the Stream. Which element is the largest is 
        determined by the Comparator implementation you pass to the max() method. 
        I have explained how the Comparator interface works in my tutorial about 
        sorting Java collections. Here is a Java Stream max() example:*/

        stringList = new ArrayList<String>();

        stringList.add("abc");
        stringList.add("def");

        stream = stringList.stream();

        Optional<String> max = stream.max((val1, val2) -> {
            return val1.compareTo(val2);
        });

        String maxString = max.get();

        System.out.println(maxString);
        //Notice how the max() method returns an Optional which may or may not contain a result. If the Stream is empty, the Optional get() method will throw a NoSuchElementException.

        //reduce()
        /*The Java Stream reduce() method is a terminal operation that 
        can reduce all elements in the stream to a single element. 
        Here is a Java Stream reduce() example:*/

        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stream = stringList.stream();

        Optional<String> reduced = stream.reduce((value, combinedValue) -> {
            return combinedValue + " + " + value;
        });

        System.out.println(reduced.get());
        //Notice the Optional returned by the reduce() method. This Optional contains the value (if any) returned by the lambda expression passed to the reduce() method. You obtain the value by calling the Optional get() method.

        //toArray()
        //The Java Stream toArray() method is a terminal operation that 
        //starts the internal iteration of the elements in the stream, 
        //and returns an array of Object containing all the elements. 
        //Here is a Java Stream toArray() example:

        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stream = stringList.stream();

        Object[] objects = stream.toArray();
        
        //Concatenate Streams
        //The Java Stream interface contains a static method called concat() 
        //which can concatenate two streams into one. 
        //The result is a new Stream which contains all of the elements from 
        //the first stream, followed by all of the elements from the second stream. 
        //Here is an example of using the Java Stream concat() method:

        stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream1 = stringList.stream();

        List<String> stringList2 = new ArrayList<>();
        stringList2.add("Lord of the Rings");
        stringList2.add("Planet of the Rats");
        stringList2.add("Phantom Menace");

        Stream<String> stream2 = stringList2.stream();

        Stream<String> concatStream = Stream.concat(stream1, stream2);

        List<String> stringsAsUppercaseList = concatStream
                .collect(Collectors.toList());

        System.out.println(stringsAsUppercaseList);
        
        
        //Create Stream From Array
        //The Java Stream interface contains a static method called of() 
        //which can be used to create a Stream from one or more objects. 
        //Here is an example of using the Java Stream of() metho:

        Stream<String> streamOf = Stream.of("one", "two", "three");

    }
    
}
