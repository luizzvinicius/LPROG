package java;

import java.util.List;

public class Departamento {
    private List<Empregado> empregados;
    private String nome;
    private long id;
    private String localizacao;

    public Departamento(String nome, long id, String localizacao) {
        this.nome = nome;
        this.id = id;
        this.localizacao = localizacao;
    }

    public void addEmpregado(Empregado e) {
        this.empregados.add(e);
    }

    public void removeEmprego(Empregado e) {
        this.empregados.remove(e);
    }

    public long getId() {
        return id;
    }

    public void atualizaEmpregado(Empregado e, String nome, String cargo, double salario) {
        e.setNome(nome);
        e.setCargo(cargo);
        e.setSalario(salario);
    }
}