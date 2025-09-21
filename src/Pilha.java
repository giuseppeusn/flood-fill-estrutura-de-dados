public class Pilha {
    private int[][] dados; // armazena as cordenadas x e y
    private int topo;      // índice do elemento no topo da pilha

    public Pilha(int capacidade) {
        dados = new int[capacidade][2];
        topo = -1; //
    }

    // Logica para inserir na pilha
    public void push(int x, int y) {
        topo++;
        dados[topo][0] = x;
        dados[topo][1] = y;
    }

    // Logica para remover na pilha
    public int[] pop() {
        int[] valor = dados[topo];
        topo--;
        return valor;
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }
}
