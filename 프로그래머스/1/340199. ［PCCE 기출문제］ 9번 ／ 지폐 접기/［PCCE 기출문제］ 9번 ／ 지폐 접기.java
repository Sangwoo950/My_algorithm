class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int wMin = Math.min(wallet[0], wallet[1]);
        int wMax = Math.max(wallet[0], wallet[1]);
        int bW = bill[0];
        int bH = bill[1];

        while (true) {
            int bMin = Math.min(bW, bH);
            int bMax = Math.max(bW, bH);

            if (bMin <= wMin && bMax <= wMax) break;

            if (bW >= bH) bW /= 2;
            else bH /= 2;

            answer++;
        }

        return answer;
    }
}