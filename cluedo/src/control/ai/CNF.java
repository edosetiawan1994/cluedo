package control.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import aima.core.logic.propositional.algorithms.KnowledgeBase;


public class CNF<T> extends KnowledgeBase {
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
		List<Clause<T>> resolvents = new ArrayList<Clause<T>>();
		List<Clause<T>> removeClauses = new ArrayList<Clause<T>>();
		List<Clause<T>> newList = clauses;
		//TODO copy clauses
		int counter = 0;
		while (true) {
			if (counter > 20) {
				// prevents infinite loop
				return TruthValues.UNKNOWN;
			}
			List<List<Clause<T>>> pairs = generatePairsOfClauses(newList);
			for (int i = 0; i < pairs.size(); i++) {
				List<Clause<T>> pair = pairs.get(i);
				Clause<T> c1 = pair.get(0);
				Clause<T> c2 = pair.get(1);
				Clause<T> resolved = resolveClauses(c1, c2);
				if (resolved != null) { 
					// clauses were resolved! new clause has been generated
					if (resolved.isEmpty()) {
						return TruthValues.UNVALID;
					}
					resolvents.add(resolved);
					removeClauses.add(c1);
					removeClauses.add(c2);
				}
			}
			newList.removeAll(removeClauses);
			newList.addAll(resolvents);
			resolvents.clear();
			removeClauses.clear();
			
			counter++;
		}
	}
	
	/**
	 * Returns all literals in the CNF (contained in at least one clause)
	 * with their quantity.
	 * @return	HashMap with Literals and their quantities.
	 */
	public HashMap<Literal<T>, Integer> getAllLiterals() {
		HashMap<Literal<T>, Integer> hm = new HashMap<Literal<T>, Integer>();
		for (Clause<T> c : clauses) {
			for (Literal<T> l : c.getLiterals()) {
				if (hm.containsKey(l)) {
					Integer oldValue = hm.get(l);
					hm.put(l, oldValue + 1);
				} else {
					hm.put(l, 1);
				}
			}
		}
		return hm;
	}
	
	/**
	 * Generates all possible pairs of clauses from given clause list.
	 * @param clauseList list of clauses
	 * @return	list of pairs (lists) of clauses
	 */
	private List<List<Clause<T>>> generatePairsOfClauses(List<Clause<T>> clauseList) {
		List<List<Clause<T>>> listOfPairs = new ArrayList<List<Clause<T>>>();
		for (Clause<T> c1 : clauseList) {
			for (Clause<T> c2 : clauseList) {
				List<Clause<T>> pair = new ArrayList<Clause<T>>();
				pair.add(c1);
				pair.add(c2);
				listOfPairs.add(pair);
			}
		}
		return listOfPairs;
	}
	
	/**
	 * If clauses can be resolved (there is same literal in both clauses with
	 * different sign) it resolves them, returns NULL otherwise. If one of the
	 * clauses is Empty, return empty clause.
	 * @param c1	first clause
	 * @param c2	second clause
	 * @return NULL if clauses cannot be resolved, otherwise resolved Clause
	 */
	private Clause<T> resolveClauses(Clause<T> c1, Clause<T> c2) {
		int index1 = -1, index2 = -1;		
		
		if (c1.isEmpty() || c2.isEmpty()) {
			return new Clause<T>();
		}
		
		for (int i = 0; i < c1.getLiterals().size(); i++) {
			for (int j = 0; j < c2.getLiterals().size(); j++) {
				Literal<T> l1 = c1.getLiterals().get(i);
				Literal<T> l2 = c2.getLiterals().get(j);
				if (l1.getValue().equals(l2.getValue())) {
					if (l1.getSign() != l2.getSign()) {
						// combine both clauses and remove l1, l2
						index1 = i;
						index2 = j;
						break;
					} 
				}
			}
		}
		if (index1 != -1) {
			Clause<T> result = new Clause<T>();
			for (int i = 0; i < c1.getLiterals().size(); i++) {
				if (i != index1) {
					result.addLiteral(c1.getLiterals().get(i));
				}
			}
			for (int j = 0; j < c2.getLiterals().size(); j++) {
				if (j != index2) {
					result.addLiteral(c2.getLiterals().get(j));
				}
			}
			return result;
		}
		return null;
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