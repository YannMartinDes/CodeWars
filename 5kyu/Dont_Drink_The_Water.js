function countElements(glass, element) {
	let elementCount = 0;
	glass.forEach((row) => {
		row.forEach((cell) => {
			if (cell === element) {
				elementCount++;
			}
		});
	});
	return elementCount;
}

function separateLiquids(glass) {
	const liquids = [
		{ type: "O", count: countElements(glass, "O") },
		{ type: "A", count: countElements(glass, "A") },
		{ type: "W", count: countElements(glass, "W") },
		{ type: "H", count: countElements(glass, "H") },
	];

	const rowNb = glass.length;
	if (rowNb === 0) {
		return [];
	}
	const colNb = glass[0].length;
	const res = new Array(rowNb)
		.fill(null)
		.map(() => new Array(colNb).fill(null));

	for (let i = 0; i < rowNb; i++) {
		for (let j = 0; j < colNb; j++) {
			for (let liquid of liquids) {
				if (liquid.count > 0) {
					res[i][j] = liquid.type;
					liquid.count--;
					break;
				}
			}
		}
	}
	return res;
}
