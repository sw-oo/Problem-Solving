function solution(s) {
    let x = '';
    let xCount = 0;
    let otherCount = 0;
    let result = 0;
    
    for(let i = 0; i < s.length; i++) {
        if(xCount === 0) {
            x = s[i];
            xCount++;
            continue;
        }
       
        if(s[i] === x) xCount++;
        else otherCount++;
        
        if(xCount === otherCount) {
            result++;
            xCount = 0;
            otherCount = 0;
            continue;
        }
    }
    
    if(xCount > 0) {
        result++;
    }
    
    return result;
}