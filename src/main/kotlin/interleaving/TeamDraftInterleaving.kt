package interleaving

import interleaving.data.RankingItem
import java.util.*

class TeamDraftInterleaving<T>(private val random: Random = Random()) : Interleaving<T> {

    override fun interleave(
        rankingA: List<RankingItem<T>>,
        rankingB: List<RankingItem<T>>,
        topN: Int?
    ): List<RankingItem<T>> {
        val resuls = mutableListOf<RankingItem<T>>()
        val teamA = mutableListOf<String>()
        val teamB = mutableListOf<String>()
        val rankingASize = rankingA.size
        val rankingBSize = rankingB.size

        val L = topN ?: if (rankingASize > rankingBSize) rankingASize else rankingBSize
        var pointerA = 0
        var pointerB = 0
        val checked = mutableSetOf<String>()

        while (resuls.size < L && pointerA < rankingASize && pointerB < rankingBSize) {
            val isAFirst = random.nextBoolean()
            if (teamA.size < teamB.size || (teamA.size == teamB.size && isAFirst)) {
                var item = rankingA.filter { !checked.contains(it.key) }.getOrNull(0);
                if (item != null) {
                    resuls.add(item)
                    checked.add(item.key)
                    teamA.add(item.key)

                }
                pointerA++
            } else {
                var item = rankingB.filter { !checked.contains(it.key) }.getOrNull(0);
                if (item != null) {
                    resuls.add(item)
                    checked.add(item.key)
                    teamB.add(item.key)

                }
                pointerB++
            }
        }

        return resuls
    }
}