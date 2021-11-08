let arr = [1,1,1,2,2,3,4,5,3,8,5,6,67,4];
let ans = [];

for(let e of arr){
    let flag = true;
    for(let i of ans){
        if(i==e){
            flag = false;
            break;
        }
    }
    if(flag==true) {
        ans.push(e);
    }
}

console.log(ans);

