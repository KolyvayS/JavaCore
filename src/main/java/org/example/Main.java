package org.example;

import org.example.regexUtils.RegexSearcher;
import org.example.setProblemForUsersFix.User;
import org.example.stringUtils.StringFromTextFileReader;
import org.example.stringUtils.StringToArrayConverter;
import org.example.stringUtils.UniqueWordsList;
import org.example.stringUtils.WordsRepetitionsCounter;

import java.util.*;

import static org.example.beatlesYellowSubmarinePackage.SongContainsSubstringVerifier.containsSubstringCheck;

public class Main {
    public static void main(String[] args) {
        //Task 1 Collections
        //Part 1
        System.out.println("\nTASK 1.1");
        String yellowSubmarineSong = "In the town where I was born\n" +
            "Lived a man who sailed to sea\n" +
            "And he told us of his life\n" +
            "In the land of submarines\n" +
            "So we sailed on to the sun\n" +
            "'Til we found a sea of green\n" +
            "And we lived beneath the waves\n" +
            "In our yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "And our friends are all aboard\n" +
            "Many more of them live next door\n" +
            "And the band begins to play\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "Full steam ahead, Mister Boatswain, full steam ahead\n" +
            "Full steam ahead it is, Sergeant\n" +
            "(Cut the cable, drop the cable)\n" +
            "Aye-aye, sir, aye-aye\n" +
            "Captain, captain\n" +
            "As we live a life of ease (a life of ease)\n" +
            "Every one of us (every one of us)\n" +
            "Has all we need (has all we need)\n" +
            "Sky of blue (sky of blue)\n" +
            "And sea of green (sea of green)\n" +
            "In our yellow (in our yellow)\n" +
            "Submarine (submarine, aha)\n" +
            "We all live in a yellow submarine\n" +
            "A yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "A yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine";

        StringToArrayConverter arrayOfSongWords = new StringToArrayConverter(yellowSubmarineSong);
        WordsRepetitionsCounter counter = new WordsRepetitionsCounter(arrayOfSongWords);
        System.out.println(counter.countWords());

        //Part 2
        System.out.println("\nTASK 1.2");
        List<String> listOfWords = new ArrayList<>(Arrays.asList(arrayOfSongWords.getArrayOfWords()));
        UniqueWordsList uniqueWordsList = new UniqueWordsList(listOfWords);
        System.out.println(uniqueWordsList.sortByStringLength());

        //Part 3
        System.out.println("\nTASK 1.3");
        listOfWords.removeIf(word -> word.equals("yellow") || word.equals("submarine"));
        System.out.println(listOfWords);

        //Part 4
        System.out.println("\nTASK 1.4");
        String fileName = "beatlesYellowSubmarine.txt";
        StringFromTextFileReader reader = new StringFromTextFileReader(fileName);
        String songFromTxtFile = reader.readFile();
        containsSubstringCheck(songFromTxtFile, "Show must go on");
        containsSubstringCheck(songFromTxtFile, "We all live in a yellow submarine");

        //Part 5
        System.out.println("\nTASK 1.5");
        Set<User> users = new HashSet<>();
        users.add(new User("Max", 27));
        users.add(new User("Veronika", 20));
        users.add(new User("Denis", 30));
        users.add(new User("Max", 27));

        if (users.size() == 3) {
            System.out.println("System works well!");
        } else {
            throw new RuntimeException("Users set size should be 3!");
        }

        //Task 2 Regex
        //Part 1
        System.out.println("\nTASK 2.1");
        RegexSearcher regexSearcher = new RegexSearcher();
        String stringForMatchOrderUUID = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";
        regexSearcher.setPattern("\\borderUUID\\b");
        regexSearcher.setMatcher(stringForMatchOrderUUID);
        System.out.println(regexSearcher.findMatches());

        //Part 2
        System.out.println("\nTASK 2.2");
        regexSearcher.setPattern("\\S*orderUUID\\S*");
        regexSearcher.setMatcher(stringForMatchOrderUUID);
        if(regexSearcher.findMatches())
            System.out.println(regexSearcher.returnGroup());

        //Part 3
        System.out.println("\nTASK 2.3");
        String stringForMatchEmail = "test 2667843 (test_email@griddynamics.com) test 67483 some string ";
        regexSearcher.setPattern("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        regexSearcher.setMatcher(stringForMatchEmail);
        if(regexSearcher.findMatches())
            System.out.println(regexSearcher.returnGroup());

        //Part 4
        System.out.println("\nTASK 2.4");
        String stringForMatchNumberOfOrders = "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [2]";
        regexSearcher.setPattern("orders\\b.*?(\\d+)");
        regexSearcher.setMatcher(stringForMatchNumberOfOrders);
        if(regexSearcher.findMatches())
            System.out.println(regexSearcher.returnGroup(1));

        //TASK 3
        System.out.println("\nTASK 3");
        String textForSearch = "When you first start to evaluate a cloud migration, the decisions to be made, stakeholders who need to be involved, it can sometimes feel overwhelming – and with good reason. A move to the cloud can take time, resources, and manpower, and while companies are nearly universally glad they made those investments, that doesn't cancel out the fact that they take strategic planning and up-front work."
                + "What do you need to plan for? Who needs to be involved (and when)? What roles and responsibilities need to be divided up? The answers vary a bit depending on your company size, the scope of your migration, and whether you have the budget (or need) for a migration partner."
                + "Below are the typical roles and responsibilities we see from successful migrations – and some tips to prepare your team for success. Because without the right team in place, missed deadlines, duplicative work, and post-migration workflow issues become much greater risks.";
        List<String> allMatches = new LinkedList<>();
        regexSearcher.setPattern("\\b[dD]e\\w*");
        regexSearcher.setMatcher(textForSearch);
        while (regexSearcher.findMatches()){
            allMatches.add(regexSearcher.returnGroup());
        }

        for(String word : allMatches){
            System.out.println(word);
        }
    }
}