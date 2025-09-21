class Pilha {
    private Pixel[] dados;
    private int topo;

    public Pilha(int capacidade) {
        dados = new Pixel[capacidade];
        topo = -1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public void empilhar(Pixel p) {
        if (topo < dados.length - 1) {
            dados[++topo] = p;
        }
    }

    public Pixel desempilhar() {
        if (!estaVazia()) {
            return dados[topo--];
        }
        return null;
    }
}