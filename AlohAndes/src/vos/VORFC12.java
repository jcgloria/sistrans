package vos;

import java.util.ArrayList;


public class VORFC12 {
	
	private ArrayList<VORFC12OF> ofertasMas = new ArrayList<>();
	
	private ArrayList<VORFC12OF> ofertasMenos = new ArrayList<>();

	private ArrayList<VORFC12OP> operadoresMas = new ArrayList<>();

	private ArrayList<VORFC12OP> operadoresMenos = new ArrayList<>();

	public VORFC12(ArrayList<VORFC12OF> ofertasMas, ArrayList<VORFC12OF> ofertasMenos,
			ArrayList<VORFC12OP> operadoresMas, ArrayList<VORFC12OP> operadoresMenos) {
		this.ofertasMas = ofertasMas;
		this.ofertasMenos = ofertasMenos;
		this.operadoresMas = operadoresMas;
		this.operadoresMenos = operadoresMenos;
	}

	public ArrayList<VORFC12OF> getOfertasMas() {
		return ofertasMas;
	}

	public void setOfertasMas(ArrayList<VORFC12OF> ofertasMas) {
		this.ofertasMas = ofertasMas;
	}

	public ArrayList<VORFC12OF> getOfertasMenos() {
		return ofertasMenos;
	}

	public void setOfertasMenos(ArrayList<VORFC12OF> ofertasMenos) {
		this.ofertasMenos = ofertasMenos;
	}

	public ArrayList<VORFC12OP> getOperadoresMas() {
		return operadoresMas;
	}

	public void setOperadoresMas(ArrayList<VORFC12OP> operadoresMas) {
		this.operadoresMas = operadoresMas;
	}

	public ArrayList<VORFC12OP> getOperadoresMenos() {
		return operadoresMenos;
	}

	public void setOperadoresMenos(ArrayList<VORFC12OP> operadoresMenos) {
		this.operadoresMenos = operadoresMenos;
	}
	
	

	

}
