function solution(record) {
    let answer = [];
    let userMap = new Map();

    // 1. 닉네임 정보 최신화
    for (let entry of record) {
        let [action, uid, nickname] = entry.split(" ");
        if (action === "Enter" || action === "Change") {
            userMap.set(uid, nickname);
        }
    }

    // 2. 메시지 생성
    for (let entry of record) {
        let [action, uid] = entry.split(" ");
        if (action === "Enter") {
            answer.push(`${userMap.get(uid)}님이 들어왔습니다.`);
        } else if (action === "Leave") {
            answer.push(`${userMap.get(uid)}님이 나갔습니다.`);
        }
    }

    return answer;
}