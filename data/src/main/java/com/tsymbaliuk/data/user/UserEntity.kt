package com.tsymbaliuk.data.user

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class UserWithSubscriptionsAndSaves(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "userId",
        entityColumn = "categoryId"
    )
    val subscriptionCategoryLists: List<UserCategoryEntity>,
    @Relation(
        parentColumn = "userId",
        entityColumn = "sourceId"
    )
    val subscriptionSourceLists: List<UserSourceEntity>,
    @Relation(
        parentColumn = "userId",
        entityColumn = "articleId"
    )
    val savedArticleLists: List<UserArticleEntity>
)

@Entity
class UserEntity(
    @PrimaryKey
    var userId: Long,
    var email: String = "",
    var phoneNumber: String = "",
    var passwordHash: String = ""
)

@Entity
class UserCategoryEntity(
    @PrimaryKey
    var categoryId: Long,
    var userId: Long,
    var categoryName: String = ""
)

@Entity
class UserSourceEntity(
    @PrimaryKey
    var sourceId: Long,
    var userId: Long,
    var name: String = "",
    var description: String? = null,
    var url: String? = null,
    var category: String? = null,
    var language: String? = null,
    var country: String? = null
)

@Entity
class UserArticleEntity(
    @PrimaryKey
    var articleId: Long,
    var userId: Long,
    @Embedded
    var articleSource: ArticleSource?,
    var author: String = "",
    var title: String = "",
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
)

@Entity
data class ArticleSource(
    @PrimaryKey
    var articleSourceId: Long,
    var name: String = ""
)



