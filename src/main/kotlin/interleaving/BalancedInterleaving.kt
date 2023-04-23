package interleaving

import interleaving.data.InterleavingInfo
import interleaving.data.Ranking

class BalancedInterleaving<T> : Interleaving<T> {

    override fun interleave(rankingA: List<Ranking<T>>, rankingB: List<Ranking<T>>, topN: Int?): List<T> {
        TODO("Not yet implemented")
    }

    override fun getInfo(): InterleavingInfo<T> {
        TODO("Not yet implemented")
    }
}