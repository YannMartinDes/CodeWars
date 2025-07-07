function generateFormula(str) {
  const setFormula = new Set();

  const clauses = str.split("AND");
  for (const clause of clauses) {
    const setClauses = new Set();
    const literals = clause.replace("(", "").replace(")", "").split("OR");
    for (const lit of literals) {
      setClauses.add(lit.trim());
    }
    setFormula.add(setClauses);
  }
  return setFormula;
}

function negateLiteral(literal) {
  return literal.startsWith("!") ? literal.slice(1) : `!${literal}`;
}

// -------- Unit propagation
function returnFirstUnitClause(formula) {
  for (const clause of formula) {
    if (clause.size === 1) {
      return Array.from(clause)[0];
    }
  }
  return null;
}

function unitPropagationElimination(formula) {
  const finalFormula = new Set(formula);

  let unitClause = returnFirstUnitClause(finalFormula);
  while (unitClause !== null) {
    const clausesToDelete = new Set();
    const clausesToAdd = new Set();

    for (const clause of finalFormula) {
      if (clause.has(unitClause)) {
        clausesToDelete.add(clause);
      } else if (clause.has(negateLiteral(unitClause))) {
        const newClause = new Set(clause);
        newClause.delete(negateLiteral(unitClause));
        clausesToDelete.add(clause);
        clausesToAdd.add(newClause);
      }
    }

    for (const clause of clausesToDelete) {
      finalFormula.delete(clause);
    }
    for (const clause of clausesToAdd) {
      finalFormula.add(clause);
    }

    unitClause = returnFirstUnitClause(finalFormula);
  }

  return finalFormula;
}

// -------- Tautology
function removeTautologies(formula) {
  const finalFormula = new Set(formula);

  for (const clause of formula) {
    for (const literal of clause) {
      if (clause.has(negateLiteral(literal))) {
        finalFormula.delete(clause);
        break;
      }
    }
  }
  return finalFormula;
}

// -------- Pure literal
function findFirstPureLiteral(formula) {
  const allLiterals = new Set();

  for (const clause of formula) {
    for (const literal of clause) {
      allLiterals.add(literal);
    }
  }
  for (const literal of allLiterals) {
    if (!allLiterals.has(negateLiteral(literal))) {
      return literal;
    }
  }
  return null;
}

function pureLiteralElimination(formula) {
  const finalFormula = new Set(formula);

  let pureLiteral = findFirstPureLiteral(finalFormula);
  while (pureLiteral !== null) {
    const clausesToDelete = new Set();
    for (const clause of finalFormula) {
      if (clause.has(pureLiteral)) {
        clausesToDelete.add(clause);
      }
    }
    for (const clause of clausesToDelete) {
      finalFormula.delete(clause);
    }
    pureLiteral = findFirstPureLiteral(finalFormula);
  }

  return finalFormula;
}

// ---- Davis-Putnam part
function findFirstBothPolarityLiteral(formula) {
  const allLiterals = new Set();

  for (const clause of formula) {
    for (const literal of clause) {
      allLiterals.add(literal);
    }
  }
  for (const literal of allLiterals) {
    if (allLiterals.has(negateLiteral(literal))) {
      return literal;
    }
  }
  return null;
}

function davisPutnamPart(formula, literal) {
  let finalFormula = new Set(formula);

  const negatedLiteral = negateLiteral(literal);
  const newFormula = new Set();

  const posClause = Array.from(finalFormula).filter(clause =>
    clause.has(literal)
  );
  const negClause = Array.from(finalFormula).filter(clause =>
    clause.has(negatedLiteral)
  );

  for (const pos of posClause) {
    for (const neg of negClause) {
      const newClause = new Set([...pos, ...neg]);
      newClause.delete(literal);
      newClause.delete(negatedLiteral);
      newFormula.add(newClause);
    }
  }

  for (const clause of posClause) {
    finalFormula.delete(clause);
  }
  for (const clause of negClause) {
    finalFormula.delete(clause);
  }

  for (const clause of newFormula) {
    finalFormula.add(clause);
  }

  return finalFormula;
}

function isPossible(expression) {
  let formula = generateFormula(expression);

  while (true) {
    formula = unitPropagationElimination(formula);
    formula = removeTautologies(formula);
    formula = pureLiteralElimination(formula);

    if (formula.size === 0) {
      return true; // Satisfiable
    }
    for (const clause of formula) {
      if (clause.size === 0) {
        return false; // Unsatisfiable
      }
    }

    const literal = findFirstBothPolarityLiteral(formula);
    if (literal === null) {
      return false;
    }

    formula = davisPutnamPart(formula, literal);
  }
}
