import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        
        for(int i = 0; i< park.length; i++){
            for(int j = 0; j < park[i].length; j++){
                // 돗자리를 깔 자리가 생기면
                if(park[i][j].equals("-1")){
                    for(int m = 0; m < mats.length; m++){
                        int rMax = i + mats[m] - 1;
                        int cMax = j + mats[m] - 1;
                        
                        //돗자리가 공원을 나가지 않는지 확인
                        if(rMax <= park.length -1 && cMax <= park[i].length -1){
                            //돗자리를 깔 자리에 다른 돗자리가 있는지 확인
                            boolean chk = true;
                            
                            for(int r = i; r<= rMax; r++){
                                for(int c = j; c <= cMax ;c++){
                                    //다른 돗자리가 있음
                                    if(!park[r][c].equals("-1")){
                                        chk = false;
                                    }
                                }
                                
                            }
                            
                            //돗자리 깔 자리에 다른 돗자리 있으면 넘김
                            if(!chk)
                                break;
                            
                            //가장 큰 돗자리를 구하기 위함
                            if(answer < mats[m])
                                answer = mats[m];
                        }
                    }
                }
            }
        }
        
        //어떤 돗자리도 깔 수 없음
        if(answer == 0)
            answer = -1;
        
        return answer;
    }
}