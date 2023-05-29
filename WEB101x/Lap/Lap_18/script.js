//Lap18

//Lap18.1
console.log('Lap 18.1');
const myCountry = {
    country : 'Finland',
    capital : 'Helsinki',
    language : 'finnish',
    population : 6,
    neighbours : ['laos', 'China', 'Cambodia']
}
console.log(myCountry);

console.log('Lap 18.2');
const vietNam = myCountry['country'] + ' has ' + myCountry.population + ' million ' + myCountry.language +'-speaking people, ' + myCountry['neighbours'].length + ' neighbours coutries and capital called ' + myCountry['capital'];
console.log(vietNam);

myCountry.population = myCountry.population + 2;
console.log(myCountry.population);
myCountry['population'] = myCountry['population'] - 2;
console.log(myCountry['population']);
myCountry['describe'] = 'Finland has 6 million finnish-speaking people, 3 neighbouring countries and a capital called Helsinki';
console.log(myCountry['describe']);
myCountry.checkIsland