
package database;

import model.Produto;
import java.util.*;

public class Banco {
    private static List<Produto> produtos = new ArrayList<>();
    private static int idAtual = 1;

    public static void adicionar(Produto p) {
        p.setId(idAtual++);
        produtos.add(p);
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static Produto buscarPorId(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public static void remover(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }

    public static void atualizar(Produto novo) {
        Produto antigo = buscarPorId(novo.getId());
        if (antigo != null) {
            antigo.setNome(novo.getNome());
            antigo.setDescricao(novo.getDescricao());
            antigo.setUnidadeCompra(novo.getUnidadeCompra());
            antigo.setQtdPrevistoMes(novo.getQtdPrevistoMes());
            antigo.setPrecoMaxComprado(novo.getPrecoMaxComprado());
        }
    }
}
