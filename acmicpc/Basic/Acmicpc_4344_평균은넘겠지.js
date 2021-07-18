const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString();
input = input.split("\n");

const inputC = +input[0];
const inputTestCase = [];

for (let i = 1; i <= inputC; i++) {
  const arr = input[i].split(" ").map((item) => +item);
  const newArr = [];
  for (let j = 1; j <= arr[0]; j++) {
    newArr.push(arr[j]);
  }
  const testCase = {
    N: arr[0],
    arr: newArr,
  };
  inputTestCase.push(testCase);
}

function solution(C, testCase) {
  for (let i = 0; i < C; i++) {
    let studentsNum = testCase[i].N;
    let sum = 0;

    for (let j = 0; j < studentsNum; j++) {
      sum += testCase[i].arr[j];
    }

    let avg = sum / studentsNum;
    let overAvg = 0;

    for (let j = 0; j < studentsNum; j++) {
      if (testCase[i].arr[j] > avg) {
        overAvg++;
      }
    }

    let answer = ((overAvg / studentsNum) * 100).toFixed(3);
    console.log(answer + "%");
  }
}

solution(inputC, inputTestCase);
