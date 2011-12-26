package control.ai;

import java.util.ArrayList;
import java.util.List;


public class CNF<T> {
	private List<Clause<T>> clauses;
	private TruthValues value;

	public CNF() {
		this.clauses = new ArrayList<Clause<T>>();
		this.value = TruthValues.UNKNOWN;
	}
	
	/**
	 * Updates CNF using the given knowledge.
	 * @param literalValue	Literal whose value we explicitly know
	 * @param sign	sign of the known literal
	 * @return TruthValues	returns VALID if whole CNF is valid, UNVALID if it
	 * 						is invalid or UNKNOWN if none of above could be yet
	 * 						Specified
	 */
	public void updateCNF(T literalValue, boolean sign) {
		List<Clause<T>> newClauses = new ArrayList<Clause<T>>();
		List<Literal<T>> knownLiterals = new ArrayList<Literal<T>>();
		for (Clause<T> c : clauses) {
			boolean valid = true;
			for (Literal<T> l : c.getLiterals()) {
				if (l.getValue().equals(literalValue)) {
					if (sign == l.getSign()) {
						// whole clause c is true - can be discarded
						valid = false;
						break;
					} else {
						// remove the literal l from the clause
						c.removeLiteral(literalValue);
						if (c.isEmpty()) {
							value = TruthValues.UNVALID;
							return;
						}
						break;
					}
				}
			}
			if (valid) {
				newClauses.add(c);
				if (c.getLiterals().size() == 1) {
					knownLiterals.add(c.getLiterals().get(0));
				}
			}
		}
		
		clauses = newClauses;
		for (Literal<T> l : knownLiterals) {
			updateCNF(l.getValue(), l.getSign());
		}
		if (clauses.size() == 0) {
			value = TruthValues.VALID;
		} else
			value = TruthValues.UNKNOWN;
		
	}
	
	public TruthValues resolution() {
		
		return TruthValues.UNKNOWN;
	}
	
	/**
	 * @return the clauses
	 */
	public List<Clause<T>> getClauses() {
		return clauses;
	}

	/**
	 * @param clauses the clauses to set
	 */
	public void setClauses(List<Clause<T>> clauses) {
		this.clauses = clauses;
	}
	
	/**
	 * adds given clause to the CNF
	 * @param clause	clause to add to the CNF
	 */
	public void addClause(Clause<T> clause) {
		this.clauses.add(clause);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String s = "";
		s += value.toString() + "\n";
		if (clauses.size() > 0) {
			s += clauses.get(0).toString();
			for (int i = 1; i < clauses.size(); i++) {
				s += " ^ " + clauses.get(i).toString();
			}
		}
		return s;
	}
}