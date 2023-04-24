package interleaving

import interleaving.data.RankingItem

class BalancedInterleaving<T> : Interleaving<T> {
    override fun interleave(
        rankingA: List<RankingItem<T>>,
        rankingB: List<RankingItem<T>>,
        topN: Int?
    ): List<RankingItem<T>> {
        TODO("Not yet implemented")
    }
}