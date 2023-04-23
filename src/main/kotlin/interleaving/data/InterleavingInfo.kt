package interleaving.data

import interleaving.code.RankingCode


data class InterleavingInfo<T>(
    val rankingA: Ranking<T>,
    val rankingB: Ranking<T>,
    val topN: Int?,
    val selectedItems: List<T>,
    val selectedRankings: List<RankingCode>,
    val selectedItemIndexes: List<Pair<Int?, Int?>>
)