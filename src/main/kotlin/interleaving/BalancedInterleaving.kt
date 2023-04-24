package interleaving

import interleaving.data.RankingItem
import java.util.*


class BalancedInterleaving<T>(private val random: Random = Random()) : Interleaving<T> {
    override fun interleave(
        rankingA: List<RankingItem<T>>,
        rankingB: List<RankingItem<T>>,
        topN: Int?
    ): List<RankingItem<T>> {
        val results = mutableListOf<RankingItem<T>>()
        val rankingASize = rankingA.size
        val rankingBSize = rankingB.size

        val L = topN ?: if (rankingASize > rankingBSize) rankingASize else rankingBSize
        var pointerA = 0
        var pointerB = 0
        val checked = mutableSetOf<String>()

        val isAFirst = random.nextBoolean()

        while ((results.size < L && pointerA < rankingASize && pointerB < rankingBSize)) {
            if ((pointerA < pointerB) || (pointerA == pointerB && isAFirst)) {
                var item = rankingA[pointerA]
                if (!checked.contains(item.key)) {
                    results.add(item)
                    checked.add(item.key)
                }
                pointerA++
            } else {
                var item = rankingB[pointerB]
                if (!checked.contains(item.key)) {
                    results.add(item)
                    checked.add(item.key)
                }
                pointerB++
            }
        }
        return results

    }
}