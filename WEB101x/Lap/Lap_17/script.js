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
    const percent = (population/7900)*100 + '%';
    return percent
}

const china = percentageOfWorld1(1441);
const vietnam = percentageOfWorld1(100);
console.log(china);
console.log(vietnam);
const percentageOfWorld2 = function (population){
    return ((population/7900)*100 + '%');
}
const india = percentageOfWorld2(1000);
console.log(india);

//Lap17.3
console.log('lap 17.3');
const percentageOfWorld3 = (population) => ((population/7900)*100 + '%');
const finlands = percentageOfWorld3(3);
console.log('percent of Finland: ' + finlands);

//Lap17.4
console.log('Lap 17.4');
function describePopulation(country, population){
    const percent = percentageOfWorld1(population);
    const string = country + ' has '+ population + ' million people, which is about ' + percent + ' of the world';
    return string;
}
const chinaString = describePopulation('China', 1441);
console.log(chinaString);

//Lap17.5
console.log('Lap 17.5');
const populations = new Array(1441, 100, 3, 1000);
console.log(populations.length == 4);
const percentages = new Array();
for(let i = 0; i < populations.length; i++){
    const percentTageOfWorld = percentageOfWorld1(populations[i]);
    percentages.push(percentTageOfWorld);
}
console.log(percentages);

//Lap17.6
console.log('Lap 17.6');
const neighbours = new Array('Laos', 'China', 'Cammbodia');
neighbours.push('Utopia');
console.log('neighbours add Utopia:');
console.log(neighbours);
neighbours.pop();
console.log('neighbours remove Utopia:');
console.log(neighbours);
const germany = neighbours.includes('Germany');
if(!germany){
    console.log('Probably not a central European country :D');
}
const idx = neighbours.indexOf('China');
neighbours[idx] = 'Republic of China';
console.log(neighbours);
