class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        // 등차 수열인지 확인
        if (common[2] - common[1] == common[1] - common[0]) {
            int diff = common[1] - common[0];
            answer = common[common.length - 1] + diff;
        } 
        // 등비 수열인 경우
        else {
            int ratio = common[1] / common[0];
            answer = common[common.length - 1] * ratio;
        }

        return answer;
    }
}