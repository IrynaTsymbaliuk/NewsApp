package com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source

class FakeApiService {

    fun getNews(country: String, apiKey: String):
            NewsResponse {
        val newsResponse =
            NewsResponse(
                "ok",
                38,
                listOf<Article>(
                    Article(
                        NewsSource(
                            "politico",
                            "politico"
                        ),
                        null,
                        "Trump reboots TV ad strategy with focus on early-voting states - POLITICO",
                        "The president's campaign unexpectedly went dark on TV earlier this week as new campaign manager Bill Stepien conducts a spending review.",
                        "https://www.politico.com/news/2020/07/31/trump-tv-ad-strategy-early-voting-states-389845",
                        "https://static.politico.com/32/ce/171c4c4945f49393a0ea065cc4be/190412-bill-stepien-ap-773.jpg",
                        "2020-07-31T22:04:00Z",
                        "Trump advisers declined to specify which states the ads would be focused on, but there are several key battlegrounds at the front of the early voting calendar. Either in-person or mail-in voting will… [+1306 chars]"
                    ),
                    Article(
                        NewsSource(
                            "cnn",
                            "CNN"
                        ),
                        "Oliver Darcy and Brian Stelter, CNN",
                        "James Murdoch resigns from the board of News Corp, citing 'disagreements over certain editorial content' - CNN",
                        "James Murdoch, the youngest son of billionaire media mogul Rupert Murdoch, resigned on Friday from the board of News Corp in a dramatic break from the family business.",
                        "https://www.cnn.com/2020/07/31/media/james-murdoch-resigns-news-corp/index.html",
                        "https://cdn.cnn.com/cnnnext/dam/assets/200731174228-james-murdoch-file-super-tease.jpg",
                        "2020-07-31T21:54:00Z",
                        "New York (CNN Business)James Murdoch, the youngest son of billionaire media mogul Rupert Murdoch, resigned on Friday from the board of News Corp in a dramatic break from the family business.\r\nIn his … [+1854 chars]"
                    ),
                    Article(
                        NewsSource(
                            "google-new",
                            "Google News"
                        ),
                        null,
                        "'Ellen' Producer Faces Sexual Misconduct Allegations - Inside Edition",
                        null,
                        "https://news.google.com/__i/rss/rd/articles/CBMiK2h0dHBzOi8vd3d3LnlvdXR1YmUuY29tL3dhdGNoP3Y9ODZ5ZDJoR2VqZEXSAQA?oc=5",
                        null,
                        "2020-07-31T21:43:34Z",
                        null
                    )
                )
            )
        return newsResponse
    }


    fun getAllCategories(): List<String> {
        return listOf(
            "business",
            "entertainment",
            "general",
            "health",
            "science",
            "sports",
            "technology"
        )
    }


    fun getAllSource(apiKey: String): SourceResponse {
        val sourceResponseList =
            SourceResponse(
                "ok",
                listOf<Source>(
                    Source(
                        "abc-news",
                        "ABC News",
                        "Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
                        "https://abcnews.go.com",
                        "general",
                        "en",
                        "us"
                       ),
                    Source(
                        "abc-news-au",
                        "ABC News (AU)",
                        "Australia's most trusted source of local, national and world news. Comprehensive, independent, in-depth analysis, the latest business, sport, weather and more.",
                        "http://www.abc.net.au/news",
                        "general",
                        "en",
                        "au"
                    ),
                    Source(
                        "aftenposten",
                        "Aftenposten",
                        "Norges ledende nettavis med alltid oppdaterte nyheter innenfor innenriks, utenriks, sport og kultur.",
                        "https://www.aftenposten.no",
                        "general",
                        "no",
                        "no"
                    ),
                    Source(
                        "abc-news",
                        "ABC News",
                        "Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
                        "https://abcnews.go.com",
                        "general",
                        "en",
                        "us"
                    ),
                    Source(
                        "abc-news-au",
                        "ABC News (AU)",
                        "Australia's most trusted source of local, national and world news. Comprehensive, independent, in-depth analysis, the latest business, sport, weather and more.",
                        "http://www.abc.net.au/news",
                        "general",
                        "en",
                        "au"
                    )
                )
            )
        return sourceResponseList
    }


}