package exam4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {
    public static void solution(String[] genres, int[] plays) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        HashMap<String, List<Integer>> genreIndex = new HashMap<>();
        LinkedHashMap<Integer, Integer> music = new LinkedHashMap<>();

        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], plays[i] + map.getOrDefault(genres[i], 0));

            List<Integer> list = genreIndex.getOrDefault(genres[i], new ArrayList<>());
            list.add(i);
            genreIndex.put(genres[i], list);

            music.put(i, plays[i]);
        }

        LinkedHashMap<String, Integer> sortedMap = sortByValueDescending(map);
        LinkedHashMap<Integer, Integer> sortedMusic = sortByMusicValueDescending(music);
        System.out.println(map.entrySet());
        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            List<Integer> list = genreIndex.get(entry.getKey());
            for(int i = 0; i < 2; i++) {
                System.out.println(list.get(i));
            }
        }
    }

    private static LinkedHashMap<Integer, Integer> sortByMusicValueDescending(LinkedHashMap<Integer, Integer> music) {
        List<Entry<Integer, Integer>> entryList = new ArrayList<>(music.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    private static LinkedHashMap<String, Integer> sortByValueDescending(LinkedHashMap<String, Integer> map) {
        List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }
}
