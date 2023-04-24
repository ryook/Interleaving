package interleaving

import interleaving.data.RankingItem
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BalancedInterleavingTest {

    @Test
    fun interleave() {
        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("4", "5", "6"), "rankingB")

        val actual = BalancedInterleaving<String>().interleave(rankingA = rankingA, rankingB = rankingB)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(1, "2", item = "2", ranking = "rankingB"),
            RankingItem(2, "3", item = "3", ranking = "rankingA"),
        )
        assertEquals(expected, actual)
    }

    @Test
    fun interleaveSameItems() {
        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("1", "2", "3"), "rankingB")

        val actual = BalancedInterleaving<String>().interleave(rankingA = rankingA, rankingB = rankingB)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(1, "2", item = "2", ranking = "rankingB"),
            RankingItem(2, "3", item = "3", ranking = "rankingA"),
        )
        assertEquals(expected, actual)
    }

    @Test
    fun interleave2() {
        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("2", "1", "3"), "rankingB")

        val actual = BalancedInterleaving<String>().interleave(rankingA = rankingA, rankingB = rankingB)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(1, "2", item = "2", ranking = "rankingA"),
            RankingItem(2, "3", item = "3", ranking = "rankingA"),
        )
        assertEquals(expected, actual)
    }

    private fun generateRanking(values: List<String>, rankingSource: String): List<RankingItem<String>> {
        return values.mapIndexed { index, s -> RankingItem(index = index, key = s, item = s, ranking = rankingSource) }
    }

}