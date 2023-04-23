package interleaving

import interleaving.data.Ranking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BalancedInterleavingTest {

    @Test
    fun interleave() {
        val rankingA = generateRanking(listOf("1", "2", "3"))
        val rankingB = generateRanking(listOf("4", "5", "6"))

        val actual = BalancedInterleaving<String>().interleave(rankingA = rankingA, rankingB = rankingB)

        assertEquals(listOf("1", "5", "6"), actual)
    }

    @Test
    fun interleaveSameItems() {
        val rankingA = generateRanking(listOf("1", "2", "3"))
        val rankingB = generateRanking(listOf("1", "2", "3"))

        val actual = BalancedInterleaving<String>().interleave(rankingA = rankingA, rankingB = rankingB)

        assertEquals(listOf("1", "2", "3"), actual)
    }

    private fun generateRanking(values: List<String>): List<Ranking<String>> {
        return values.mapIndexed { index, s -> Ranking(index = index, value = s, item = s) }
    }

}