package org.example.beatlesYellowSubmarinePackage;

public class SongContainsSubstringVerifier {
    public static void containsSubstringCheck(String song, String line) {
        try {
            if (!song.contains(line))
                throw new BeatlesException();
            System.out.println("Song contains this line!!!");
        } catch (BeatlesException e) {
            System.out.println(e.getMessage());
        }
    }
}
