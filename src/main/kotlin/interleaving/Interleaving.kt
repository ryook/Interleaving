package interleaving

import interleaving.data.InterleavingInfo
import interleaving.data.Ranking


interface Interleaving<T> {
    fun interleave(rankingA: Ranking<T>, rankingB: Ranking<T>, topN: Int? = null): List<T>

    fun getInfo(): InterleavingInfo<T>
    
}