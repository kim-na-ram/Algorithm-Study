package naram.algorithm_study;

import java.util.Deque;
import java.util.ArrayDeque;

public class LeadingSkills_290328 {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        Deque<Character> deque = new ArrayDeque<>();

        for(int j = 0; j < skill_trees.length; j++) {

            boolean isRight = true;

            for(char c : skill.toCharArray())
                deque.offerLast(c);

            for(char c : skill_trees[j].toCharArray()) {

                if(deque.contains(c)) {
                    if(c == deque.peekFirst())
                        deque.pollFirst();
                    else {
                        isRight = false;
                        break;
                    }
                }

                System.out.println(skill_trees[j] + ", " + c);

            }

            if(isRight == true) answer++;

        }

        return answer;
    }
}