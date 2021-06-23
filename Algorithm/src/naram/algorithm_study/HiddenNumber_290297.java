package naram.algorithm_study;

public class HiddenNumber_290297 {
    public String solution(String phone_number) {
        String answer = "";

        int to = phone_number.length();
        int from = to - 4;

        String fourletter = phone_number.substring(from, to);

        for(int i = 0; i < from; i++) answer += "*";

        answer = answer.concat(fourletter);

        return answer;
    }
}