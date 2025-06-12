export function abbreviate(str: string): string {

  const newStr = str.replace(/[a-zA-Z]+/g, subAbbr);
  return newStr;
}  

function subAbbr(str:string):string {
  if(str.length < 4){
    return str;
  }
  return str[0] + (str.length -2) + str[str.length -1]
}
