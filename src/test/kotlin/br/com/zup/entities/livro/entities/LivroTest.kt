package br.com.zup.entities.livro.entities

import br.com.zup.entities.livro.entities.Livro
import br.com.zup.entities.livro.repositories.LivroRepository
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(
    rollback = false, // por padrao vem true, faz o rollback de todos os testes para nao poluir o banco
    transactionMode = TransactionMode.SINGLE_TRANSACTION,// por padrao vem como SEPARATE_TRANSACTIONS para cada teste executar uma transacao separada
    transactional = false // isso desliga o controlle transacional que o micronaut tem, agora cada chamada ao repositorio sera auto-commit por padrao
)
class LivroTest {

    @Inject
    lateinit var livroRepository: LivroRepository

    @BeforeEach
    internal fun setUp() {
        livroRepository.deleteAll()
    }

    @AfterEach
    internal fun cleanUp() {
        livroRepository.deleteAll()
    }

    @Test
    internal fun `deve inserir um novo livro`() {
        livroRepository.save(
            Livro(
                nome = "A Arte da Guerra",
                autor = "Sun Tzu",
                categoria = "Estratégia",
                isbn = "321321"
            )
        )

        // validacao
        assertEquals(1, livroRepository.count())
        // commit
    }

    @Test
    internal fun `deve encontrar livro por isbn`() {
        // cenario

        val livroSalvo = livroRepository.save(
            Livro(
                nome = "A Arte da Guerra",
                autor = "Sun Tzu",
                categoria = "Estratégia",
                isbn = "321321"
            )
        )

        // acao
        val livroEncontrado = livroRepository.existsByIsbn(livroSalvo.isbn)

        // validacao
        assertTrue(livroEncontrado)
    }


}
