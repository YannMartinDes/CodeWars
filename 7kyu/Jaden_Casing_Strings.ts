String.prototype.toJadenCase = function () {
  return this.split(" ").map(str => str[0].toUpperCase() + str.substr(1).toLowerCase()).join(" ")
}


interface String {      // Declaration needed, don't remove it
  toJadenCase(): string;
}
