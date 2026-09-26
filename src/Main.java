import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Farid", "Fariz");

        words.stream()
                .filter(word -> word.equals("Farid"))
                .findFirst()
                .ifPresent(System.out::println);

        words.forEach(System.out::println);
        System.out.println(words.size());
    }
}