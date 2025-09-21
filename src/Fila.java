public class Fila {
    private int[][] dados; // armazena as cordenadas x e y
    private int inicio;    // posição do primeiro elemento
    private int fim;       // posição do último elemento

    public Fila(int capacidade) {
        dados = new int[capacidade][2];
        inicio = 0;
        fim = -1;
    }

    // Adiciona um elemento na fila
    public void enqueue(int x, int y) {
        fim++;
        dados[fim][0] = x;
        dados[fim][1] = y;
    }

    // Remove um elemento na fila
    public int[] dequeue() {
        int[] valor = dados[inicio];
        inicio++;
        return valor;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return inicio > fim;
    }
}
