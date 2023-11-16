# ApexInvest - ContaController

## Descrição do Controller

O `ContaController` é responsável por gerenciar as operações relacionadas às contas no sistema ApexInvest. Ele define endpoints para autenticação, cadastro de contas e transferência entre contas.

## Endpoints

### Login

- Método: `GET`
- Path: `/conta/{cpf}/{senha}`
- Descrição: Realiza o login do usuário com base no CPF e senha fornecidos.
- Retorno: Retorna um objeto `Conta` caso o login seja bem-sucedido, ou `null` caso contrário.

### Cadastrar Conta

- Método: `POST`
- Path: `/conta`
- Descrição: Cadastra uma nova conta no sistema.
- Parâmetros do Corpo (RequestBody): Objeto `Conta` contendo os detalhes da nova conta.
- Retorno: Retorna o objeto `Conta` cadastrado.

### Transferência

- Método: `PUT`
- Path: `/conta/Transf/{cpf}/{senha}/{email}/{valorTranf}`
- Descrição: Realiza uma transferência entre contas, validando CPF, senha e email.
- Parâmetros de Path (PathVariable):
    - `{cpf}`: Número de CPF do usuário.
    - `{senha}`: Senha de acesso do usuário.
    - `{email}`: Endereço de email do usuário.
    - `{valorTranf}`: Valor a ser transferido entre contas.
- Retorno: Retorna o objeto `Conta` origem após a transferência.

## Utilização dos Endpoints

- Para realizar o login, faça uma requisição GET para `/conta/{cpf}/{senha}`.
- Para cadastrar uma nova conta, faça uma requisição POST para `/conta`, fornecendo um objeto JSON de `Conta` no corpo da requisição.
- Para realizar uma transferência, faça uma requisição PUT para `/conta/Transf/{cpf}/{senha}/{email}/{valorTranf}`, fornecendo os valores necessários nos parâmetros do path.

## Exemplo de Utilização

```java
// Exemplo de login
Conta contaLogada = restTemplate.getForObject("/conta/12345678900/1234", Conta.class);
System.out.println("Conta logada: " + contaLogada);

// Exemplo de cadastro de conta
Conta novaConta = new Conta(...); // Preencha os detalhes da nova conta
Conta contaCadastrada = restTemplate.postForObject("/conta", novaConta, Conta.class);
System.out.println("Conta cadastrada: " + contaCadastrada);

// Exemplo de transferência
Conta contaOrigem = restTemplate.putForObject("/conta/Transf/12345678900/1234/maria@example.com/100.0", null, Conta.class);
System.out.println("Conta de origem após transferência: " + contaOrigem);
```
# ApexInvest

## Descrição da Classe Conta

A classe `Conta` é responsável por armazenar informações de contas no sistema ApexInvest. Ela inclui os atributos básicos de uma conta bancária, como ID, agência, número da conta, saldo, senha, nome do titular, CPF, telefone, email e idade.

## Atributos

- `id`: Identificador único da conta.
- `agencia`: Número da agência associado à conta.
- `numero`: Número da conta.
- `saldo`: Saldo atual da conta.
- `senha`: Senha de acesso à conta.
- `nome`: Nome completo do titular da conta.
- `cpf`: Número do CPF do titular da conta.
- `telefone`: Número de telefone do titular da conta.
- `email`: Endereço de email do titular da conta.
- `idade`: Idade do titular da conta.

## Construtores

- `Conta()`: Construtor padrão vazio.
- `Conta(id, agencia, numero, saldo, senha, nome, cpf, telefone, email, idade)`: Construtor personalizado que permite definir todos os atributos da conta.

## Métodos de Acesso

- Métodos getter e setter estão disponíveis para todos os atributos, permitindo a obtenção e definição dos valores.

## Funcionalidades Adicionais

- `equals(Object o)`: Método para comparar duas contas e verificar se são iguais.
- `hashCode()`: Método para gerar um código hash único para a conta.
- `toString()`: Método que retorna uma representação em string da conta, incluindo todos os seus atributos.

## Exemplo de Utilização

```java
// Criar uma nova instância de Conta usando o construtor personalizado
Conta conta = new Conta(1, 123, 456789, 1500.75, 1234, "João Silva", 12345678900L, 987654321L, "joao@example.com", 30);

// Acessar e modificar atributos usando os métodos getter e setter
conta.setSaldo(2000.0);
System.out.println("Saldo atual: " + conta.getSaldo());

// Verificar igualdade entre duas contas
Conta outraConta = new Conta(2, 123, 456789, 1500.75, 1234, "Maria Souza", 98765432100L, 123456789L, "maria@example.com", 28);
if (conta.equals(outraConta)) {
    System.out.println("As contas são iguais.");
} else {
    System.out.println("As contas são diferentes.");
}
```
# ApexInvest - Serviços

## Descrição da Classe Serviços

A classe `Servicos` é responsável por fornecer funcionalidades de serviços relacionados às operações bancárias no sistema ApexInvest. Ela inclui um método para realizar transferências entre contas.

## Método de Transferência

- Método: `transferencia(Conta origem, Conta destino, double valorTransferencia)`
- Descrição: Realiza uma transferência de fundos entre duas contas, debitando o valor da conta de origem e creditando-o na conta de destino.
- Parâmetros:
    - `origem`: Objeto `Conta` representando a conta de origem.
    - `destino`: Objeto `Conta` representando a conta de destino.
    - `valorTransferencia`: Valor a ser transferido entre as contas.
- Funcionalidade:
    - Verifica se a conta de origem possui saldo suficiente para a transferência.
    - Se o saldo for suficiente, subtrai o valor da conta de origem e adiciona o valor à conta de destino.
    - Se o saldo não for suficiente, retorna uma mensagem informando que a transferência não pode ser realizada.

## Exemplo de Utilização

```java
// Exemplo de utilização do método de transferência
Conta contaOrigem = new Conta(1, 123, 456789, 1500.75, 1234, "João Silva", 12345678900L, 987654321L, "joao@example.com", 30);
Conta contaDestino = new Conta(2, 456, 987654, 2000.50, 5678, "Maria Souza", 98765432100L, 123456789L, "maria@example.com", 28);

double valorTransferencia = 100.0;
Servicos.transferencia(contaOrigem, contaDestino, valorTransferencia);
```