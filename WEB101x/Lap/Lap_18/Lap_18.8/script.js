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