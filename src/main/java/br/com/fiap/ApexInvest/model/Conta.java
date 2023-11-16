package br.com.fiap.ApexInvest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CONTA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CONTA_NUMERO", columnNames = "CONTA_NUMERO"),
        @UniqueConstraint(name = "UK_CONTA_CPF", columnNames = "CONTA_CPF"),
        @UniqueConstraint(name = "UK_CONTA_EMAIL", columnNames = "CONTA_EMAIL")
})
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONTA")
    @SequenceGenerator( name = "SQ_CONTA", sequenceName = "SQ_CONTA")
    @Column(name = "ID_CONTA")
    private long id;

    @Positive(message = "A agência deve ser um número positivo")
    @Column(name = "CONTA_AGENCIA", nullable = false)
    private long agencia;

    @Positive(message = "O número da conta deve ser um número positivo")
    @Column(name = "CONTA_NUMERO", nullable = false, unique = true)
    private long numero;

    @DecimalMin(value = "0.0", inclusive = true, message = "O saldo não pode ser negativo")
    @Column(name = "CONTA_SALDO", nullable = false)
    private double saldo;


    @Size(min = 6, max = 6, message = "A senha deve ter 6 dígitos")
    @Column(name = "CONTA_SENHA", nullable = false)
    private String senha;

    @NotBlank(message = "O nome não pode estar em branco")
    @Column(name = "CONTA_NOME", nullable = false)
    private String nome;

    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos")
    @Column(name = "CONTA_CPF", nullable = false, unique = true)
    private String cpf;

    @Size(min = 11, max = 11, message = "O número de telefone deve conter exatamente 11 dígitos")
    @Column(name = "CONTA_TELEFONE", nullable = false)
    private String telefone;

    @NotBlank(message = "O email não pode estar em branco")
    @Column(name = "CONTA_EMAIL", nullable = false, unique = true)
    private String email;

    @Min(value = 18, message = "A idade mínima permitida é 18 anos")
    @Max(value = 120, message = "A idade máxima permitida é 120 anos")
    @Column(name = "CONTA_IDADE", nullable = false)
    private int idade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return getId() == conta.getId() && getAgencia() == conta.getAgencia() && getNumero() == conta.getNumero() && getSenha() == conta.getSenha() && getCpf() == conta.getCpf() && getTelefone() == conta.getTelefone() && getIdade() == conta.getIdade() && Objects.equals(getSaldo(), conta.getSaldo()) && Objects.equals(getNome(), conta.getNome()) && Objects.equals(getEmail(), conta.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAgencia(), getNumero(), getSaldo(), getSenha(), getNome(), getCpf(), getTelefone(), getEmail(), getIdade());
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", senha=" + senha +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
