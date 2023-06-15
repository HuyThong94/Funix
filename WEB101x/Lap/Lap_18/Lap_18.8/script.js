//Lap18.8

//Lap18.8.1
console.log('Lap 18.8.1');
const mark = {
    fullName: 'Mark Miller',
    mass: 78,
    height: 1.69,
    calcBMI: function(){
        this.BMI = this.mass/[(this.height)^2];
        return this.BMI;
    },
};
const john = {
    fullName: 'John Smith',
    mass: 92,
    height: 1.95,
    calcBMI: function(){
        this.BMI = this.mass/[(this.height)^2];
        return this.BMI;
    }
};
mark.BMI = mark.calcBMI();
john.BMI = john.calcBMI();
let CompareBMI;
if(john.BMI > mark.BMI){
    CompareBMI = `John's BMI (${john.BMI}) is higher than Mark's (${mark.BMI})`;
}else{
    CompareBMI = `Mark's BMI (${mark.BMI}) is higher than John's (${john.BMI})`;
}
console.log(CompareBMI);

//Lap18.8.1
console.log('Lap 18.8.1');
const bills = new Array(22, 295, 176, 440, 37, 105, 10, 110, 86, 52);
const tips = new Array();
const totals = new Array();
function calcTip(bill){
    let tip;
    if(bill >= 50 && bill <= 300){
        tip = bill*0.15;
    }else{
        tip = bill*0.2;
    }
    return tip;
}
for(let i = 0; i < bills.length; i++){
    const tip = calcTip(bills[i]);
    const total = tip + bills[i];
    tips.push(tip);
    totals.push(total);
}
console.log(bills);
console.log(tips);
console.log(totals);
function calcAverage(totals){
    let sum = 0;
    for(let i = 0;i < totals.length; i++){
        sum += totals[i];
    }
    const average = sum/totals.length;
    return average;
}
const averageTotals = calcAverage(totals);
console.log(averageTotals);