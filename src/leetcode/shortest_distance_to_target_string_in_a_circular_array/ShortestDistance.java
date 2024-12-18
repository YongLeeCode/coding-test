package leetcode.shortest_distance_to_target_string_in_a_circular_array;

// 앞으로도 뒤로도 이동
// 이동해서 타겟 단어를 찾으면 return index 절대값
// 못 찾으면 -1 리턴

public class ShortestDistance {
    public static int closetTarget(String[] words, String target, int startIndex) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            int next = startIndex + i;
            int prev = startIndex - i;

            if (next >= words.length) {
                next = next - words.length;
            }
            if (prev < 0) {
                prev = words.length + prev;
            }
            if (target.equals(words[next]) || target.equals(words[prev])) {
                return count;
            }
            count++;
        }

        return -1;
    }
    public static void main(String[] args) {
        String[] words = {"a","b","leetcode"};
        String target = "leetcode";
        int startIndex = 0;

        int result = closetTarget(words, target, startIndex);
        System.out.println(result);
    }
}
