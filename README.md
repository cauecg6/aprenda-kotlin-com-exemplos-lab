# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**


```kotlin
TODO("Crie uma solução em Koltin abstraindo esse domínio. O arquivo [desafio.kt] te ajudará 😉")
```

## Solução

O domínio foi modelado em [desafio.kt](desafio.kt) da seguinte forma:

- **`Usuario`**: data class com `nome` e `email`, representando um aluno.
- **`ConteudoEducacional`**: data class com `nome` e `duracao` (padrão de 60 minutos).
- **`Formacao`**: data class com `nome`, `nivel` (enum `Nivel`) e a lista de `conteudos`. Mantém internamente a lista `inscritos` e expõe:
  - `matricular(vararg usuarios: Usuario)`: matricula um ou mais alunos de uma vez, evitando duplicidade (aproveitando o `equals` gerado pela data class `Usuario`).
  - `cargaHorariaTotal()`: soma a duração de todos os conteúdos da formação.
- A função de extensão `Formacao.imprimirResumo()` imprime um resumo legível (nome, nível, conteúdos, carga horária total e alunos inscritos).
- `main()` cria conteúdos, duas formações de níveis diferentes (`INTERMEDIARIO` e `BASICO`), três usuários, faz as matrículas (incluindo uma tentativa de matrícula duplicada, que é ignorada) e imprime o resumo de cada formação.

### Como executar

Com o JDK e o `kotlinc` instalados e no `PATH`:

```bash
kotlinc desafio.kt -include-runtime -d desafio.jar
java -jar desafio.jar
```
