// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// data class: nome e email identificam o aluno e já ganham equals/hashCode/toString gerados
data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    // vararg permite matricular um ou vários alunos numa única chamada
    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach { usuario ->
            // contains evita matrícula duplicada, já que Usuario é data class (equals por valor)
            if (!inscritos.contains(usuario)) {
                inscritos.add(usuario)
            }
        }
    }

    // scope function let para compor a carga horária total a partir dos conteúdos
    fun cargaHorariaTotal(): Int = conteudos.sumOf { it.duracao }
}

// função de extensão para exibir um resumo legível da formação
fun Formacao.imprimirResumo() {
    println("Formação: $nome")
    println("Nível: $nivel")
    println("Conteúdos:")
    conteudos.forEach { println(" - ${it.nome} (${it.duracao}min)") }
    println("Carga horária total: ${cargaHorariaTotal()}min")
    println("Alunos inscritos: ${inscritos.joinToString { it.nome }}")
    println()
}

fun main() {
    // Conteúdos educacionais
    val conteudosBackend = listOf(
        ConteudoEducacional("Kotlin Básico", 40),
        ConteudoEducacional("Orientação a Objetos em Kotlin"),
        ConteudoEducacional("Spring Boot com Kotlin", 90)
    )

    val conteudosFrontend = listOf(
        ConteudoEducacional("HTML e CSS", 30),
        ConteudoEducacional("JavaScript Moderno", 50),
        ConteudoEducacional("React.js", 80)
    )

    // Formações de níveis diferentes
    val formacaoBackend = Formacao("Kotlin para Backend", Nivel.INTERMEDIARIO, conteudosBackend)
    val formacaoFrontend = Formacao("Fundamentos de Frontend", Nivel.BASICO, conteudosFrontend)

    // Usuários (alunos)
    val cauê = Usuario("Cauê", "caue@email.com")
    val maria = Usuario("Maria", "maria@email.com")
    val joao = Usuario("João", "joao@email.com")

    // Matrícula usando vararg, com tentativa de duplicidade proposital
    formacaoBackend.matricular(cauê, maria)
    formacaoBackend.matricular(cauê) // não deve duplicar

    formacaoFrontend.matricular(maria, joao)

    // Resumo legível de cada formação
    formacaoBackend.imprimirResumo()
    formacaoFrontend.imprimirResumo()
}
