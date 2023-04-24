package interleaving.data

data class RankingItem<T>(
    val index: Int,
    val key: String,
    val item: T,
    val ranking: String
)