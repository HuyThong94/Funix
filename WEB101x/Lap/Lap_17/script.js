//Lap17

//Lap17.1
console.log('Lap 17.1');
function describeCountry(country, population, capitalCity){
    const text = country + ' has ' + population + ' million people its capital is ' + capitalCity;
    return text
}
const finland = describeCountry('finland', 6, 'Helsinki');
const vietNam =  describeCountry('Viet Nam', 100, 'Ha Noi');
const usa = describeCountry('USA', 100, 'washington DC');
console.log(finland);
console.log(vietNam);
console.log(usa);

//Lap17.2
console.log('Lap 17.2');
function percentageOfWorld1(population){
    const percent = (population/7.9)*100 + '%';
    return percent
}

const china = percentageOfWorld1(1.441);
const vietnam = percentageOfWorld1(0.1);
console.log(china);
console.log(vietnam);
const percentageOfWorld2 = function (population){
    return ((population/7.9)*100 + '%');
}
const india = percentageOfWorld2(1);
console.log(india);