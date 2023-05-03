package interleaving

import interleaving.data.RankingItem
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.*
import kotlin.test.assertEquals

class TeamDraftInterleavingTest {

    @Test
    fun interleave_startFromA() {
        val mockRandom = mock(Random::class.java)
        `when`(mockRandom.nextBoolean()).thenReturn(true)

        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("4", "5", "6"), "rankingB")

        val actual = TeamDraftInterleaving<String>(mockRandom).interleave(rankingA = rankingA, rankingB = rankingB)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(0, "4", item = "4", ranking = "rankingB"),
            RankingItem(1, "2", item = "2", ranking = "rankingA"),
        )
        assertEquals(expected, actual)
    }

    @Test
    fun interleave_startFromB() {
        val mockRandom = mock(Random::class.java)
        `when`(mockRandom.nextBoolean()).thenReturn(false)

        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("4", "5", "6"), "rankingB")

        val actual = TeamDraftInterleaving<String>(mockRandom).interleave(rankingA = rankingA, rankingB = rankingB)

        val expected = listOf(
            RankingItem(0, "4", item = "4", ranking = "rankingB"),
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(1, "5", item = "5", ranking = "rankingB"),
        )
        assertEquals(expected, actual)
    }

    @Test
    fun interleaveSameItems_startFromA() {
        val mockRandom = mock(Random::class.java)
        `when`(mockRandom.nextBoolean()).thenReturn(true)

        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("1", "2", "3"), "rankingB")

        val actual = TeamDraftInterleaving<String>(mockRandom).interleave(rankingA = rankingA, rankingB = rankingB)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(1, "2", item = "2", ranking = "rankingB"),
            RankingItem(2, "3", item = "3", ranking = "rankingA"),
        )
        assertEquals(expected, actual)
    }

    @Test
    fun interleave_setTop2() {
        val mockRandom = mock(Random::class.java)
        `when`(mockRandom.nextBoolean()).thenReturn(true)

        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("4", "5", "6"), "rankingB")

        val actual =
            TeamDraftInterleaving<String>(mockRandom).interleave(rankingA = rankingA, rankingB = rankingB, topN = 2)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(0, "4", item = "4", ranking = "rankingB"),
        )
        assertEquals(expected, actual)
    }

    @Test
    fun interleave_setTop5() {
        val mockRandom = mock(Random::class.java)
        `when`(mockRandom.nextBoolean()).thenReturn(true)

        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("4", "5", "6"), "rankingB")

        val actual =
            TeamDraftInterleaving<String>(mockRandom).interleave(rankingA = rankingA, rankingB = rankingB, topN = 5)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(0, "4", item = "4", ranking = "rankingB"),
            RankingItem(1, "2", item = "2", ranking = "rankingA"),
            RankingItem(1, "5", item = "5", ranking = "rankingB"),
            RankingItem(2, "3", item = "3", ranking = "rankingA"),
        )
        assertEquals(expected, actual)
    }

    @Test
    fun interleaveSameItems_setTop5() {
        val mockRandom = mock(Random::class.java)
        `when`(mockRandom.nextBoolean()).thenReturn(true)

        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
        val rankingB = generateRanking(listOf("1", "2", "3"), "rankingB")

        val actual =
            TeamDraftInterleaving<String>(mockRandom).interleave(rankingA = rankingA, rankingB = rankingB, topN = 5)

        val expected = listOf(
            RankingItem(0, "1", item = "1", ranking = "rankingA"),
            RankingItem(1, "2", item = "2", ranking = "rankingB"),
            RankingItem(2, "3", item = "3", ranking = "rankingA"),
        )
        assertEquals(expected, actual)
    }

//    fun interleave_allExpected() {
//        val mockRandom = mock(Random::class.java)
//        `when`(mockRandom.nextBoolean()).thenReturn(true)
//
//        val rankingA = generateRanking(listOf("1", "2", "3"), "rankingA")
//        val rankingB = generateRanking(listOf("1", "2", "3"), "rankingB")
//
//        val actual =
//            TeamDraftInterleaving<String>(mockRandom).interleave(rankingA = rankingA, rankingB = rankingB, topN = 5)
//        val expected = listOf(
//            listOf(
//                    RankingItem(0, "1", item = "1", ranking = "rankingA"),
//                    RankingItem(0, "4", item = "4", ranking = "rankingB"),
//                    RankingItem(1, "2", item = "2", ranking = "rankingA"),
//                ),
//            listOf(
//                    RankingItem(0, "1", item = "1", ranking = "rankingA"),
//                    RankingItem(0, "4", item = "4", ranking = "rankingB"),
//                    RankingItem(1, "5", item = "5", ranking = "rankingB"),
//                ),
//            listOf(
//                    RankingItem(0, "4", item = "4", ranking = "rankingB"),
//                    RankingItem(1, "1", item = "1", ranking = "rankingA"),
//                    RankingItem(2, "2", item = "2", ranking = "rankingA"),
//                ),
//            listOf(
//                    RankingItem(0, "4", item = "4", ranking = "rankingB"),
//                    RankingItem(1, "1", item = "1", ranking = "rankingA"),
//                    RankingItem(2, "5", item = "5", ranking = "rankingB"),
//                ),
//            )
//
//        assertContentEquals(expected, actual)
//
//    }

    private fun generateRanking(values: List<String>, rankingSource: String): List<RankingItem<String>> {
        return values.mapIndexed { index, s -> RankingItem(index = index, key = s, item = s, ranking = rankingSource) }
    }

}