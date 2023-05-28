//Lap17

//Lap17.7.1
console.log('Lap 17.7.1');
const calcAverage = (score1, score2, score3) => (score1 + score2 + score3)/3;
function checkWinner(avgDolphins, avgKoalas){
    if(avgDolphins > (avgKoalas*2)){
        return console.log(`Dolphins win (${avgDolphins} vs ${avgKoalas} )`);
    }
    if(avgKoalas > (avgDolphins*2)){
        return console.log(`Koalas win (${avgKoalas} vs ${avgDolphins})`);
    }
}
console.log('Data 1');
const dolPhinsScores1 = calcAverage(44 , 23, 71);
const koalasScores1 = calcAverage(65, 54, 49);
const checkWinner1 = checkWinner(dolPhinsScores1, koalasScores1);

console.log('Data 2');
const dolPhinsScores2 = calcAverage(85 , 54, 41);
const koalasScores2 = calcAverage(23, 34, 27);
const checkWinner2 = checkWinner(dolPhinsScores2, koalasScores2);

//Lap17.7.2
console.log('Lap 17.7.2');
function calcTip(bill){
    let tip;
    if(bill >= 50 && bill <= 300){
        tip = bill*0.15;
    }else{
        tip = bill*0.2;
    }
    return tip;
}
const bills = new Array(125, 555, 44);
const tips = new Array();
const total = new Array();
bills.forEach(element => {
    const tip = calcTip(element);
    const totalBill = tip + element;
    tips.push(tip);
    total.push(totalBill);
});
console.log(bills);
console.log(tips);
console.log(total);