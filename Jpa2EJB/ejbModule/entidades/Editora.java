package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Editora implements Serializable {

    @Id
    private int codigo;
    @Column(nullable = false)
    private String nome;
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private Collection<Livro> livros;

    public Editora(){
        livros = new ArrayList<Livro>();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Collection<Livro> livros) {
        this.livros = livros;
    }

    public void addLivro(Livro l){
        livros.add(l);
        l.setEditora(this);
    }
    
    @Override
    public String toString() {
        return codigo + "," + nome;
    }
}
