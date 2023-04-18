package programmers_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, Integer> termsMap = new HashMap<>();
        for (String i : terms){
            String[] termArr = i.split(" ");
            termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        int[] startDate = {1970, 1, 1};
        int oneMonth = 28;
        int oneYear = 12;
        int todayDate = 0;
        ArrayList<Integer> answers = new ArrayList<>();
        String[] todayArr = today.split("\\.");
        for (int i = 0; i < 3; i++) {
            if (i == 0){
                todayDate += (Integer.parseInt(todayArr[i]) - startDate[i]) * oneYear * oneMonth;
            }
            else if (i == 1) {
                todayDate += (Integer.parseInt(todayArr[i]) - startDate[i]) * oneMonth;
            }
            else {
                todayDate += (Integer.parseInt(todayArr[i]) - startDate[i]);
            }
        }
        int idx = 0;
        for (String privacy : privacies) {
            idx++;
            String[] privacyArr = privacy.split(" ");
            int expireDate = termsMap.get(privacyArr[1]) * oneMonth;
            String[] privacyArr2 = privacyArr[0].split("\\.");
            for (int i = 0; i < 3; i++) {
                if (i == 0){
                expireDate += (Integer.parseInt(privacyArr2[i]) - startDate[i]) * oneYear * oneMonth;
                }
                else if (i == 1) {
                    expireDate += (Integer.parseInt(privacyArr2[i]) - startDate[i]) * oneMonth;
                }
                else {
                    expireDate += (Integer.parseInt(privacyArr2[i]) - startDate[i]);
                }
            }
            if (expireDate <= todayDate) {
                answers.add(idx);
            }
        }
        return answers.stream().mapToInt(i -> i).toArray();
    }
}