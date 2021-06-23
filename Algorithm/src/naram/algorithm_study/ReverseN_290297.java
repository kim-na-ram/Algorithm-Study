package naram.algorithm_study;

public class ReverseN_290297 {
    public int[] solution(long n) {

        String st = Long.toString(n);

        int[] answer = new int[st.length()];

        int index = 0;

        for(int i = st.length() - 1; i >= 0; i--) {

            answer[index++] = Integer.parseInt(st.split("")[i]);

        }

        return answer;
    }
}