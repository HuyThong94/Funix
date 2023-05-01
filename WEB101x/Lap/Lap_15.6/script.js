//Lap 15.6.1
console.log('Lap 15.6.1');
let BMI_mark;
let BMI_john;
let markHigherBMI; 
let mark_height;
let mark_mass;
let john_height;
let john_mass;

//ex1
console.log('ex1');
mark_height = 78;
mark_mass = 1.69;
john_height = 92;
john_mass = 1.95;
BMI_mark = mark_mass/(mark_height*mark_height);
BMI_john = john_mass/(john_height*john_height);
if(BMI_mark > BMI_john){
    markHigherBMI = true;
}else{
    markHigherBMI = false;
}
if(markHigherBMI){
    console.log('Mark BMI higher is than John BMI');
    console.log(`Mark BMI (${BMI_mark}) higher is than John BMI (${BMI_john})`);
}else{
    console.log('John BMI heigher is than Mark BMI');
    console.log(`John BMI (${BMI_john}) higher is than Mark BMI (${BMI_mark})`);
}
//ex2
console.log('ex2');
mark_height = 95;
mark_mass = 1.88;
john_height = 85;
john_mass = 1.76;
BMI_mark = mark_mass/(mark_height*mark_height);
BMI_John = john_mass/(john_height*john_height);
if(BMI_mark > BMI_john){
    markHigherBMI = true;
}else{
    markHigherBMI = false;
}
if(markHigherBMI){
    console.log('Mark BMI higher is than John BMI');
    console.log(`Mark BMI (${BMI_mark}) higher is than John BMI (${BMI_john})`);
}else{
    console.log('John BMI heigher is than Mark BMI');
    console.log(`John BMI (${BMI_john}) higher is than Mark BMI (${BMI_mark})`);

}