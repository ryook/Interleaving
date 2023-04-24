package interleaving

import interleaving.data.RankingItem


interface Interleaving<T> {
    fun interleave(
        rankingA: List<RankingItem<T>>,
        rankingB: List<RankingItem<T>>,
        topN: Int? = null
    ): List<RankingItem<T>>
}