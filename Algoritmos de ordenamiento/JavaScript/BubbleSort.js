function bubbleSort(array) {
  let length = array.length;
  for (let i = 0; i < length; i++) {
    for (let j = 0; j < length - i - 1; j++) {
      if (array[j] > array[j + 1]) {
        let num = array[j];
        array[j] = array[j + 1];
        array[j + 1] = num;
      }
    }
  }
}

let array = [5, 4, 3, 2, 1];
bubbleSort(array);

console.log(array);
