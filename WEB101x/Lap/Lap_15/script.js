// alert("Hello world");
// let country;
// let continent;
let  polulation;
// country = 'Viet Nam';
// continent = 'Asia';
polulation = 100;

//lap 15.1

// let isIsland;
// let language;
// isIsland = false;
// console.log('Lap 15.1');
// console.log('Country: ' + country);
// console.log('polulation: ' + polulation);
// console.log('Island: ' + isIsland);
// console.log('Language: ' + language);

//Lap 15.2

const country = 'Viet Nam';
const continent = 'Asia';
const language = 'Vietnamese';
const isIsland = false;
// language = 'english';
console.log('Lap 15.2');
console.log('Country: ' + country);
console.log('polulation: ' + polulation);
console.log('Island: ' + isIsland);
console.log('Language: ' + language);

//Lap 15.3
//1
console.log('Lap 15.3.1');
console.log('polulation: ' + polulation/2);
//2
console.log('Lap 15.3.2');
polulation = 101;
console.log('polulation: ' + polulation/2);
//3
console.log('Lap 15.3.3');
let finland_polulation;
finland_polulation = 6;
if(polulation > finland_polulation){
    console.log(`Vietnam's population is more than ${finland_polulation}`);
}
//4
console.log('Lap 15.3.4');
let average_population;
average_population = 33;
if(polulation > average_population){
    console.log(`Vietnam's population is more than ${average_population}`);
}

//5
console.log('Lap 15.3.5');
let description;
description = country + ' and its ' + polulation + ' million people speak ' + language + '.' ;
console.log(description);

//Lap 15.4
console.log('Lap 15.4');
description = `${country} and its ${polulation} million people speak ${language}.`;
console.log(description);

//Lap 15.5.1
console.log('Lap 15.5.1');
if(polulation > average_population){
    console.log(`${country}'s population is above average.`);
}else{
    console.log(`${country}'s population is ${average_population - polulation}.`);
}

//Lap 15.5.2
console.log('Lap 15.5.2');
polulation = 13;
if(polulation > average_population){
    console.log(`${country}'s population is above average.`);
}else{
    console.log(`${country}'s population is ${average_population - polulation}.`);
}