package java;

public class Peca {
    private String tipo;
    private String cor;
    private String posicao;

    public Peca(String tipo, String cor, String posicao) {
        this.tipo = tipo;
        this.cor = cor;
        this.posicao = posicao;
    }

    public void moverPeca(String pos) {
        this.posicao = pos;
    }

    public boolean capturaPeca(String type, String posicaoOrigem, String posDestino) {
        if (!vericaPosicao(type, posicaoOrigem, posDestino)) {
            return false;
        }
        moverPeca(posDestino);
        return true;
    }

    public boolean vericaPosicao(String type, String posicaoOrigem, String posDestino) {
        if (type.equals("cavalo") && !(posicaoOrigem.equals(posDestino))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Peca [tipo=").append(tipo).append(", cor=").append(cor).append(", posicao=").append(posicao)
                .append("]");
        return builder.toString();
    }
}