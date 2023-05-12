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
