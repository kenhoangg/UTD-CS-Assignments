function EvenOdd(n){
    if(isNaN(n)){
        console.log('Not a valid number.');
        return;
    }
    if(n===0){
        console.log('Even');
    }else if (n == 1){
        console.log('Odd'); 
    }else{
        return(EvenOdd(n-2));
    }
}

console.log(EvenOdd(5));
console.log(EvenOdd(10));
console.log(EvenOdd(255));
console.log(EvenOdd("One"));
console.log(EvenOdd(0));

function MyMathFunction(num1, num2, func){
     console.log(func(num1, num2));
}

function Add(num1, num2){
    return num1 + num2;
}

function Subtract(num1, num2){
    return num1 - num2;
}

function Divide(num1, num2){
    if(num2 === 0){
        console.log('Cannot Divide by 0!');
        return;
    }
    return num1 / num2;
}

function Multiply(num1, num2){
    return num1 * num2;
}

MyMathFunction(10, 10, Multiply);
MyMathFunction(50, 10, Divide);
MyMathFunction(10, 0, Divide);
MyMathFunction(20, 25, Add);
MyMathFunction(25, 20, Subtract);

function SortMyArray(arr) {
    if(arr.length === 0){
        console.log('Cannot sort an Empty Array!');
        return;
    }
    var done = false;
    while (!done) {
        done = true;
        for (var i = 1; i < arr.length; i += 1) {
          if (arr[i - 1] > arr[i]) {
            done = false;
            var tmp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = tmp;
            }
        }
    }
  return arr;
}

var arr1=[-3,8,7,6,5,-4,3,2,1];
console.log(SortMyArray(arr1));

var test_array=[1,2,3,4,5];
console.log(SortMyArray(test_array));

var test_array=[];
console.log(SortMyArray(test_array));

var test_array=[1,-1,-2,2,3,-3,-4,4,5,-5,0];
console.log(SortMyArray(test_array));

var test_array=[1, 1, 1, 100, 75, 2, 2, 37, 55, 55];
console.log(SortMyArray(test_array));

function myFib(n){
    if(!Number.isInteger(n)){
        console.log('Not an integer value!');
        return;
    }
    if(n === 0 | n === 1)
        return 1;
    else
        return myFib(n-1) + myFib(n-2);
}

console.log(myFib(5));
console.log(myFib(10));
console.log(myFib(8));
console.log(myFib("Thirtyfive"));
console.log(myFib(3.5));


