//Lap18

//Lap18.1
console.log('Lap 18.1');
const myCountry = {
    country : 'Finland',
    capital : 'Helsinki',
    language : 'finnish',
    population : 6,
    neighbours : ['laos', 'China', 'Cambodia'],
    describe: function(){
        this.describe = this.country + ' has ' + this.population + ' million ' + this.language +'-speaking people, ' + this.neighbours.length 
        + ' neighbours coutries and capital called ' + this.capital;
        return this.describe;
    },
    checkIsland: function(){
        if(this.neighbours.length != 0){
            this.isIsland = false;
        }else{
            this.isIsland = true;
        }
        return this.isIsland;
        
    }
};
console.log(myCountry);

//Lap18.2
console.log('Lap 18.2');
const finland = myCountry['country'] + ' has ' + myCountry.population + ' million ' + myCountry.language +'-speaking people, ' + myCountry['neighbours'].length + ' neighbours coutries and capital called ' + myCountry['capital'];
console.log(finland);

myCountry.population = myCountry.population + 2;
console.log(myCountry.population);
myCountry['population'] = myCountry['population'] - 2;
console.log(myCountry['population']);

//Lap18.3
console.log('Lap 18.3');
console.log(myCountry.describe());
console.log(myCountry.checkIsland());

//Lap18.4
console.log('Lap 18.4');
for(let i = 0; i <= 50; i++){
    console.log('Voter number 1 is currently voting');
}

//Lap18.5
console.log('Lap 18.5');
const populations = new Array(1441, 100, 3, 1000);
function percentageOfWorld1(population){
    const percent = (population/7900)*100 + '%';
    return percent
}
const percentages2 = new Array();
for(let i = 0; i < populations.length; i++){
    const percent = percentageOfWorld1(populations[i]);
    percentages2.push(percent);
}
console.log(percentages2);

//Lap18.6
console.log('Lap 18.6');
const listOfNeighbours = new Array(['Canada', 'Mexico'], ['Spain'], ['Norway', 'Sweden', 'Russia']);
console.log(listOfNeighbours);
for(let i = 0; i < listOfNeighbours.length; i++){
    for(let j = 0; j < listOfNeighbours[i].length; j++){
        if(j > 0){
            console.log(listOfNeighbours[i][j]);
        }
    }
}

//Lap18.7
console.log('Lap 18.7');
const percentages3 = new Array();
let idx = 0;
while(idx < populations.length){
    const percent = percentageOfWorld1(populations[idx]);
    percentages3.push(percent);
    idx++;
}
console.log(percentages3);