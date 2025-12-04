package com.example.DailyUpdates.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


public class NewsResponse {

    int totalResults;
    List<Article> articles;
    String random;

    public NewsResponse(int totalResults, List<Article> articles, String random) {
        this.totalResults = totalResults;
        this.articles = articles;
        this.random = random;
    }

    public NewsResponse() {
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
