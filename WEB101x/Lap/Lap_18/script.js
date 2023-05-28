//Lap18

//Lap18.1
console.log('Lap 18.1');
const myCountry = {
    country : 'Viet Nam',
    capital : 'Ha Noi',
    language : 'Vietnamese',
    population : 100,
    neighbours : ['laos', 'China', 'Cambodia']
}
console.log(myCountry);

console.log('Lap 18.2');
const vietNam = myCountry['country'] + ' has ' + myCountry.population + ' million ' + myCountry.language +'-speaking people, ' + myCountry['neighbours'].length + ' neighbours coutries and capital ' + myCountry['capital'];
console.log(vietNam);

myCountry.population = myCountry.population + 2;
console.log(myCountry.population);
myCountry['population'] = myCountry['population'] - 2;
console.log(myCountry['population']);