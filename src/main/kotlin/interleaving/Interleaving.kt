package interleaving

import interleaving.data.InterleavingInfo
import interleaving.data.Ranking


interface Interleaving<T> {
    fun interleave(rankingA: List<Ranking<T>>, rankingB: List<Ranking<T>>, topN: Int? = null): List<T>

    fun getInfo(): InterleavingInfo<T>

}