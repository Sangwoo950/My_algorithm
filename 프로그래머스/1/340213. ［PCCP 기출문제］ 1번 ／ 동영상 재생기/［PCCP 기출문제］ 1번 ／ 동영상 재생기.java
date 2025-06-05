class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSeconds(video_len);
        int position = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        for (String cmd : commands) {
            // 오프닝 스킵 (명령 수행 전)
            if (opStart <= position && position <= opEnd) {
                position = opEnd;
            }

            if (cmd.equals("prev")) {
                position = Math.max(0, position - 10);
            } else if (cmd.equals("next")) {
                position = Math.min(videoLen, position + 10);
            }

            // 오프닝 스킵 (명령 수행 후)
            if (opStart <= position && position <= opEnd) {
                position = opEnd;
            }
        }

        return toTime(position);
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        return min * 60 + sec;
    }

    private String toTime(int seconds) {
        int min = seconds / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d", min, sec);
    }
}