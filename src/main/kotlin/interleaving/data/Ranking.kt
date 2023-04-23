package interleaving.data

data class Ranking<T>(
    val index: Int,
    val value: String,
    val item: T
)
