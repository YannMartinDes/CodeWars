function multiplyDigits(num: number): number {
	let currentNumber = num;
	let remainder = currentNumber % 10;
	let result = remainder;
	let quotient = Math.floor(currentNumber / 10);

	while (quotient > 0) {
		currentNumber = quotient;
		remainder = currentNumber % 10;
		result *= remainder;
		quotient = Math.floor(currentNumber / 10);
	}
	return result;
}

export function persistence(num: number): number {
	if (num < 10) {
		return 0;
	}
	let iterateNum = num;
	let persistence = 0;
	while (iterateNum >= 10 && persistence < 10) {
		iterateNum = multiplyDigits(iterateNum);
		persistence++;
	}
	return persistence;
}
