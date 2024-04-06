function selectionSort(array) {
  let length = array.length;
  for (let i = 0; i < length; i++) {
    let min = i;
    for (let j = i + 1; j < length; j++) {
      if (array[j] < array[min]) {
        min = j;
      }
    }
    if (min != i) {
      let tmp = array[i];
      array[i] = array[min];
      array[min] = tmp;
    }
  }
  return array;
}

let array = [25, 84, 3, 2, 11];

console.log(selectionSort(array));