//Lap16

//Lap16.1
// console.log('Lap 16.1');
// console.log('9' - '5');
// console.log('19' - '13' + '17');
// console.log('19' - '13' + 17);
// console.log('123' < 57);
// console.log(5 + 6 + '4' + 9 - 4 - 2);

//Lap16.2
// console.log('')
// console.log('Lap 16.2');
// let numNeighbours = prompt('How many neighbor countries does your country have?');
// // let numNeighbours = 1;
// if(numNeighbours == 1){
//     console.log('Only 1 border!');
// }else if(numNeighbours > 1){
//     console.log('More than 1 border');
// }else{
//     console.log('No borders');
// }

//Lap16.3
// console.log('')
// console.log('Lap 16.3');
// let country = prompt('What is the country you choose?')
// let language = prompt('What is the language in this country??');
// let population = prompt('What is the population of the country in millions?');
// let isIsland = prompt('What is the population of this country?(yes/no)');
// if(language == 'english' && population < 50 && isIsland == 'no'){
//     console.log('You should live in ' + country);
// }else{
//     console.log(country + ' does not meet your criteria ');
// }

//Lap16.4
// console.log('')
// console.log('Lap 16.4');
// let language = 'China';
// switch(language) {
//     case 'China':
//         console.log('MOST number of native speakers!');
//         break;
//     case 'Spannish':
//         console.log('2nd place in number of native speakers');
//         break;
//     case 'Spannish':
//         console.log('3rd place');
//         break;
//     case 'English':
//         console.log('Number 4');
//         break;
//     case 'Spannish':
//         console.log('5th most spoken language');
//         break;
//     default:
//         console.log('Great language too :D');
// }

//Lap16.5
// console.log('')
// console.log('Lap 16.5');
// let population = 30;
// population > 33? console.log(`Portugal's population is above average`) : console.log(`Portugal's population is below average`);

//Lap16.6
console.log('')
console.log('Lap 16.6');
console.log('Lap 16.6.1');
let GPADolphins;
let GPAKoalas;

// GPADolphins = (96 + 108 + 89)/3;
// GPAKoalas = ( 81 + 91 + 110)/3;

// GPADolphins = (97 + 112 + 101)/3;
// GPAKoalas = ( 109 + 95 + 123)/3;

GPADolphins = (97 + 112 + 101)/3;
GPAKoalas = ( 109 + 95 + 106)/3;
if(GPADolphins >= 100 & GPAKoalas >= 100){
    if(GPADolphins > GPAKoalas) { 
        console.log('Dolphins team win!');
    }else if(GPADolphins < GPAKoalas) { 
        console.log('Koalas team win!');
    }else{
        console.log('Koalas draw Dolphins!');
    }
}else if(GPADolphins < 100 & GPAKoalas >= 100){
    console.log('Koalas team win!');
}else if(GPADolphins >= 100 & GPAKoalas < 100){
    console.log('Dolphins team win!');
}else{
    console.log('No team wins!');
}
