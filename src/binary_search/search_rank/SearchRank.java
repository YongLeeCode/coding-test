package binary_search.search_rank;

import java.util.Arrays;

public class SearchRank {
    public static int[] solution(String[] info, String[] query) {
        String[][] information = new String[info.length][];
        String[][] queries = new String[query.length][];
        int[] result = new int[query.length];

        for(int i = 0; i < info.length; i++){
            information[i] =  info[i].split(" ");
        }

        for(int i = 0; i < query.length; i++){
            queries[i] = query[i].split(" and ");
        }

        for(int i = 0; i < queries.length; i++){
//            if(query)
        }

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        int[] result =  solution(info, query);
        //결과 [1,1,1,1,2,4]
        System.out.println(Arrays.toString(result));
    }
}
